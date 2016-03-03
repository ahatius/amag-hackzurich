package ch.amag.webtech.hackathon.entities;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.xml.bind.annotation.XmlRootElement;

@Entity
@XmlRootElement(name = "image")
public class Image {
  @Id
  @GeneratedValue
  private int id;
  
  private String vin;
  
  @Column(name="encoded_string")
  private String encodedString;

  public String getEncodedString() {
    return encodedString;
  }

  public void setEncodedString(String encodedString) {
    this.encodedString = encodedString;
  }

  public int getId() {
    return id;
  }

  public void setId(int id) {
    this.id = id;
  }

  public String getVin() {
    return vin;
  }

  public void setVin(String vin) {
    this.vin = vin;
  }
}
