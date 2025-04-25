package com.example.whatsfordinner.service;

import com.example.whatsfordinner.client.SpoonacularClient;
import com.example.whatsfordinner.model.*;
import org.springframework.stereotype.Service;

import java.util.Arrays;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

import static com.example.whatsfordinner.util.GeneralUtil.isNullOrEmpty;
import static com.example.whatsfordinner.util.GeneralUtil.stringifyList;
import static com.example.whatsfordinner.util.RecipeConstants.*;

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
      params.put(INTOLERANCES, stringifyList(recipeSearchRequest.getAllergens()));
    }

    if (!isNullOrEmpty(recipeSearchRequest.getCuisines())) {
      params.put(CUISINE, stringifyList(recipeSearchRequest.getCuisines()));
    }

    if (!isNullOrEmpty(recipeSearchRequest.getDiets())) {
      params.put(DIET, stringifyList(recipeSearchRequest.getDiets()));
    }

    if (recipeSearchRequest.getMaxReadyTime() != null) {
      params.put(MAX_READY_TIME, String.valueOf(recipeSearchRequest.getMaxReadyTime()));
    }

    return client.getRecipes(params);
  }

  public RecipeFilters getRecipeFilters(){
    Map<String, List<String>> dropdowns = new HashMap<>();

    dropdowns.put(INTOLERANCES, Arrays.stream(Allergen.values()).map(Allergen::getName).collect(Collectors.toList()));
    dropdowns.put(CUISINE, Arrays.stream(Cuisine.values()).map(Cuisine::getName).collect(Collectors.toList()));
    dropdowns.put(DIET, Arrays.stream(Diet.values()).map(Diet::getName).collect(Collectors.toList()));

    List<String> inputs = List.of(MAX_READY_TIME);
    return new RecipeFilters(dropdowns, inputs);

  }
}
