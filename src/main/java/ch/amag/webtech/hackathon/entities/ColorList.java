package ch.amag.webtech.hackathon.entities;

import java.util.List;

import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlRootElement;

@XmlRootElement(name = "colors")
public class ColorList {
  private List<Color> colors;
  
  public ColorList() {};
  
  public ColorList(List<Color> colors) {
    this.colors = colors;
  }

  @XmlElement(name = "color")
  public List<Color> getColors() {
    return colors;
  }

  public void setColors(List<Color> colors) {
    this.colors = colors;
  }
}
