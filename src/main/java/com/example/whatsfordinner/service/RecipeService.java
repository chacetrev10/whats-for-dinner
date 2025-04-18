package com.example.whatsfordinner.service;

import com.example.whatsfordinner.client.SpoonacularClient;
import com.example.whatsfordinner.model.Recipe;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Map;

import static com.example.whatsfordinner.model.Cuisine.AFRICAN;

@Service
public class RecipeService {

  private final SpoonacularClient client;

  public RecipeService(SpoonacularClient client){
    this.client = client;
  }

  public List<Recipe> searchRecipes() {
    Map<String, String> params = Map.of(
        "cuisine", AFRICAN.toString(),
        "number", "2",
        "addRecipeInstructions", "true",
        "addRecipeInformation", "true",
        "fillIngredients", "true"
    );
    return client.getRecipes(params);
  }
}
