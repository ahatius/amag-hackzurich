package ch.amag.webtech.hackathon.repository;

import org.springframework.data.repository.CrudRepository;

import ch.amag.webtech.hackathon.entities.Category;

public interface CategoryRepository extends CrudRepository<Category, String> {}
