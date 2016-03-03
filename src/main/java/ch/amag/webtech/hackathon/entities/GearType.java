package ch.amag.webtech.hackathon.entities;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;
import javax.xml.bind.annotation.XmlRootElement;

@Entity
@XmlRootElement(name = "gear")
@Table(name = "gear_type")
public class GearType {
  @Id
  private String id;
  
  private String category;
  private String drive;
  @Column(name = "name_de")
  private String nameGerman;
//  @Column(name = "name_fr")
//  private String nameFrench;
//  @Column(name = "name_it")
//  private String nameItalian;
  
  @Column(name = "count")
  private int gearCount;
  
  public String getId() {
    return id;
  }
  
  public void setId(String id) {
    this.id = id;
  }
  
  public String getCategory() {
    return category;
  }
  
  public void setCategory(String category) {
    this.category = category;
  }
  
  public String getDrive() {
    return drive;
  }

  public void setDrive(String drive) {
    this.drive = drive;
  }

  public String getNameGerman() {
    return nameGerman;
  }
  
  public void setNameGerman(String nameGerman) {
    this.nameGerman = nameGerman;
  }
  
//  public String getNameFrench() {
//    return nameFrench;
//  }
//  
//  public void setNameFrench(String nameFrench) {
//    this.nameFrench = nameFrench;
//  }
//  
//  public String getNameItalian() {
//    return nameItalian;
//  }
//  
//  public void setNameItalian(String nameItalian) {
//    this.nameItalian = nameItalian;
//  }

  public int getGearCount() {
    return gearCount;
  }

  public void setGearCount(int gearCount) {
    this.gearCount = gearCount;
  }
}
