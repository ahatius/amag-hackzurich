package ch.amag.webtech.hackathon.entities;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;
import javax.xml.bind.annotation.XmlRootElement;

@Entity
@Table(name = "vehicle_equipment")
@XmlRootElement(name = "equipment")
public class VehicleEquipment {
  @Id
  private int id;
  
  @Column(name = "vehicle_vin")
  private String vin;
  
  @Column(name = "description_de")
  private String descriptionGerman;
//  @Column(name = "description_fr")
//  private String descriptionFrench;
//  @Column(name = "description_it")
//  private String descriptionItalian;

  public int getId() {
    return id;
  }

  public void setId(int id) {
    this.id = id;
  }

  public String getDescriptionGerman() {
    return descriptionGerman;
  }

  public void setDescriptionGerman(String descriptionGerman) {
    this.descriptionGerman = descriptionGerman;
  }

//  public String getDescriptionFrench() {
//    return descriptionFrench;
//  }
//
//  public void setDescriptionFrench(String descriptionFrench) {
//    this.descriptionFrench = descriptionFrench;
//  }
//
//  public String getDescriptionItalian() {
//    return descriptionItalian;
//  }
//
//  public void setDescriptionItalian(String descriptionItalian) {
//    this.descriptionItalian = descriptionItalian;
//  }

  public String getVin() {
    return vin;
  }

  public void setVin(String vin) {
    this.vin = vin;
  }
}
