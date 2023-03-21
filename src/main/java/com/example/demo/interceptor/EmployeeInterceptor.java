package com.example.demo.interceptor;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Component;
import org.springframework.web.servlet.HandlerInterceptor;

import com.example.demo.exception.InvalidUrlException;

@Component
public class EmployeeInterceptor implements HandlerInterceptor {

    Logger logger = LoggerFactory.getLogger(EmployeeInterceptor.class);

   @Override
    public boolean preHandle(HttpServletRequest request, HttpServletResponse response, Object handler) throws IllegalAccessException {

           if(request.getRequestURI().equals("/")) {
               throw new InvalidUrlException("You are not allowed to root");
            }

           logger.info("URL: " + request.getRequestURI() + " | Method: " + request.getMethod());
           return true;
   }

}