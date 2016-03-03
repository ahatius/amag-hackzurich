package ch.amag.webtech.hackathon.entities;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;
import javax.xml.bind.annotation.XmlRootElement;

@Entity
@XmlRootElement(name = "category")
@Table(name = "category")
public class Category {
  @Id
  private String id;
  
  @Column(name = "description_de")
  private String descriptionGerman;
  @Column(name = "description_fr")
  private String descriptionFrench;
  @Column(name = "description_it")
  private String descriptionItalian;
  
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
  
  public String getDescriptionFrench() {
    return descriptionFrench;
  }
  
  public void setDescriptionFrench(String descriptionFrench) {
    this.descriptionFrench = descriptionFrench;
  }
  
  public String getDescriptionItalian() {
    return descriptionItalian;
  }
  
  public void setDescriptionItalian(String descriptionItalian) {
    this.descriptionItalian = descriptionItalian;
  }
  
  
}
