package ch.amag.webtech.hackathon.entities;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name="vehicle_image")
public class VehicleImageRaw {
  @GeneratedValue
  @Id
  private int id;
  
  private String name;
  @Column(name = "vehicle_vin")
  private String vin;
  
  @Column(name="image_data")
  private byte[] imageData;

  public String getName() {
    return name;
  }

  public void setName(String name) {
    this.name = name;
  }

  public String getVin() {
    return vin;
  }

  public void setVin(String vin) {
    this.vin = vin;
  }

  public int getId() {
    return id;
  }

  public void setId(int id) {
    this.id = id;
  }

  public byte[] getImageData() {
    return imageData;
  }

  public void setImageData(byte[] encodedImage) {
    this.imageData = encodedImage;
  }
}
