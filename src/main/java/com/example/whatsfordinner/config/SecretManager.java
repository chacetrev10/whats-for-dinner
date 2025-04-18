package com.example.whatsfordinner.config;

import com.fasterxml.jackson.databind.ObjectMapper;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Component;

import java.io.File;
import java.io.IOException;
import java.util.HashMap;
import java.util.Map;

@Component
public class SecretManager {

  private final Map<String, String> secrets;

  public SecretManager(@Value("${secrets.filePath}") String secretFilePath){
    ObjectMapper objectMapper = new ObjectMapper();
    secrets = new HashMap<>();
    try {
      Map<?,?> rawMap = objectMapper.readValue(new File(secretFilePath), Map.class);
      for(Map.Entry<?,?> entry: rawMap.entrySet()){
        if(entry.getKey() instanceof String && entry.getValue() instanceof String){
          secrets.put((String) entry.getKey(), (String) entry.getValue());
        }
      }
    } catch (IOException e) {
      System.out.println("Unable to load secrets\n" + e.getMessage());
    }
  }

  public String getSecret(String key) {
    return secrets.get(key);
  }




}
