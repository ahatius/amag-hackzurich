package ch.amag.webtech.hackathon.repository;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Component;

import ch.amag.webtech.hackathon.entities.VehicleOverview;

@Component
public interface VehicleOverviewRepository extends CrudRepository<VehicleOverview, String>, VehicleOverviewRepositoryCustom {}
