package ch.amag.webtech.hackathon.repository;

import java.util.List;

import ch.amag.webtech.hackathon.entities.Dealer;

public interface DealerRepositoryCustom {
  public void saveBatch(List<Dealer> dealers);
}
