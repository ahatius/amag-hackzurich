package ch.amag.webtech.hackathon.repository;

import java.util.List;

import ch.amag.webtech.hackathon.entities.GearType;

public interface GearTypeRepositoryCustom {
  public List<GearType> findByCategory(String category);
}
