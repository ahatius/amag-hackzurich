package ch.amag.webtech.hackathon.controller;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import ch.amag.webtech.hackathon.entities.Color;
import ch.amag.webtech.hackathon.entities.ColorList;
import ch.amag.webtech.hackathon.entities.ExteriorColor;
import ch.amag.webtech.hackathon.entities.InteriorColor;
import ch.amag.webtech.hackathon.entities.Vehicle;
import ch.amag.webtech.hackathon.entities.VehicleList;
import ch.amag.webtech.hackathon.entities.VehicleOverview;
import ch.amag.webtech.hackathon.entities.VehicleOverviewList;
import ch.amag.webtech.hackathon.repository.ExteriorColorRepository;
import ch.amag.webtech.hackathon.repository.InteriorColorRepository;
import ch.amag.webtech.hackathon.repository.VehicleOverviewRepository;
import ch.amag.webtech.hackathon.repository.VehicleRepository;

@RestController
@RequestMapping("/color")
@ComponentScan(basePackages = { "ch.amag.webtech.hackathon" })
public class ColorController {
  @Autowired
  ExteriorColorRepository exteriorColorRepository;
  
  @Autowired
  InteriorColorRepository interiorColorRepository;
  
  @Autowired
  VehicleRepository vehicleRepository;
  
  @Autowired
  VehicleOverviewRepository vehicleOverviewRepository;
  
  @RequestMapping(value = {"/interior", "/interior/"}, method = RequestMethod.GET)
  public ColorList getAllInteriorColors() {
    List<Color> colors = new ArrayList<Color>();
    
    for(Color color : interiorColorRepository.findAll()) {
      colors.add(color);
    }
    
    return new ColorList(colors);
  }
  
  @RequestMapping(value = "/interior/{id}", method = RequestMethod.GET)
  public InteriorColor getInteriorColor(@PathVariable String id) {
    return interiorColorRepository.findOne(id);
  }
  
  @RequestMapping(value = {"/exterior", "/exterior/"}, method = RequestMethod.GET)
  public ColorList getAllExteriorColors() {
    List<Color> colors = new ArrayList<Color>();
    
    for(Color color : exteriorColorRepository.findAll()) {
      colors.add(color);
    }
    
    return new ColorList(colors);
  }
  
  @RequestMapping(value = "/interior/{id}/vehicles", method = RequestMethod.GET)
  public VehicleList getVehiclesFromInteriorColor(@PathVariable String id) {
    List<Vehicle> vehicles = new ArrayList<Vehicle>();
    
    for(Vehicle vehicle : vehicleRepository.findByInteriorColor(id)) {
      vehicles.add(vehicle);
    }
    
    return new VehicleList(vehicles);
  }
  
  @RequestMapping(value = "/interior/{id}/vehicles/overview", method = RequestMethod.GET)
  public VehicleOverviewList getVehiclesOverviewFromInteriorColor() {
    List<VehicleOverview> vehicles = new ArrayList<VehicleOverview>();
    
    for(VehicleOverview vehicle : vehicleOverviewRepository.findAll()) {
      vehicles.add(vehicle);
    }
    
    return new VehicleOverviewList(vehicles);
  }
  
  @RequestMapping(value = "/exterior/{id}/vehicles", method = RequestMethod.GET)
  public VehicleList getVehiclesFromExteriorColor(@PathVariable String id) {
    List<Vehicle> vehicles = new ArrayList<Vehicle>();
    
    for(Vehicle vehicle : vehicleRepository.findByExteriorColor(id)) {
      vehicles.add(vehicle);
    }
    
    return new VehicleList(vehicles);
  }
  
  @RequestMapping(value = "/exterior/{id}/vehicles/overview", method = RequestMethod.GET)
  public VehicleOverviewList getVehiclesOverviewFromExteriorColor(@PathVariable String id) {
    List<VehicleOverview> vehicles = new ArrayList<VehicleOverview>();
    
    for(VehicleOverview vehicle : vehicleOverviewRepository.findByExteriorColor(id)) {
      vehicles.add(vehicle);
    }
    
    return new VehicleOverviewList(vehicles);
  }
  
  @RequestMapping(value = "/exterior/{id}", method = RequestMethod.GET)
  public ExteriorColor getExteriorColor(@PathVariable String id) {
    return exteriorColorRepository.findOne(id);
  }
}
