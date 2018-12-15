package com.pratheeban.repositories;

import org.springframework.data.repository.CrudRepository;
import com.pratheeban.domain.Recipe;

public interface RecipeRepository extends CrudRepository<Recipe, Long> {
}
