package ch.amag.webtech.hackathon.repository;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Component;

import ch.amag.webtech.hackathon.entities.VehicleEquipment;

@Component
public interface VehicleEquipmentRepository extends CrudRepository<VehicleEquipment, Integer>, VehicleEquipmentRepositoryCustom {}
