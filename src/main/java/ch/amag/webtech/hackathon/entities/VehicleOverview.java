package ch.amag.webtech.hackathon.entities;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;
import javax.xml.bind.annotation.XmlRootElement;

@Entity
@XmlRootElement(name = "vehicle")
@Table(name = "vehicle")
public class VehicleOverview {
  @Id
  @Column(name="vin")
  private String vin;
  private String brand;
  @Column(name="model_de")
  private String modelGerman;
  /*@Column(name="model_fr")
  private String modelFrench;
  @Column(name="model_it")
  private String modelItalian;*/
  @Column(name="exterior_color")
  private String exteriorColor;
  @Column(name="interior_color")
  private String interiorColor;
  @Column(name="gear_type")
  private String gearType;
  @Column(name="fuel_type")
  private String fuelType;
  
  private int dealer;
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
  private int price;
  
  public String getVin() {
    return vin;
  }
  
  public void setVin(String vin) {
    this.vin = vin;
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

  public int getDealer() {
    return dealer;
  }

  public void setDealer(int dealer) {
    this.dealer = dealer;
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

  public int getPrice() {
    return price;
  }

  public void setPrice(int price) {
    this.price = price;
  }
}
