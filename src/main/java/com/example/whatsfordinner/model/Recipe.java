package com.example.whatsfordinner.model;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.util.List;

@Getter
@Setter
@NoArgsConstructor
@JsonIgnoreProperties(ignoreUnknown = true)
public class Recipe {

  private String id;
  private String image;
  private String title;
  private int readyInMinutes;
  private int servings;
  private String sourceUrl;
  private List<Ingredient> extendedIngredients;
  private String summary;
  private List<Cuisine> cuisines;
  private List<String> dishTypes;
  private List<RecipeInstructions> analyzedInstructions;

}
