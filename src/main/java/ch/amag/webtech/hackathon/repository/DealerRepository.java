package ch.amag.webtech.hackathon.repository;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Component;

import ch.amag.webtech.hackathon.entities.Dealer;

@Component
public interface DealerRepository extends CrudRepository<Dealer, Integer>, DealerRepositoryCustom {}
