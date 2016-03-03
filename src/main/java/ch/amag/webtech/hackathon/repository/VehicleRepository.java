package ch.amag.webtech.hackathon.repository;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Component;

import ch.amag.webtech.hackathon.entities.Vehicle;

@Component
public interface VehicleRepository extends CrudRepository<Vehicle, String>, VehicleRepositoryCustom {}
