package com.example.whatsfordinner.service;

import com.example.whatsfordinner.client.SpoonacularClient;
import com.example.whatsfordinner.model.*;
import org.springframework.stereotype.Service;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import static com.example.whatsfordinner.util.GeneralUtil.isNullOrEmpty;
import static com.example.whatsfordinner.util.GeneralUtil.stringifyList;

@Service
public class RecipeService {

  private final SpoonacularClient client;
  private static final int MAX_RECORDS = 10;
  private static final int DEFAULT_OFFSET = 0;

  public RecipeService(SpoonacularClient client) {
    this.client = client;
  }

  public List<Recipe> searchRecipes(RecipeSearchRequest recipeSearchRequest) {

    Map<String, String> params = new HashMap<>();
    params.put("addRecipeInstructions", "true");
    params.put("addRecipeInformation", "true");
    params.put("fillIngredients", "true");
    params.put("offset", String.valueOf(recipeSearchRequest.getOffset() == null ? DEFAULT_OFFSET : Math.max(DEFAULT_OFFSET, recipeSearchRequest.getOffset())));
    params.put("number", String.valueOf(recipeSearchRequest.getNumResults() == null ? MAX_RECORDS : Math.min(recipeSearchRequest.getNumResults(), MAX_RECORDS)));


    if (!isNullOrEmpty(recipeSearchRequest.getAllergens())) {
      params.put("intolerances", stringifyList(recipeSearchRequest.getAllergens()));
    }

    if (!isNullOrEmpty(recipeSearchRequest.getCuisines())) {
      params.put("cuisine", stringifyList(recipeSearchRequest.getCuisines()));
    }

    if (!isNullOrEmpty(recipeSearchRequest.getDiets())) {
      params.put("diet", stringifyList(recipeSearchRequest.getDiets()));
    }

    if (recipeSearchRequest.getMaxReadyTime() != null) {
      params.put("maxReadyTime", String.valueOf(recipeSearchRequest.getMaxReadyTime()));
    }

    return client.getRecipes(params);
  }
}
