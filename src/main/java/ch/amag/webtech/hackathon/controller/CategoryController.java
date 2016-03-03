package ch.amag.webtech.hackathon.controller;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import ch.amag.webtech.hackathon.entities.Category;
import ch.amag.webtech.hackathon.entities.CategoryList;
import ch.amag.webtech.hackathon.entities.Vehicle;
import ch.amag.webtech.hackathon.entities.VehicleList;
import ch.amag.webtech.hackathon.entities.VehicleOverview;
import ch.amag.webtech.hackathon.entities.VehicleOverviewList;
import ch.amag.webtech.hackathon.repository.CategoryRepository;
import ch.amag.webtech.hackathon.repository.VehicleOverviewRepository;
import ch.amag.webtech.hackathon.repository.VehicleRepository;

@RestController
@RequestMapping("/category")
@ComponentScan(basePackages = { "ch.amag.webtech.hackathon" })
public class CategoryController {
  @Autowired
  private VehicleRepository vehicleRepository;
  
  @Autowired
  private VehicleOverviewRepository vehicleOverviewRepository;
  
  @Autowired
  private CategoryRepository categoryRepository;
  
  @RequestMapping(value = "/{category}", method = RequestMethod.GET)
  public Category getCategory(@PathVariable String category) {
    return categoryRepository.findOne(category);
  }
  
  @RequestMapping(value = {"", "/"}, method = RequestMethod.GET)
  public CategoryList getAllCategories() {
    List<Category> categories = new ArrayList<Category>();
    
    for(Category category : categoryRepository.findAll()) {
      categories.add(category);
    }
    
    return new CategoryList(categories);
  }
  
  @RequestMapping(value = "/category/{category}/vehicles")
  public VehicleList getVehiclesByCategory(@PathVariable String category) {
    List<Vehicle> vehicles = new ArrayList<Vehicle>();
    
    for(Vehicle vehicle : vehicleRepository.findByCategory(category)) {
      vehicles.add(vehicle);
    }
    
    return new VehicleList(vehicles);
  }
  
  @RequestMapping(value = "/category/{category}/vehicles/overview", method = RequestMethod.GET)
  public VehicleOverviewList getVehicleOverviewByCategory(String category) {
    List<VehicleOverview> vehicles = new ArrayList<VehicleOverview>();
    
    for(VehicleOverview vehicle : vehicleOverviewRepository.findByCategory(category)) {
      vehicles.add(vehicle);
    }
    
    return new VehicleOverviewList(vehicles);
  }
}
