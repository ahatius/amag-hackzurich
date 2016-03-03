package ch.amag.webtech.hackathon.repository;

import java.util.List;

import ch.amag.webtech.hackathon.entities.Vehicle;

public interface VehicleRepositoryCustom {
  public void saveBatch(List<Vehicle> vehicles);
  public Vehicle findByCommission(String commission);
  public List<Vehicle> findByDealer(int dealerId);
  public List<Vehicle> findByInteriorColor(String id);
  public List<Vehicle> findByExteriorColor(String id);
  public List<Vehicle> findByGearType(String gearType);
  public List<Vehicle> findByFuelType(String fuelType);
  public List<Vehicle> findByCategory(String category);
  public List<Vehicle> findByScore(String scoreType, int score);
  public List<Vehicle> findByScoreRange(String scoreType, int lowerScore, int upperScore);
  public List<Vehicle> findRandomAmount(int amount);
  public List<Vehicle> findRandomAmountOfBrand(int amount, String brand);
}
