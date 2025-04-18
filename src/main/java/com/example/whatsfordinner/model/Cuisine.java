package com.example.whatsfordinner.model;

import com.fasterxml.jackson.annotation.JsonCreator;
import com.fasterxml.jackson.annotation.JsonValue;

public enum Cuisine {
  AFRICAN("African"),
  ASIAN("Asian"),
  AMERICAN("American"),
  BRITISH("British"),
  CAJUN("Cajun"),
  CARIBBEAN("Caribbean"),
  CHINESE("Chinese"),
  EASTERN_EUROPEAN("Eastern European"),
  EUROPEAN("European"),
  FRENCH("French"),
  GERMAN("German"),
  GREEK("Greek"),
  INDIAN("Indian"),
  IRISH("Irish"),
  ITALIAN("Italian"),
  JAPANESE("Japanese"),
  JEWISH("Jewish"),
  KOREAN("Korean"),
  LATIN_AMERICAN("Latin American"),
  MEDITERRANEAN("Mediterranean"),
  MEXICAN("Mexican"),
  MIDDLE_EASTERN("Middle Eastern"),
  NORDIC("Nordic"),
  SOUTHERN("Southern"),
  SPANISH("Spanish"),
  THAI("Thai"),
  VIETNAMESE("Vietnamese");

  private final String name;

  Cuisine(String name) {
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
  public static Cuisine fromName(String name) {
    for (Cuisine cuisine : Cuisine.values()) {
      if (cuisine.name.equalsIgnoreCase(name)) {
        return cuisine;
      }
    }
    throw new IllegalArgumentException("Unknown cuisine: " + name);
  }
}
