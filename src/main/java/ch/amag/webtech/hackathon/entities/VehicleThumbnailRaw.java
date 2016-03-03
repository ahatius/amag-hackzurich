package ch.amag.webtech.hackathon.entities;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name="vehicle_image")
public class VehicleThumbnailRaw {
  @GeneratedValue
  @Id
  private int id;
  
  @Column(name="thumbnail_data")
  private byte[] thumbnailData;

  public int getId() {
    return id;
  }

  public void setId(int id) {
    this.id = id;
  }

  public byte[] getThumbnailData() {
    return thumbnailData;
  }

  public void setThumbnailData(byte[] encodedImage) {
    this.thumbnailData = encodedImage;
  }
}
