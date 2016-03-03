package ch.amag.webtech.hackathon.entities;

import java.util.Collection;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.persistence.Table;
import javax.xml.bind.annotation.XmlRootElement;
import javax.xml.bind.annotation.XmlTransient;

import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonManagedReference;
import com.fasterxml.jackson.annotation.JsonUnwrapped;

@Entity
@XmlRootElement(name = "vehicle")
@Table(name = "vehicle")
public class Vehicle {
  @Id
  @Column(name="vin")
  private String vin;
  @JsonIgnore
  private String commission;
  private String brand;
  @Column(name="model_de")
  private String modelGerman;
//  @Column(name="model_fr")
//  private String modelFrench;
//  @Column(name="model_it")
//  private String modelItalian;
//  @Column(name="swiss_type_number")
//  private String swissTypeNumber;
  @Column(name="sale_type")
  private String saleType;
  @Column(name="exterior_color")
  private String exteriorColor;
  @Column(name="interior_color")
  private String interiorColor;
//  private String remarks;
  @Column(name="additional_title")
  private String additionalTitle;
  @Column(name="added_value_description")
  private String addedValueDescription;
  @Column(name="first_registration")
  private String firstRegistration;
  private String guaranty;
  @Column(name="last_inspection")
  private String lastInspection;
  @Column(name="gear_type")
  private String gearType;
  @Column(name="fuel_type")
  private String fuelType;
  private String weight;
  
  private int dealer;
  private int mileage;
  private int price;
  @Column(name="model_year")
  private int modelYear;
  private int emissions;
  @Column(name = "sport_score")
  private int sportScore;
  @Column(name = "family_score")
  private int familyScore;
  @Column(name = "eco_score")
  private int ecoScore;
  @Column(name = "price_score")
  private int priceScore;
  @Column(name = "offroad_score")
  private int offroadScore;
  @Column(name = "design_score")
  private int designScore;
  private int seats;
  
//  @Column(name="car_damaged_in_accident")
//  private boolean carDamagedInAccident;
//  private boolean imported;
  
  @OneToMany(fetch = FetchType.EAGER, mappedBy="vehicle", cascade = CascadeType.ALL)
  @JsonManagedReference
  private Collection<VehicleImageDetail> vehicleImages;
  
  public String getVin() {
    return vin;
  }
  
  public void setVin(String vin) {
    this.vin = vin;
  }
  
  @XmlTransient
  public String getCommission() {
    return commission;
  }
  
  public void setCommission(String commission) {
    this.commission = commission;
  }
  
  public String getBrand() {
    return brand;
  }

  public void setBrand(String brand) {
    this.brand = brand;
  }

  public String getModelGerman() {
    return modelGerman;
  }

  public void setModelGerman(String modelGerman) {
    this.modelGerman = modelGerman;
  }

//  public String getModelFrench() {
//    return modelFrench;
//  }
//
//  public void setModelFrench(String modelFrench) {
//    this.modelFrench = modelFrench;
//  }
//
//  public String getModelItalian() {
//    return modelItalian;
//  }
//
//  public void setModelItalian(String modelItalian) {
//    this.modelItalian = modelItalian;
//  }
  
//  public String getSwissTypeNumber() {
//    return swissTypeNumber;
//  }
//  
//  public void setSwissTypeNumber(String swissTypeNumber) {
//    this.swissTypeNumber = swissTypeNumber;
//  }
  
  public String getSaleType() {
    return saleType;
  }
  
  public void setSaleType(String saleType) {
    this.saleType = saleType;
  }
  
  public String getExteriorColor() {
    return exteriorColor;
  }
  
  public void setExteriorColor(String exteriorColor) {
    this.exteriorColor = exteriorColor;
  }
  
  public String getInteriorColor() {
    return interiorColor;
  }
  
  public void setInteriorColor(String interiorColor) {
    this.interiorColor = interiorColor;
  }
  
//  public String getRemarks() {
//    return remarks;
//  }
//  
//  public void setRemarks(String remarks) {
//    this.remarks = remarks;
//  }
  
  public String getAdditionalTitle() {
    return additionalTitle;
  }
  
  public void setAdditionalTitle(String additionalTitle) {
    this.additionalTitle = additionalTitle;
  }
  
  public String getAddedValueDescription() {
    return addedValueDescription;
  }

  public void setAddedValueDescription(String additionalValueDescription) {
    this.addedValueDescription = additionalValueDescription;
  }

  public String getFirstRegistration() {
    return firstRegistration;
  }

  public void setFirstRegistration(String firstRegistration) {
    this.firstRegistration = firstRegistration;
  }

  public String getGuaranty() {
    return guaranty;
  }

  public void setGuaranty(String guaranty) {
    this.guaranty = guaranty;
  }

  public int getDealer() {
    return dealer;
  }

  public void setDealer(int dealer) {
    this.dealer = dealer;
  }

  public int getMileage() {
    return mileage;
  }
  
  public void setMileage(int mileage) {
    this.mileage = mileage;
  }
  
  public int getPrice() {
    return price;
  }
  
  public void setPrice(int price) {
    this.price = price;
  }
  
  public int getModelYear() {
    return modelYear;
  }

  public void setModelYear(int modelYear) {
    this.modelYear = modelYear;
  }

  public String getLastInspection() {
    return lastInspection;
  }
  
  public void setLastInspection(String lastInspection) {
    this.lastInspection = lastInspection;
  }
  
  public String getGearType() {
    return gearType;
  }

  public void setGearType(String gearType) {
    this.gearType = gearType;
  }

  public String getFuelType() {
    return fuelType;
  }

  public void setFuelType(String fuelType) {
    this.fuelType = fuelType;
  }

//  public boolean isCarDamagedInAccident() {
//    return carDamagedInAccident;
//  }
//  
//  public void setCarDamagedInAccident(boolean carDamagedInAccident) {
//    this.carDamagedInAccident = carDamagedInAccident;
//  }
//  
//  public boolean isImported() {
//    return imported;
//  }
//  
//  public void setImported(boolean imported) {
//    this.imported = imported;
//  }
  
  public Collection<VehicleImageDetail> getVehicleImages() {
    return vehicleImages;
  }

  public void setVehicleImages(Collection<VehicleImageDetail> vehicleImages) {
    this.vehicleImages = vehicleImages;
  }

  public String getWeight() {
    return weight;
  }

  public void setWeight(String weight) {
    this.weight = weight;
  }

  public int getEmissions() {
    return emissions;
  }

  public void setEmissions(int emissions) {
    this.emissions = emissions;
  }

  public int getSportScore() {
    return sportScore;
  }

  public void setSportScore(int sportScore) {
    this.sportScore = sportScore;
  }

  public int getFamilyScore() {
    return familyScore;
  }

  public void setFamilyScore(int familyScore) {
    this.familyScore = familyScore;
  }

  public int getEcoScore() {
    return ecoScore;
  }

  public void setEcoScore(int ecoScore) {
    this.ecoScore = ecoScore;
  }

  public int getPriceScore() {
    return priceScore;
  }

  public void setPriceScore(int priceScore) {
    this.priceScore = priceScore;
  }

  public int getOffroadScore() {
    return offroadScore;
  }

  public void setOffroadScore(int offroadScore) {
    this.offroadScore = offroadScore;
  }

  public int getDesignScore() {
    return designScore;
  }

  public void setDesignScore(int designScore) {
    this.designScore = designScore;
  }

  public int getSeats() {
    return seats;
  }

  public void setSeats(int seats) {
    this.seats = seats;
  }
}
