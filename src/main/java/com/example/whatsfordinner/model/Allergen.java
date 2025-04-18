package com.example.whatsfordinner.model;

import com.fasterxml.jackson.annotation.JsonCreator;
import com.fasterxml.jackson.annotation.JsonValue;

public enum Allergen {
  DAIRY("Dairy"),
  EGG("Egg"),
  GLUTEN("Gluten"),
  GRAIN("Grain"),
  PEANUT("Peanut"),
  SEAFOOD("Seafood"),
  SESAME("Sesame"),
  SHELLFISH("Shellfish"),
  SOY("Soy"),
  SULFITE("Sulfite"),
  TREE_NUT("Tree Nut"),
  WHEAT("Wheat");

  private final String name;

  Allergen(String name) {
    this.name = name;
  }

  @Override
  public String toString() {
    return this.name;
  }

  @JsonValue
  public String getName() {
    return this.name;
  }

  @JsonCreator
  public static Allergen fromName(String name) {
    for (Allergen allergen : Allergen.values()) {
      if (allergen.name.equalsIgnoreCase(name)) {
        return allergen;
      }
    }
    throw new IllegalArgumentException("Unknown allergen: " + name);
  }
}

