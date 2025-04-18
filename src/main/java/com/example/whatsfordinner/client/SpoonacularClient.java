package com.example.whatsfordinner.client;

import com.example.whatsfordinner.model.Recipe;
import com.example.whatsfordinner.model.RecipeResponseList;
import com.fasterxml.jackson.databind.ObjectMapper;
import okhttp3.HttpUrl;
import okhttp3.OkHttpClient;
import okhttp3.Request;
import okhttp3.Response;
import org.springframework.stereotype.Component;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;

@Component
public class SpoonacularClient {

  private final ObjectMapper mapper;
  private final OkHttpClient client;
  private static final String BASE_URL = "https://api.spoonacular.com";

  public SpoonacularClient() {
    this.mapper = new ObjectMapper();
    this.client = new OkHttpClient.Builder()
        .addInterceptor(new HeaderInterceptor("x-api-key", "")).build();
  }

  public List<Recipe> getRecipes(Map<String, String> params) {
//    try {
//      return mapper.readValue(new File(getClass().getClassLoader().getResource("mockResponses/recipeSearch.json").getFile()), RecipeResponseList.class).getResults();
//    } catch (Exception e) {
//      System.out.println(e.getMessage());
//    }
//
//    return new ArrayList<>();
    String baseGetUrl = BASE_URL + "/recipes/complexSearch";

    HttpUrl.Builder url = HttpUrl.parse(baseGetUrl).newBuilder();
    for (Map.Entry<String, String> entry : params.entrySet()) {
      url.addQueryParameter(entry.getKey(), entry.getValue());
    }

    Request request = new Request.Builder().url(url.build()).build();

    try (Response response = client.newCall(request).execute()) {
      return mapper.readValue(response.body().byteStream(), RecipeResponseList.class).getResults();
    } catch (Exception e) {
      System.out.println(e.getMessage());
    }

    return new ArrayList<>();
  }

}
