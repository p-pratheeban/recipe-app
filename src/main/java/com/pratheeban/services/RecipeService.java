package com.pratheeban.services;

import java.util.Set;

import com.pratheeban.commands.RecipeCommand;
import com.pratheeban.domain.Recipe;

public interface RecipeService {

	Set<Recipe> getRecipes();

	Recipe findById(Long l);

	RecipeCommand findCommandById(Long l);

	RecipeCommand saveRecipeCommand(RecipeCommand command);

	void deleteById(Long id);
}
