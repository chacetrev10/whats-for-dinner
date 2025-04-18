package com.example.whatsfordinner.controller;

import com.example.whatsfordinner.model.Recipe;
import com.example.whatsfordinner.service.RecipeService;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("/recipes")
public class RecipeController {

  private final RecipeService recipeService;

  public RecipeController(RecipeService recipeService) {
    this.recipeService = recipeService;
  }


  @GetMapping
  public List<Recipe> getRecipes(){
    return recipeService.searchRecipes();
  }
}
