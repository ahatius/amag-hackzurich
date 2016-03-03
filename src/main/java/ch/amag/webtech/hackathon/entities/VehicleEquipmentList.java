package ch.amag.webtech.hackathon.entities;

import java.util.List;

import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlRootElement;

@XmlRootElement(name = "equipmentList")
public class VehicleEquipmentList {
  private List<VehicleEquipment> equipment;
  
  public VehicleEquipmentList() {}
  
  public VehicleEquipmentList(List<VehicleEquipment> equipment) {
    this.equipment = equipment;
  }
  
  @XmlElement(name = "equipment")
  public List<VehicleEquipment> getEquipment() {
    return equipment;
  }

  public void setEquipment(List<VehicleEquipment> equipment) {
    this.equipment = equipment;
  }
}
