package com.pratheeban.services;

import static org.junit.Assert.*;
import static org.mockito.Mockito.*;

import java.util.HashSet;
import java.util.Optional;
import java.util.Set;

import org.junit.Before;
import org.junit.Test;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;

import com.pratheeban.commands.RecipeCommand;
import com.pratheeban.converters.RecipeCommandToRecipe;
import com.pratheeban.converters.RecipeToRecipeCommand;
import com.pratheeban.domain.Recipe;
import com.pratheeban.exceptions.NotFoundException;
import com.pratheeban.repositories.RecipeRepository;

public class RecipeServiceImplTest {

	RecipeServiceImpl recipeService;

	@Mock
	RecipeRepository recipeRepository;
	@Mock
	RecipeCommandToRecipe recipeCommandToRecipe;
	@Mock
	RecipeToRecipeCommand recipeToRecipeCommand;

	@Before
	public void setUp() throws Exception {
		MockitoAnnotations.initMocks(this);

		recipeService = new RecipeServiceImpl(recipeRepository, recipeCommandToRecipe, recipeToRecipeCommand);
	}

	@Test
	public void getRecipeByIdTest() throws Exception {
		Recipe recipe = new Recipe();
		recipe.setId(1L);
		Optional<Recipe> recipeOptional = Optional.of(recipe);

		when(recipeRepository.findById(anyLong())).thenReturn(recipeOptional);

		Recipe recipeReturned = recipeService.findById(1L);

		assertNotNull("Null recipe returned", recipeReturned);
		verify(recipeRepository, times(1)).findById(anyLong());
		verify(recipeRepository, never()).findAll();
	}
	
	@Test(expected = NotFoundException.class)
	public void findByIdTestNotFound() throws Exception {
		Optional<Recipe> recipeOptional = Optional.empty();

		when(recipeRepository.findById(anyLong())).thenReturn(recipeOptional);

		recipeService.findById(1L);
	}

	@Test
	public void getRecipeCommandById() throws Exception {
		Recipe recipe = new Recipe();
		recipe.setId(1L);
		Optional<Recipe> recipeOptional = Optional.of(recipe);

		when(recipeRepository.findById(anyLong())).thenReturn(recipeOptional);

		RecipeCommand recipeCommand = new RecipeCommand();
		recipeCommand.setId(1L);

		when(recipeToRecipeCommand.convert(any())).thenReturn(recipeCommand);

		RecipeCommand commandById = recipeService.findCommandById(1L);

		assertNotNull("Null recipe command returned", commandById);
		verify(recipeRepository, times(1)).findById(anyLong());
		verify(recipeRepository, never()).findAll();
	}

	@Test
	public void getRecipesTest() throws Exception {

		Recipe recipe = new Recipe();
		Set<Recipe> receipesData = new HashSet();
		receipesData.add(recipe);

		when(recipeService.getRecipes()).thenReturn(receipesData);

		Set<Recipe> recipes = recipeService.getRecipes();

		assertEquals(recipes.size(), 1);
		verify(recipeRepository, times(1)).findAll();
	}

	@Test
	public void deleteByIdTest() throws Exception {
		Long idDelete = Long.valueOf(2L);

		recipeService.deleteById(idDelete);

		verify(recipeRepository, times(1)).deleteById(anyLong());
	}
}
