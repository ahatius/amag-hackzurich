package ch.amag.webtech.hackathon.entities;

import java.util.List;

import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlRootElement;

@XmlRootElement(name = "fuelTypes")
public class FuelTypeList {
  private List<FuelType> fuelTypes;
  
  public FuelTypeList() {}
  
  public FuelTypeList(List<FuelType> fuelTypes) {
    this.fuelTypes = fuelTypes;
  }
  
  @XmlElement(name = "fuelType")
  public List<FuelType> getFuelTypes() {
    return fuelTypes;
  }

  public void setFuelTypes(List<FuelType> fuelTypes) {
    this.fuelTypes = fuelTypes;
  }
}
