package ch.amag.webtech.hackathon.repository;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.TypedQuery;
import javax.persistence.criteria.CriteriaBuilder;
import javax.persistence.criteria.CriteriaQuery;
import javax.persistence.criteria.ParameterExpression;
import javax.persistence.criteria.Root;

import org.springframework.beans.factory.annotation.Autowired;

import ch.amag.webtech.hackathon.entities.GearType;

public class GearTypeRepositoryImpl implements GearTypeRepositoryCustom {
  @Autowired
  EntityManager em;
  
  @Override
  public List<GearType> findByCategory(String category) {
    CriteriaBuilder criteriaBuilder = em.getCriteriaBuilder();
    CriteriaQuery<GearType> criteriaQuery = criteriaBuilder.createQuery(GearType.class);
    Root<GearType> root = criteriaQuery.from(GearType.class);
    criteriaQuery.select(root);
    
    ParameterExpression<String> params = criteriaBuilder.parameter(String.class);
    criteriaQuery.where(criteriaBuilder.equal(root.get("category"), params));
    
    TypedQuery<GearType> query = em.createQuery(criteriaQuery);
    query.setParameter(params, category);
    
    return query.getResultList();
  }

}
