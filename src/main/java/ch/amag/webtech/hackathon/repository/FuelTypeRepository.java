package ch.amag.webtech.hackathon.repository;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Component;

import ch.amag.webtech.hackathon.entities.FuelType;

@Component
public interface FuelTypeRepository extends CrudRepository<FuelType, String> {}
