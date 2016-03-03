package ch.amag.webtech.hackathon.controller;

import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;
import java.net.URL;
import java.nio.channels.Channels;
import java.nio.channels.FileChannel;
import java.nio.channels.ReadableByteChannel;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import org.jdom.Document;
import org.jdom.Element;
import org.jdom.JDOMException;
import org.jdom.input.SAXBuilder;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestController;

import ch.amag.webtech.hackathon.entities.Dealer;
import ch.amag.webtech.hackathon.entities.DealerList;
import ch.amag.webtech.hackathon.entities.Vehicle;
import ch.amag.webtech.hackathon.entities.VehicleList;
import ch.amag.webtech.hackathon.entities.VehicleOverview;
import ch.amag.webtech.hackathon.entities.VehicleOverviewList;
import ch.amag.webtech.hackathon.repository.DealerRepository;
import ch.amag.webtech.hackathon.repository.VehicleOverviewRepository;
import ch.amag.webtech.hackathon.repository.VehicleRepository;

@RestController
@RequestMapping("/dealer")
@ComponentScan(basePackages = { "ch.amag.webtech.hackathon" })
public class DealerController {
  @Autowired
  private DealerRepository dealerRepository;
  
  @Autowired
  private VehicleRepository vehicleRepository;
  
  @Autowired
  private VehicleOverviewRepository vehicleOverviewRepository;
  
  @Value("${dealersDownloadFolder}")
  private String dealersDownloadFolder;
  
  private Integer amagDealers[] = {1,90,92,100,140,150,151,155,165,173,190,200,219,220,227,232,240,241,244,254,260,277,320,330,348,350,359,364,369,373,376,380,400,450,460,500,501,523,570,600,610,620,635,645,650,676,680,690,698,710,739,760,790,798,3100,3125,3346,3537,6114,6136,6601,6696,6810,6831,6841};
  
  @RequestMapping(value = "/{dealerId}", method = RequestMethod.GET)
  public Dealer getDealer(@PathVariable Integer dealerId) {
    return dealerRepository.findOne(dealerId);
  }
  
  @RequestMapping(value = {"", "/"}, method = RequestMethod.GET)
  public DealerList getAllDealers() {
    List<Dealer> dealers = new ArrayList<Dealer>();
    
    for(Dealer dealer : dealerRepository.findAll()) {
      dealers.add(dealer);
    }
    
    return new DealerList(dealers);
  }
  
  @RequestMapping(value = "/{dealerId}/vehicles", method = RequestMethod.GET)
  public VehicleList getAllVehiclesFromDealer(@PathVariable Integer dealerId) {
    List<Vehicle> vehicles = new ArrayList<Vehicle>();
    
    for(Vehicle vehicle : vehicleRepository.findByDealer(dealerId)) {
      vehicles.add(vehicle);
    }
    
    return new VehicleList(vehicles);
  }
  
  @RequestMapping(value = "/{dealerId}/vehicles/overview", method = RequestMethod.GET)
  public VehicleOverviewList getAllVehiclesOverviewFromDealer(@PathVariable Integer dealerId) {
    List<VehicleOverview> vehicles = new ArrayList<VehicleOverview>();
    
    for(VehicleOverview vehicle : vehicleOverviewRepository.findByDealer(dealerId)) {
      vehicles.add(vehicle);
    }
    
    return new VehicleOverviewList(vehicles);
  }
  
  @RequestMapping(value = "/reload", method = RequestMethod.GET)
  @ResponseStatus(value = HttpStatus.OK)
  public void reloadVehicles() throws IOException {
    List<Integer> amagDealerList = Arrays.asList(this.amagDealers);
    
    dealerRepository.deleteAll();
    
    String sources[] = {
        "audi::http://dealers.amag.ch/collection/DealerLocator/AUDI_de-CH_DealerLocator_.xml",
        "seat::http://dealers.amag.ch/collection/DealerLocator/SEATs_de-CH_DealerLocator_.xml",
        "skoda::http://dealers.amag.ch/collection/DealerLocator/SKODAs_de-CH_DealerLocator_.xml",
        "vw::http://dealers.amag.ch/collection/DealerLocator/VW_de-CH_DealerLocator_.xml",
        "vwnf::http://dealers.amag.ch/collection/DealerLocator/VWNF_de-CH_DealerLocator_.xml"
        };
    
    for(String source : sources) {
      String sourceInformation[] = source.split("::");
      String brand = sourceInformation[0];
      String url = sourceInformation[1];
      
      try {
        String filePath = dealersDownloadFolder + brand + ".xml";
        ReadableByteChannel in = Channels.newChannel(new URL(url).openStream());
        FileOutputStream outputStream = new FileOutputStream(filePath);
        FileChannel channel = outputStream.getChannel();
        
        channel.transferFrom(in, 0, Long.MAX_VALUE);
        
        channel.close();
        outputStream.close();
        
        SAXBuilder builder = new SAXBuilder();
        File xmlFile = new File(filePath);
        
        Document document = (Document) builder.build(xmlFile);
        Element rootNode = document.getRootElement();
        Element dealersNode = rootNode.getChild("Dealers");
        @SuppressWarnings("rawtypes")
        List dealerList = dealersNode .getChildren("Dealer");
        
        for(int i = 0; i < dealerList.size(); i++) {
          Element dealerNode = (Element) dealerList.get(i);
          
          boolean isSales = Boolean.parseBoolean(dealerNode.getChildText("IsSales"));
          
          if(!isSales) {
            continue;
          }
          
          int dealerId = Integer.valueOf(dealerNode.getChildText("GlobalID"));
          
          if(!amagDealerList.contains(dealerId)) {
            continue;
          }
          
          Dealer dealer = dealerRepository.findOne(dealerId);
          
          if(dealer == null) {
            dealer = new Dealer();
            
            String address = dealerNode.getChildText("Street");
            String city = dealerNode.getChildText("City");
            String dealerName = dealerNode.getChildText("Name");
            String fax = dealerNode.getChild("MainContact").getChildText("Fax");
            String mail = dealerNode.getChild("MainContact").getChildText("Mail");
            String phone = dealerNode.getChild("MainContact").getChildText("Telephone");
            
            int zip = Integer.valueOf(dealerNode.getChildText("ZipCode"));
            
            double latitude = Double.parseDouble(dealerNode.getChildText("Latitude"));
            double longitude = Double.parseDouble(dealerNode.getChildText("Longitude"));
            
            if(dealerName.toLowerCase().equals("amag automobil- und motoren ag") || dealerName.toLowerCase().equals("amag automobili e motori sa") || dealerName.toLowerCase().equals("amag automobiles et moteurs sa")) {
              dealerName = "AMAG " + city;
              dealer.setAmagDealer(true);
            } else {
              dealer.setAmagDealer(false);
            }
            
            dealer.setId(Integer.valueOf(dealerNode.getChildText("GlobalID")));
            dealer.setName(dealerName);
            dealer.setAddress(address);
            dealer.setCity(dealerNode.getChildText("City"));
            dealer.setZip(zip);
            dealer.setFax(fax);
            dealer.setPhone(phone);
            dealer.setMail(mail);
            dealer.setLatitude(latitude);
            dealer.setLongitude(longitude);
          }
          
          boolean sales = Boolean.parseBoolean(dealerNode.getChildText("IsSales"));
          boolean service = Boolean.parseBoolean(dealerNode.getChildText("IsService"));
          
          switch(brand) {
            case "audi":
              dealer.setAudiSales(sales);
              dealer.setAudiService(service);
              break;
              
            case "seat":
              dealer.setSeatSales(sales);
              dealer.setSeatService(service);
              break;
              
            case "skoda":
              dealer.setSkodaSales(sales);
              dealer.setSkodaService(service);
              break;
              
            case "vw":
              dealer.setVwSales(sales);
              dealer.setVwService(service);
              break;
              
            case "vwnf":
              dealer.setVwnfSales(sales);
              dealer.setVwnfService(service);
              break;
          }
          
          dealerRepository.save(dealer);
        }
      } catch (JDOMException e) {
        e.printStackTrace();
      }
    }
  }
}
