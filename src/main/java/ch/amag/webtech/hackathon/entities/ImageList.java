package ch.amag.webtech.hackathon.entities;

import java.util.List;

import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlRootElement;

@XmlRootElement(name = "images")
public class ImageList {
  private List<Image> images;
  
  public ImageList(List<Image> images) {
    this.images = images;
  }
  
  @XmlElement(name = "image")
  public List<Image> getImages() {
    return images;
  }

  public void setImages(List<Image> images) {
    this.images = images;
  }
}
