package ch.amag.webtech.hackathon.entities;

import java.util.List;

import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlRootElement;

@XmlRootElement(name = "gears")
public class GearTypeList {
  private List<GearType> gearTypes;
  
  public GearTypeList() {}
  
  public GearTypeList(List<GearType> gearTypes) {
    this.gearTypes = gearTypes;
  }
  
  @XmlElement(name = "gearType")
  public List<GearType> getGearTypes() {
    return gearTypes;
  }

  public void setGearTypes(List<GearType> gearTypes) {
    this.gearTypes = gearTypes;
  }
}
