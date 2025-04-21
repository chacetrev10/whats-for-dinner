package com.example.whatsfordinner.model;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.util.List;

@Getter
@Setter
@NoArgsConstructor
public class RecipeSearchRequest {
  List<Allergen> allergens;
  List<Cuisine> cuisines;
  List<Diet> diets;
  Integer maxReadyTime;
  Integer offset;
  Integer numResults;
}
