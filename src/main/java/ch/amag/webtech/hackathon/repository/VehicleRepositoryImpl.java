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

class VehicleRepositoryImpl implements VehicleRepositoryCustom {
  @PersistenceContext
  private EntityManager em;
  
  @Transactional
  public void saveBatch(List<Vehicle> vehicles) {
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
  
  public Vehicle findByCommission(String commission) {
    Query query = em.createQuery("SELECT vin FROM vehicle WHERE commission = ?1");
    query.setParameter(1, commission);
    
    return (Vehicle) query.getSingleResult();
  }
  
  public List<Vehicle> findByGearType(String gearType) {
    CriteriaBuilder criteriaBuilder = em.getCriteriaBuilder();
    CriteriaQuery<Vehicle> criteriaQuery = criteriaBuilder.createQuery(Vehicle.class);
    Root<Vehicle> root = criteriaQuery.from(Vehicle.class);
    criteriaQuery.select(root);
    
    ParameterExpression<String> params = criteriaBuilder.parameter(String.class);
    criteriaQuery.where(criteriaBuilder.equal(root.get("gearType"), params));
    
    TypedQuery<Vehicle> query = em.createQuery(criteriaQuery);
    query.setParameter(params, gearType);
    
    return query.getResultList();
  }
  
  public List<Vehicle> findByFuelType(String fuelType) {
    CriteriaBuilder criteriaBuilder = em.getCriteriaBuilder();
    CriteriaQuery<Vehicle> criteriaQuery = criteriaBuilder.createQuery(Vehicle.class);
    Root<Vehicle> root = criteriaQuery.from(Vehicle.class);
    criteriaQuery.select(root);
    
    ParameterExpression<String> params = criteriaBuilder.parameter(String.class);
    criteriaQuery.where(criteriaBuilder.equal(root.get("fuelType"), params));
    
    TypedQuery<Vehicle> query = em.createQuery(criteriaQuery);
    query.setParameter(params, fuelType);
    
    return query.getResultList();
  }
  
  public List<Vehicle> findByCategory(String category) {
    CriteriaBuilder criteriaBuilder = em.getCriteriaBuilder();
    CriteriaQuery<Vehicle> criteriaQuery = criteriaBuilder.createQuery(Vehicle.class);
    Root<Vehicle> root = criteriaQuery.from(Vehicle.class);
    criteriaQuery.select(root);
    
    ParameterExpression<String> params = criteriaBuilder.parameter(String.class);
    criteriaQuery.where(criteriaBuilder.equal(root.get("category"), params));
    
    TypedQuery<Vehicle> query = em.createQuery(criteriaQuery);
    query.setParameter(params, category);
    
    return query.getResultList();
  }
  
  public List<Vehicle> findByDealer(int dealerId) {
    CriteriaBuilder criteriaBuilder = em.getCriteriaBuilder();
    CriteriaQuery<Vehicle> criteriaQuery = criteriaBuilder.createQuery(Vehicle.class);
    Root<Vehicle> root = criteriaQuery.from(Vehicle.class);
    criteriaQuery.select(root);
    
    ParameterExpression<Integer> params = criteriaBuilder.parameter(Integer.class);
    criteriaQuery.where(criteriaBuilder.equal(root.get("dealer"), params));
    
    TypedQuery<Vehicle> query = em.createQuery(criteriaQuery);
    query.setParameter(params, dealerId);
    
    return query.getResultList();
  }
  
  public List<Vehicle> findByInteriorColor(String id) {
    CriteriaBuilder criteriaBuilder = em.getCriteriaBuilder();
    CriteriaQuery<Vehicle> criteriaQuery = criteriaBuilder.createQuery(Vehicle.class);
    Root<Vehicle> root = criteriaQuery.from(Vehicle.class);
    criteriaQuery.select(root);
    
    ParameterExpression<String> params = criteriaBuilder.parameter(String.class);
    criteriaQuery.where(criteriaBuilder.equal(root.get("interiorColor"), params));
    
    TypedQuery<Vehicle> query = em.createQuery(criteriaQuery);
    query.setParameter(params, id);
    
    return query.getResultList();
  }
  
  public List<Vehicle> findByExteriorColor(String id) {
    CriteriaBuilder criteriaBuilder = em.getCriteriaBuilder();
    CriteriaQuery<Vehicle> criteriaQuery = criteriaBuilder.createQuery(Vehicle.class);
    Root<Vehicle> root = criteriaQuery.from(Vehicle.class);
    criteriaQuery.select(root);
    
    ParameterExpression<String> params = criteriaBuilder.parameter(String.class);
    criteriaQuery.where(criteriaBuilder.equal(root.get("exteriorColor"), params));
    
    TypedQuery<Vehicle> query = em.createQuery(criteriaQuery);
    query.setParameter(params, id);
    
    return query.getResultList();
  }

  @Override
  public List<Vehicle> findByScore(String scoreType, int score) {
    CriteriaBuilder criteriaBuilder = em.getCriteriaBuilder();
    CriteriaQuery<Vehicle> criteriaQuery = criteriaBuilder.createQuery(Vehicle.class);
    Root<Vehicle> root = criteriaQuery.from(Vehicle.class);
    criteriaQuery.select(root);
    
    ParameterExpression<Integer> params = criteriaBuilder.parameter(Integer.class);
    criteriaQuery.where(criteriaBuilder.equal(root.get(scoreType + "Score"), params));
    
    TypedQuery<Vehicle> query = em.createQuery(criteriaQuery);
    query.setParameter(params, score);
    
    return query.getResultList();
  }

  @Override
  public List<Vehicle> findByScoreRange(String scoreType, int lowerScore, int upperScore) {
    CriteriaBuilder criteriaBuilder = em.getCriteriaBuilder();
    CriteriaQuery<Vehicle> criteriaQuery = criteriaBuilder.createQuery(Vehicle.class);
    Root<Vehicle> root = criteriaQuery.from(Vehicle.class);

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
  
  @Override
  public List<Vehicle> findRandomAmount(int amount) {
    Query query = em.createQuery("SELECT v FROM Vehicle v ORDER BY RAND()").setMaxResults(amount);
    
    return (List<Vehicle>) query.getResultList();
  }
  
  @Override
  public List<Vehicle> findRandomAmountOfBrand(int amount, String brand) {
    Query query = em.createQuery("SELECT v FROM Vehicle v WHERE brand = ?1 ORDER BY RAND()").setMaxResults(amount);
    query.setParameter(1, brand);
    
    return (List<Vehicle>) query.getResultList();
  }
}