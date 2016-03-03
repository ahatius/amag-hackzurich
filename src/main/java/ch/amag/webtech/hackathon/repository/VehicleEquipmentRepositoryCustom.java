package ch.amag.webtech.hackathon.repository;

import java.util.List;

import ch.amag.webtech.hackathon.entities.VehicleEquipment;

public interface VehicleEquipmentRepositoryCustom {
  public List<VehicleEquipment> findByVin(String vin);
}
