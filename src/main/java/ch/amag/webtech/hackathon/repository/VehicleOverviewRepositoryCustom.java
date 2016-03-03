package ch.amag.webtech.hackathon.repository;

import java.util.List;

import ch.amag.webtech.hackathon.entities.VehicleOverview;

public interface VehicleOverviewRepositoryCustom {
  public void saveBatch(List<VehicleOverview> vehicles);
  public VehicleOverview findByCommission(String commission);
  public List<VehicleOverview> findByDealer(Integer dealerId);
  public List<VehicleOverview> findByInteriorColor(String id);
  public List<VehicleOverview> findByExteriorColor(String id);
  public List<VehicleOverview> findByGearType(String gearType);
  public List<VehicleOverview> findByFuelType(String fuelType);
  public List<VehicleOverview> findByCategory(String category);
  public List<VehicleOverview> findByScore(String scoreType, int score);
  public List<VehicleOverview> findByScoreRange(String scoreType, int lowerScore, int upperScore);
}
