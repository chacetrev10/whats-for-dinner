package com.example.whatsfordinner.model;

import com.fasterxml.jackson.annotation.JsonCreator;
import com.fasterxml.jackson.annotation.JsonValue;

public enum MealType {
  MAIN_COURSE("Main Course"),
  SIDE_DISH("Side Dish"),
  DESSERT("Dessert"),
  APPETIZER("Appetizer"),
  SALAD("Salad"),
  BREAD("Bread"),
  BREAKFAST("Breakfast"),
  SOUP("Soup"),
  BEVERAGE("Beverage"),
  SAUCE("Sauce"),
  MARINADE("Marinade"),
  FINGERFOOD("Fingerfood"),
  SNACK("Snack"),
  DRINK("Drink");

  private final String name;

  MealType(String name) {
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
  public static MealType fromName(String name) {
    for (MealType mealType : MealType.values()) {
      if (mealType.name.equalsIgnoreCase(name)) {
        return mealType;
      }
    }
    throw new IllegalArgumentException("Unknown mealType: " + name);
  }
}
