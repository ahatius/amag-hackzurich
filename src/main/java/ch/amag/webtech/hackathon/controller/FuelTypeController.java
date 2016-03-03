package ch.amag.webtech.hackathon.controller;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import ch.amag.webtech.hackathon.entities.FuelType;
import ch.amag.webtech.hackathon.entities.FuelTypeList;
import ch.amag.webtech.hackathon.entities.Vehicle;
import ch.amag.webtech.hackathon.entities.VehicleList;
import ch.amag.webtech.hackathon.entities.VehicleOverview;
import ch.amag.webtech.hackathon.entities.VehicleOverviewList;
import ch.amag.webtech.hackathon.repository.FuelTypeRepository;
import ch.amag.webtech.hackathon.repository.VehicleOverviewRepository;
import ch.amag.webtech.hackathon.repository.VehicleRepository;

@RestController
@RequestMapping("/fueltype")
@ComponentScan(basePackages = { "ch.amag.webtech.hackathon" })
public class FuelTypeController {
  @Autowired
  private FuelTypeRepository fuelTypeRepository;
  
  @Autowired
  private VehicleRepository vehicleRepository;
  
  @Autowired
  private VehicleOverviewRepository vehicleOverviewRepository;
  
  @RequestMapping(value = {"", "/"}, method = RequestMethod.GET)
  public FuelTypeList getAllFuelTypes() {
    List<FuelType> fuelTypes = new ArrayList<FuelType>();
    
    for(FuelType fuelType : fuelTypeRepository.findAll()) {
      fuelTypes.add(fuelType);
    }
    
    return new FuelTypeList(fuelTypes);
  }
  
  @RequestMapping(value = "/{id}", method = RequestMethod.GET)
  public FuelType getFuelTypeById(@PathVariable String id) {
    return fuelTypeRepository.findOne(id);
  }
  
  @RequestMapping(value = "/{id}/vehicles")
  public VehicleList getVehiclesByGearTypes(@PathVariable String id) {
    List<Vehicle> vehicles = new ArrayList<Vehicle>();
    
    for(Vehicle vehicle : vehicleRepository.findByFuelType(id)) {
      vehicles.add(vehicle);
    }
    
    return new VehicleList(vehicles);
  }
  
  @RequestMapping(value = "/{id}/vehicles/overview")
  public VehicleOverviewList getVehicleOverviewByFuelType(@PathVariable String id) {
    List<VehicleOverview> vehicles = new ArrayList<VehicleOverview>();
    
    for(VehicleOverview vehicle : vehicleOverviewRepository.findByFuelType(id)) {
      vehicles.add(vehicle);
    }
    
    return new VehicleOverviewList(vehicles);
  }
}