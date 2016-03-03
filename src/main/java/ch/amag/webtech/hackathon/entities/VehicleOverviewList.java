package ch.amag.webtech.hackathon.entities;

import java.util.List;

import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlRootElement;

// Outputting an ArrayList of Vehicles doesn't work for XML, so we had to create a wrapper class
@XmlRootElement(name = "vehicles")
public class VehicleOverviewList {
  private List<VehicleOverview> vehicles;
  
  public VehicleOverviewList() {
    
  }
  
  public VehicleOverviewList(List<VehicleOverview> vehicles) {
    this.vehicles = vehicles;
  }

  @XmlElement(name = "vehicle")
  public List<VehicleOverview> getVehicles(){
      return this.vehicles;
  }
  
  public void setVehicles(List<VehicleOverview> vehicles) {
    this.vehicles = vehicles;
  }
}
