package ch.amag.webtech.hackathon.repository;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.TypedQuery;
import javax.persistence.criteria.CriteriaBuilder;
import javax.persistence.criteria.CriteriaQuery;
import javax.persistence.criteria.ParameterExpression;
import javax.persistence.criteria.Root;

import org.springframework.transaction.annotation.Transactional;

import ch.amag.webtech.hackathon.entities.VehicleEquipment;

class VehicleEquipmentRepositoryImpl implements VehicleEquipmentRepositoryCustom {
  @PersistenceContext
  private EntityManager em;
  
  @Transactional
  public List<VehicleEquipment> findByVin(String vin) {
    CriteriaBuilder criteriaBuilder = em.getCriteriaBuilder();
    CriteriaQuery<VehicleEquipment> criteriaQuery = criteriaBuilder.createQuery(VehicleEquipment.class);
    Root<VehicleEquipment> root = criteriaQuery.from(VehicleEquipment.class);
    criteriaQuery.select(root);
    
    ParameterExpression<String> params = criteriaBuilder.parameter(String.class);
    criteriaQuery.where(criteriaBuilder.equal(root.get("vin"), params));
    
    TypedQuery<VehicleEquipment> query = em.createQuery(criteriaQuery);
    query.setParameter(params, vin);
    
    return query.getResultList();
  }
}