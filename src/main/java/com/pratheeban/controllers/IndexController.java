package com.pratheeban.controllers;

import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

public class IndexController {
	@GetMapping({ "", "/", "/index" })
	public String getIndexPage(Model model) {

		// model.addAttribute("recipes", recipeService.getRecipes());

		return "index";
	}
}
