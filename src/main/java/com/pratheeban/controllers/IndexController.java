package com.pratheeban.controllers;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

import com.pratheeban.services.RecipeService;

import lombok.extern.slf4j.Slf4j;

@Slf4j
@Controller
public class IndexController {

	private RecipeService recipeService;

	public IndexController(RecipeService recipeService) {
		this.recipeService = recipeService;
	}

	@GetMapping({ "", "/", "/index" })
	public String getIndexPage(Model model) {
		log.debug("Getting index page");
		model.addAttribute("recipes", recipeService.getRecipes());
		return "index";
	}
}
