package ch.amag.webtech.hackathon.controller;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import ch.amag.webtech.hackathon.entities.GearType;
import ch.amag.webtech.hackathon.entities.GearTypeList;
import ch.amag.webtech.hackathon.entities.Vehicle;
import ch.amag.webtech.hackathon.entities.VehicleList;
import ch.amag.webtech.hackathon.entities.VehicleOverview;
import ch.amag.webtech.hackathon.entities.VehicleOverviewList;
import ch.amag.webtech.hackathon.repository.GearTypeRepository;
import ch.amag.webtech.hackathon.repository.VehicleOverviewRepository;
import ch.amag.webtech.hackathon.repository.VehicleRepository;

@RestController
@RequestMapping("/geartype")
@ComponentScan(basePackages = { "ch.amag.webtech.hackathon" })
public class GearTypeController {
  @Autowired
  private GearTypeRepository gearRepository;
  
  @Autowired
  private VehicleRepository vehicleRepository;
  
  @Autowired
  private VehicleOverviewRepository vehicleOverviewRepository;
  
  @RequestMapping(value = {"", "/"}, method = RequestMethod.GET)
  public GearTypeList getAllGears() {
    List<GearType> gears = new ArrayList<GearType>();
    
    for(GearType gear : gearRepository.findAll()) {
      gears.add(gear);
    }
    
    return new GearTypeList(gears);
  }
  
  @RequestMapping(value = "/{id}", method = RequestMethod.GET)
  public GearType getEquipment(@PathVariable String id) {
    return gearRepository.findOne(id);
  }
  
  @RequestMapping(value = "/category/{category}")
  public GearTypeList getGearTypesFromCategory(@PathVariable String category) {
    List<GearType> gears = new ArrayList<GearType>();
    
    for(GearType gear : gearRepository.findByCategory(category)) {
      gears.add(gear);
    }
    
    return new GearTypeList(gears);
  }
  
  @RequestMapping(value = "/{id}/vehicles")
  public VehicleList getVehiclesByGearTypes(@PathVariable String id) {
    List<Vehicle> vehicles = new ArrayList<Vehicle>();
    
    for(Vehicle vehicle : vehicleRepository.findByGearType(id)) {
      vehicles.add(vehicle);
    }
    
    return new VehicleList(vehicles);
  }
  
  @RequestMapping(value = "/{id}/vehicles/overview")
  public VehicleOverviewList getVehicleOverviewByGearTypes(@PathVariable String id) {
    List<VehicleOverview> vehicles = new ArrayList<VehicleOverview>();
    
    for(VehicleOverview vehicle : vehicleOverviewRepository.findByGearType(id)) {
      vehicles.add(vehicle);
    }
    
    return new VehicleOverviewList(vehicles);
  }
}
