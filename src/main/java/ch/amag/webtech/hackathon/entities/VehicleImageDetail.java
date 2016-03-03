package ch.amag.webtech.hackathon.entities;

import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

import org.eclipse.persistence.oxm.annotations.XmlInverseReference;

import com.fasterxml.jackson.annotation.JsonBackReference;

@Entity
@Table(name="vehicle_image")
public class VehicleImageDetail {
  @Id
  @GeneratedValue
  private int id;
  
  private String name;
  
  @ManyToOne(fetch = FetchType.EAGER, cascade=CascadeType.PERSIST)
  @JsonBackReference
  @XmlInverseReference(mappedBy = "vehicle")
  private Vehicle vehicle;

  public int getId() {
    return id;
  }

  public void setId(int id) {
    this.id = id;
  }

  public String getName() {
    return name;
  }

  public void setName(String name) {
    this.name = name;
  }

  public Vehicle getVehicle() {
    return vehicle;
  }

  public void setVehicle(Vehicle vehicle) {
    this.vehicle = vehicle;
  }
}
