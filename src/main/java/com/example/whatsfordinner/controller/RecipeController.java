package com.example.whatsfordinner.controller;

import com.example.whatsfordinner.model.*;
import com.example.whatsfordinner.service.RecipeService;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/recipes")
public class RecipeController {

  private final RecipeService recipeService;

  public RecipeController(RecipeService recipeService) {
    this.recipeService = recipeService;
  }

  @PostMapping("/search")
  public List<Recipe> searchRecipes(@RequestBody RecipeSearchRequest recipeSearchRequest) {
    return recipeService.searchRecipes(recipeSearchRequest);
  }

  @GetMapping("/filters")
  public RecipeFilters getFilters() {
    return recipeService.getRecipeFilters();

  }
}
