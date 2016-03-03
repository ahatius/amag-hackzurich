package ch.amag.webtech.hackathon.repository;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;

import org.springframework.transaction.annotation.Transactional;

import ch.amag.webtech.hackathon.entities.Dealer;

class DealerRepositoryImpl implements DealerRepositoryCustom {
  @PersistenceContext
  private EntityManager em;
  
  @Transactional
  public void saveBatch(List<Dealer> dealers) {
    for(int i = 0; i < dealers.size(); i++) {
      
      em.persist(dealers.get(i));
      
      if(i % 20 == 0) {
        em.flush();
        em.clear();
      }
    }
    
    em.flush();
    em.clear();
  }
}