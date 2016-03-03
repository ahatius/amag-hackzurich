package ch.amag.webtech.hackathon.repository;

import java.util.ArrayList;
import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.Query;
import javax.persistence.TypedQuery;
import javax.persistence.criteria.CriteriaBuilder;
import javax.persistence.criteria.CriteriaQuery;
import javax.persistence.criteria.ParameterExpression;
import javax.persistence.criteria.Predicate;
import javax.persistence.criteria.Root;

import org.springframework.transaction.annotation.Transactional;

import ch.amag.webtech.hackathon.entities.Vehicle;
import ch.amag.webtech.hackathon.entities.VehicleOverview;

class VehicleOverviewRepositoryImpl implements VehicleOverviewRepositoryCustom {
  @PersistenceContext
  private EntityManager em;
  
  @Transactional
  public void saveBatch(List<VehicleOverview> vehicles) {
    for(int i = 0; i < vehicles.size(); i++) {
      em.persist(vehicles.get(i));
      
      if(i % 20 == 0) {
        em.flush();
        em.clear();
      }
    }
    
    em.flush();
    em.clear();
  }
  
  public VehicleOverview findByCommission(String commission) {
    Query query = em.createQuery("SELECT vin FROM vehicle WHERE commission = ?1");
    query.setParameter(1, commission);
    
    return (VehicleOverview) query.getSingleResult();
  }
  
  public List<VehicleOverview> findByDealer(Integer dealerId) {
    CriteriaBuilder criteriaBuilder = em.getCriteriaBuilder();
    CriteriaQuery<VehicleOverview> criteriaQuery = criteriaBuilder.createQuery(VehicleOverview.class);
    Root<VehicleOverview> root = criteriaQuery.from(VehicleOverview.class);
    criteriaQuery.select(root);
    
    ParameterExpression<Integer> params = criteriaBuilder.parameter(Integer.class);
    criteriaQuery.where(criteriaBuilder.equal(root.get("dealer"), params));
    
    TypedQuery<VehicleOverview> query = em.createQuery(criteriaQuery);
    query.setParameter(params, dealerId);
    
    return query.getResultList();
  }
  
  public List<VehicleOverview> findByGearType(String gearType) {
    CriteriaBuilder criteriaBuilder = em.getCriteriaBuilder();
    CriteriaQuery<VehicleOverview> criteriaQuery = criteriaBuilder.createQuery(VehicleOverview.class);
    Root<VehicleOverview> root = criteriaQuery.from(VehicleOverview.class);
    criteriaQuery.select(root);
    
    ParameterExpression<String> params = criteriaBuilder.parameter(String.class);
    criteriaQuery.where(criteriaBuilder.equal(root.get("gearType"), params));
    
    TypedQuery<VehicleOverview> query = em.createQuery(criteriaQuery);
    query.setParameter(params, gearType);
    
    return query.getResultList();
  }
  
  public List<VehicleOverview> findByFuelType(String fuelType) {
    CriteriaBuilder criteriaBuilder = em.getCriteriaBuilder();
    CriteriaQuery<VehicleOverview> criteriaQuery = criteriaBuilder.createQuery(VehicleOverview.class);
    Root<VehicleOverview> root = criteriaQuery.from(VehicleOverview.class);
    criteriaQuery.select(root);
    
    ParameterExpression<String> params = criteriaBuilder.parameter(String.class);
    criteriaQuery.where(criteriaBuilder.equal(root.get("fuelType"), params));
    
    TypedQuery<VehicleOverview> query = em.createQuery(criteriaQuery);
    query.setParameter(params, fuelType);
    
    return query.getResultList();
  }
  
  public List<VehicleOverview> findByCategory(String category) {
    CriteriaBuilder criteriaBuilder = em.getCriteriaBuilder();
    CriteriaQuery<VehicleOverview> criteriaQuery = criteriaBuilder.createQuery(VehicleOverview.class);
    Root<VehicleOverview> root = criteriaQuery.from(VehicleOverview.class);
    criteriaQuery.select(root);
    
    ParameterExpression<String> params = criteriaBuilder.parameter(String.class);
    criteriaQuery.where(criteriaBuilder.equal(root.get("category"), params));
    
    TypedQuery<VehicleOverview> query = em.createQuery(criteriaQuery);
    query.setParameter(params, category);
    
    return query.getResultList();
  }
  
  public List<VehicleOverview> findByInteriorColor(String id) {
    CriteriaBuilder criteriaBuilder = em.getCriteriaBuilder();
    CriteriaQuery<VehicleOverview> criteriaQuery = criteriaBuilder.createQuery(VehicleOverview.class);
    Root<VehicleOverview> root = criteriaQuery.from(VehicleOverview.class);
    criteriaQuery.select(root);
    
    ParameterExpression<String> params = criteriaBuilder.parameter(String.class);
    criteriaQuery.where(criteriaBuilder.equal(root.get("interiorColor"), params));
    
    TypedQuery<VehicleOverview> query = em.createQuery(criteriaQuery);
    query.setParameter(params, id);
    
    return query.getResultList();
  }
  
  public List<VehicleOverview> findByExteriorColor(String id) {
    CriteriaBuilder criteriaBuilder = em.getCriteriaBuilder();
    CriteriaQuery<VehicleOverview> criteriaQuery = criteriaBuilder.createQuery(VehicleOverview.class);
    Root<VehicleOverview> root = criteriaQuery.from(VehicleOverview.class);
    criteriaQuery.select(root);
    
    ParameterExpression<String> params = criteriaBuilder.parameter(String.class);
    criteriaQuery.where(criteriaBuilder.equal(root.get("exteriorColor"), params));
    
    TypedQuery<VehicleOverview> query = em.createQuery(criteriaQuery);
    query.setParameter(params, id);
    
    return query.getResultList();
  }

  @Override
  public List<VehicleOverview> findByScore(String scoreType, int score) {
    CriteriaBuilder criteriaBuilder = em.getCriteriaBuilder();
    CriteriaQuery<VehicleOverview> criteriaQuery = criteriaBuilder.createQuery(VehicleOverview.class);
    Root<VehicleOverview> root = criteriaQuery.from(VehicleOverview.class);
    criteriaQuery.select(root);
    
    ParameterExpression<Integer> params = criteriaBuilder.parameter(Integer.class);
    criteriaQuery.where(criteriaBuilder.equal(root.get(scoreType + "Score"), params));
    
    TypedQuery<VehicleOverview> query = em.createQuery(criteriaQuery);
    query.setParameter(params, score);
    
    return query.getResultList();
  }

  @Override
  public List<VehicleOverview> findByScoreRange(String scoreType, int lowerScore, int upperScore) {
    CriteriaBuilder criteriaBuilder = em.getCriteriaBuilder();
    CriteriaQuery<VehicleOverview> criteriaQuery = criteriaBuilder.createQuery(VehicleOverview.class);
    Root<VehicleOverview> root = criteriaQuery.from(VehicleOverview.class);

    //Constructing list of parameters
    List<Predicate> predicates = new ArrayList<Predicate>();

    // Add parameters
    predicates.add(criteriaBuilder.greaterThanOrEqualTo(root.<Integer>get(scoreType + "Score"), lowerScore));
    predicates.add(criteriaBuilder.lessThanOrEqualTo(root.<Integer>get(scoreType + "Score"), upperScore));
    
    //query itself
    criteriaQuery.select(root).where(predicates.toArray(new Predicate[]{}));
    
    //execute query and do something with result
    return em.createQuery(criteriaQuery).getResultList();
  }
}