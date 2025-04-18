package com.example.whatsfordinner.model;

import com.fasterxml.jackson.annotation.JsonCreator;
import com.fasterxml.jackson.annotation.JsonValue;

public enum Diet {

  GLUTEN_FREE("Gluten Free"),
  KETOGENIC("Ketogenic"),
  VEGETARIAN("Vegetarian"),
  LACTO_VEGETARIAN("Lacto-Vegetarian"),
  OVO_VEGETARIAN("Ovo-Vegetarian"),
  VEGAN("Vegan"),
  PESCETARIAN("Pescetarian"),
  PALEO("Paleo"),
  PRIMAL("Primal"),
  LOW_FODMAP("Low FODMAP"),
  WHOLE30("Whole30");

  private final String name;

  Diet(String name){
    this.name = name;
  }

  @Override
  public String toString(){
    return this.name;
  }

  @JsonValue
  public String getName() {
    return this.name;
  }

  @JsonCreator
  public static Diet fromName(String name) {
    for (Diet diet : Diet.values()) {
      if (diet.name.equalsIgnoreCase(name)) {
        return diet;
      }
    }
    throw new IllegalArgumentException("Unknown diet: " + name);
  }
}
