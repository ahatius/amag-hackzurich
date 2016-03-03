package ch.amag.webtech.hackathon.controller;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileReader;
import java.io.FilenameFilter;
import java.io.IOException;
import java.io.InputStream;
import java.io.Reader;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashSet;
import java.util.List;
import java.util.Random;
import java.util.Set;

import org.apache.commons.csv.CSVFormat;
import org.apache.commons.csv.CSVRecord;
import org.apache.commons.io.IOUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestController;

import ch.amag.webtech.hackathon.entities.Vehicle;
import ch.amag.webtech.hackathon.entities.VehicleEquipmentList;
import ch.amag.webtech.hackathon.entities.VehicleImageRaw;
import ch.amag.webtech.hackathon.entities.VehicleList;
import ch.amag.webtech.hackathon.entities.VehicleOverview;
import ch.amag.webtech.hackathon.entities.VehicleOverviewList;
import ch.amag.webtech.hackathon.repository.VehicleEquipmentRepository;
import ch.amag.webtech.hackathon.repository.VehicleImageRawRepository;
import ch.amag.webtech.hackathon.repository.VehicleOverviewRepository;
import ch.amag.webtech.hackathon.repository.VehicleRepository;

@RestController
@RequestMapping("/vehicle")
@ComponentScan(basePackages = { "ch.amag.webtech.hackathon" })
public class VehicleController {
  @Autowired
  private VehicleRepository vehicleRepository;
  
  @Autowired
  private VehicleOverviewRepository vehicleOverviewRepository;
  
  @Autowired
  private VehicleEquipmentRepository equipmentRepository;
  
  @Autowired
  private VehicleImageRawRepository imageRepository;
  
  @Value("${vehiclesFile}")
  private String vehiclesFilePath;
  
  @Value("${vehicleImagesFolder}")
  private String vehicleImagesFolder;
  
  private Integer amagDealers[] = {1,90,92,100,140,150,151,155,165,173,190,200,219,220,227,232,240,241,244,254,260,277,320,330,348,350,359,364,369,373,376,380,400,450,460,500,501,523,570,600,610,620,635,645,650,676,680,690,698,710,739,760,790,798,3100,3125,3346,3537,6114,6136,6601,6696,6810,6831,6841};
  
  @RequestMapping(value = "/{vin}", method = RequestMethod.GET)
  public Vehicle getVehicle(@PathVariable String vin) {
    return vehicleRepository.findOne(vin);
  }
  
  @RequestMapping(value = "/{vin}/equipment", method = RequestMethod.GET)
  public VehicleEquipmentList getVehicleEquipment(@PathVariable String vin) {
    return new VehicleEquipmentList(equipmentRepository.findByVin(vin));
  }
  
  @RequestMapping(value = {"", "/"}, method = RequestMethod.GET)
  public VehicleList getAllVehicles() {
    List<Vehicle> vehicles = new ArrayList<Vehicle>();
    
    for(Vehicle vehicle : vehicleRepository.findAll()) {
      vehicles.add(vehicle);
    }
    
    return new VehicleList(vehicles);
  }
  
  @RequestMapping(value = "/random/{amount}", method = RequestMethod.GET)
  public VehicleList getRandomAmountOfVehicles(@PathVariable int amount) {
    return new VehicleList(vehicleRepository.findRandomAmount(amount));
  }
  
  @RequestMapping(value = "/random/{amount}/brand/{brand}", method = RequestMethod.GET)
  public VehicleList getRandomAmountOfVehicles(@PathVariable int amount, @PathVariable String brand) {
    return new VehicleList(vehicleRepository.findRandomAmountOfBrand(amount, brand));
  }
  
  @RequestMapping(value = "/category/{category}")
  public VehicleList getVehiclesByCategory(@PathVariable String category) {
    List<Vehicle> vehicles = new ArrayList<Vehicle>();
    
    for(Vehicle vehicle : vehicleRepository.findByCategory(category)) {
      vehicles.add(vehicle);
    }
    
    return new VehicleList(vehicles);
  }
  
  @RequestMapping(value = "/overview", method = RequestMethod.GET)
  public VehicleOverviewList getAllVehiclesOverview() {
    List<VehicleOverview> vehicles = new ArrayList<VehicleOverview>();
    
    for(VehicleOverview vehicle : vehicleOverviewRepository.findAll()) {
      vehicles.add(vehicle);
    }
    
    return new VehicleOverviewList(vehicles);
  }
  
  @RequestMapping(value = "/reload/confirm", method = RequestMethod.GET)
  @ResponseStatus(value = HttpStatus.OK)
  public void reloadVehicles() throws IOException {
    Random random = new Random();
    List<Integer> amagDealerList = Arrays.asList(this.amagDealers);
    
    vehicleRepository.deleteAll();
    
    Reader in = new FileReader(vehiclesFilePath);
    Iterable<CSVRecord> records = CSVFormat.DEFAULT.withDelimiter(";".toCharArray()[0]).withHeader().parse(in);
    
    List<Vehicle> vehicles = new ArrayList<Vehicle>();
    File imagesFolder = new File(vehicleImagesFolder);
    
    for (CSVRecord record : records) {
      Vehicle vehicle = new Vehicle();  
      vehicle.setVin(record.get("TIBodyNo"));
      vehicle.setCommission(record.get("OfferNumber"));
      vehicle.setDealer(Integer.valueOf(record.get("ContractNo")));
      vehicle.setSaleType(record.get("TIType"));
      vehicle.setExteriorColor(record.get("TIColor"));
      vehicle.setAddedValueDescription(record.get("TIAddedValueDesc"));
      //vehicle.setRemarks(record.get("TIRemarks"));
      vehicle.setMileage(Integer.valueOf(record.get("TIMilage")));
      vehicle.setFirstRegistration(record.get("TIFirstRegistration"));
      vehicle.setInteriorColor(record.get("TIColorInterior"));
      vehicle.setGuaranty(record.get("TIUCGuaranty"));
      vehicle.setPrice(Integer.valueOf(record.get("TIPriceOut")));
      vehicle.setLastInspection(record.get("TILastMFK"));
//      vehicle.setSwissTypeNumber(record.get("TICHTypeNo"));
      try {
        vehicle.setModelYear(Integer.valueOf(record.get("TICarModelDate")));
      } catch (NumberFormatException e) {
        vehicle.setModelYear(0);
      }
      vehicle.setAdditionalTitle(record.get("TIAdditionTitle"));
      //vehicle.setImported(Boolean.valueOf(record.get("TIDPImport")));

      /*
      if(record.get("TIAccident").toLowerCase().equals("j")) {
        vehicle.setCarDamagedInAccident(true);
      } else {
        vehicle.setCarDamagedInAccident(false);
      }
      */
      
      final String commission = vehicle.getCommission();
      
      String[] images = imagesFolder.list(new FilenameFilter() {
          public boolean accept(File dir, String name) {
              return name.contains(commission);
          }
      });
      
      this.insertImages(images, vehicle.getVin());
      
      if(!amagDealerList.contains(vehicle.getDealer())) {
        vehicle.setDealer(amagDealerList.get(random.nextInt(amagDealerList.size())));
      }
      
      vehicles.add(vehicle);
    }
    
    vehicleRepository.saveBatch(vehicles);
  }
  
  @RequestMapping(value = "/reloadimages", method = RequestMethod.GET)
  @ResponseStatus(value = HttpStatus.OK)
  public void reloadVehicleImages() throws IOException {
    File imagesFolder = new File(vehicleImagesFolder);
    
    for(Vehicle vehicle : vehicleRepository.findAll()) {
      final String commission = vehicle.getCommission();
      
      String[] images = imagesFolder.list(new FilenameFilter() {
          public boolean accept(File dir, String name) {
              return name.contains(commission);
          }
      });
      
      if(images.length > 0) {
        this.insertImages(images, vehicle.getVin());
      }
    }
  }
  
  private Set<VehicleImageRaw> insertImages(String[] imageNames, String vin) throws IOException {
    Arrays.sort(imageNames);
    
    List<VehicleImageRaw> vehicleRawImages = new ArrayList<VehicleImageRaw>();
    
    for(String imageName : imageNames) {
      InputStream is = new FileInputStream(this.vehicleImagesFolder + "/" + imageName);
      byte[] byteArray = IOUtils.toByteArray(is);
      
      VehicleImageRaw image = new VehicleImageRaw();
      image.setVin(vin);
      image.setImageData(byteArray);
      image.setName(imageName);
      vehicleRawImages.add(image);
    }
    
    Set<VehicleImageRaw> set = new HashSet<VehicleImageRaw>(vehicleRawImages);
    
    imageRepository.save(set);
    
    return set;
  }
}
