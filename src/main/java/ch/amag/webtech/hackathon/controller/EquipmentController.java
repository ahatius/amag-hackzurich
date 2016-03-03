package ch.amag.webtech.hackathon.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import ch.amag.webtech.hackathon.entities.VehicleEquipment;
import ch.amag.webtech.hackathon.repository.VehicleEquipmentRepository;

@RestController
@RequestMapping("/equipment")
@ComponentScan(basePackages = { "ch.amag.webtech.hackathon" })
public class EquipmentController {
  @Autowired
  private VehicleEquipmentRepository equipmentRepository;
  
  @RequestMapping(value = "/{id}", method = RequestMethod.GET)
  public VehicleEquipment getEquipment(@PathVariable int id) {
    return equipmentRepository.findOne(id);
  }
}
