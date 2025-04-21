package com.example.whatsfordinner.util;

import java.util.List;
import java.util.stream.Collectors;

public class GeneralUtil {

  public static boolean isNullOrEmpty(List<?> list){
    return list == null || list.isEmpty();
  }

  public static <T> String stringifyList(List<T> list){
    return list.stream()
        .map(T::toString)
        .collect(Collectors.joining(","));
  }
}
