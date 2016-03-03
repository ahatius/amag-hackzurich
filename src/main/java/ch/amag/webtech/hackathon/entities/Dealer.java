package ch.amag.webtech.hackathon.entities;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;
import javax.xml.bind.annotation.XmlRootElement;

@Entity
@XmlRootElement(name = "dealer")
@Table(name = "dealer")
public class Dealer {
  @Id
  private int id;
  private String name;
  private String city;
  private int zip;
  private String address;
  private String phone;
  private String fax;
  private String mail;
  
  private double latitude;
  private double longitude;
  
  @Column(name = "audi_sales")
  private boolean audiSales;
  @Column(name = "audi_service")
  private boolean audiService;
  @Column(name = "seat_sales")
  private boolean seatSales;
  @Column(name = "seat_service")
  private boolean seatService;
  @Column(name = "skoda_sales")
  private boolean skodaSales;
  @Column(name = "skoda_service")
  private boolean skodaService;
  @Column(name = "vw_sales")
  private boolean vwSales;
  @Column(name = "vw_service")
  private boolean vwService;
  @Column(name = "vwnf_sales")
  private boolean vwnfSales;
  @Column(name = "vwnf_service")
  private boolean vwnfService;
  @Column(name = "amag_dealer")
  private boolean amagDealer;
  
  public double getLatitude() {
    return latitude;
  }

  public void setLatitude(double latitude) {
    this.latitude = latitude;
  }

  public double getLongitude() {
    return longitude;
  }

  public void setLongitude(double longitude) {
    this.longitude = longitude;
  }
  
  public boolean isAudiSales() {
    return audiSales;
  }

  public void setAudiSales(boolean audiSales) {
    this.audiSales = audiSales;
  }

  public boolean isAudiService() {
    return audiService;
  }

  public void setAudiService(boolean audiService) {
    this.audiService = audiService;
  }

  public boolean isSeatSales() {
    return seatSales;
  }

  public void setSeatSales(boolean seatSales) {
    this.seatSales = seatSales;
  }

  public boolean isSeatService() {
    return seatService;
  }

  public void setSeatService(boolean seatService) {
    this.seatService = seatService;
  }

  public boolean isSkodaSales() {
    return skodaSales;
  }

  public void setSkodaSales(boolean skodaSales) {
    this.skodaSales = skodaSales;
  }

  public boolean isSkodaService() {
    return skodaService;
  }

  public void setSkodaService(boolean skodaService) {
    this.skodaService = skodaService;
  }

  public boolean isVwSales() {
    return vwSales;
  }

  public void setVwSales(boolean vwSales) {
    this.vwSales = vwSales;
  }

  public boolean isVwService() {
    return vwService;
  }

  public void setVwService(boolean vwService) {
    this.vwService = vwService;
  }

  public boolean isVwnfSales() {
    return vwnfSales;
  }

  public void setVwnfSales(boolean vwnfSales) {
    this.vwnfSales = vwnfSales;
  }

  public boolean isVwnfService() {
    return vwnfService;
  }

  public void setVwnfService(boolean vwnfService) {
    this.vwnfService = vwnfService;
  }

  public String getAddress() {
    return address;
  }

  public void setAddress(String address) {
    this.address = address;
  }

  public String getPhone() {
    return phone;
  }

  public void setPhone(String phone) {
    this.phone = phone;
  }

  public String getFax() {
    return fax;
  }

  public void setFax(String fax) {
    this.fax = fax;
  }

  public String getMail() {
    return mail;
  }

  public void setMail(String mail) {
    this.mail = mail;
  }

  public int getId() {
    return id;
  }
  
  public void setId(int id) {
    this.id = id;
  }
  
  public String getName() {
    return name;
  }
  
  public void setName(String name) {
    this.name = name;
  }
  
  public String getCity() {
    return city;
  }
  
  public void setCity(String city) {
    this.city = city;
  }
  
  public int getZip() {
    return zip;
  }
  
  public void setZip(int zip) {
    this.zip = zip;
  }

  public boolean isAmagDealer() {
    return amagDealer;
  }

  public void setAmagDealer(boolean amagDealer) {
    this.amagDealer = amagDealer;
  }
}
