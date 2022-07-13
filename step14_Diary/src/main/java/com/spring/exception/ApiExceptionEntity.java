package com.spring.exception;

import org.springframework.http.HttpStatus;

import lombok.Builder;
import lombok.Getter;
import lombok.ToString;

@Getter
@ToString
public class ApiExceptionEntity {
   private String errorCode;
   private String errorMessage;
   
   @Builder
   public ApiExceptionEntity(HttpStatus status,String errorcode,String errorMessage) {
      this.errorCode = errorcode;
      this.errorMessage =errorMessage;
   }
   
}