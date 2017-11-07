package com.lcq.core;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.http.HttpRequest;

public interface CoreControllerResolver {
  public void doService(HttpServletRequest request,HttpServletResponse response);
}
