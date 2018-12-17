package com.pratheeban.services;

import java.util.Set;

import com.pratheeban.domain.Recipe;

public interface RecipeService {

	Set<Recipe> getRecipes();

	Recipe findById(Long l);

	void deleteById(Long id);
}
