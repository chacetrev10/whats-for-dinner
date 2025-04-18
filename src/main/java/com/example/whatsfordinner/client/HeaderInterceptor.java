package com.example.whatsfordinner.client;

import okhttp3.Interceptor;
import okhttp3.Request;
import okhttp3.Response;
import org.jetbrains.annotations.NotNull;

import java.io.IOException;

public class HeaderInterceptor implements Interceptor {
  private final String headerName;
  private final String headerValue;

  public HeaderInterceptor(String headerName, String headerValue) {
    this.headerName = headerName;
    this.headerValue = headerValue;
  }

  @NotNull
  @Override
  public Response intercept(Chain chain) throws IOException {
    Request originalRequest = chain.request();
    Request modifiedRequest = originalRequest.newBuilder()
        .header(headerName, headerValue)
        .build();
    return chain.proceed(modifiedRequest);
  }
}
