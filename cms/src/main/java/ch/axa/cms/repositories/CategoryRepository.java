package ch.axa.cms.repositories;

import org.springframework.data.repository.CrudRepository;

import ch.axa.cms.models.Category;

public interface CategoryRepository extends CrudRepository<Category, Long> {}
