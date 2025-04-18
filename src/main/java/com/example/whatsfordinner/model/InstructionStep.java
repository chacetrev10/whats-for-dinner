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
public class InstructionStep {

  private int number;
  private String step;
  private List<GeneralCookingIdentifier> ingredients;
  private List<GeneralCookingIdentifier> equipment;
  private Duration length;

}
