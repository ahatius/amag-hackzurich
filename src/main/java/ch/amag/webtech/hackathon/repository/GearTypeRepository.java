package ch.amag.webtech.hackathon.repository;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Component;

import ch.amag.webtech.hackathon.entities.GearType;

@Component
public interface GearTypeRepository extends CrudRepository<GearType, String>, GearTypeRepositoryCustom {}
