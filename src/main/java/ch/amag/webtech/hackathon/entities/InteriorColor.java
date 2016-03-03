package ch.amag.webtech.hackathon.entities;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;
import javax.xml.bind.annotation.XmlRootElement;

@Entity
@Table(name = "interior_color")
@XmlRootElement(name = "interiorColor")
public class InteriorColor implements Color {
  @Id
  private String id;
  
  @Column(name = "description_de")
  private String descriptionGerman;
//  @Column(name = "description_fr")
//  private String descriptionFrench;
//  @Column(name = "description_it")
//  private String descriptionItalian;
  private String category;
  
  public String getId() {
    return id;
  }
  public void setId(String id) {
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
//  public void setDescriptionFrench(String descriptionFrench) {
//    this.descriptionFrench = descriptionFrench;
//  }
//  public String getDescriptionItalian() {
//    return descriptionItalian;
//  }
//  public void setDescriptionItalian(String descriptionItalian) {
//    this.descriptionItalian = descriptionItalian;
//  }
  public String getCategory() {
    return category;
  }
  public void setCategory(String category) {
    this.category = category;
  }
}
