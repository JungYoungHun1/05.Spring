package com.spring.exception;

import org.springframework.http.HttpStatus;

import lombok.Getter;
import lombok.ToString;

@Getter
@ToString
public enum ExceptionEnum {
   NOT_FOUND(HttpStatus.NOT_FOUND,"404"),
   
   SECURITY_001(HttpStatus.NOT_FOUND,"404","Not Found");
   
   private final HttpStatus status;
   private final String code;
   private String message;
   
   private ExceptionEnum(HttpStatus status, String code) {
      this.status = status;
      this.code = code;
   }
   
   private ExceptionEnum(HttpStatus status, String code, String message) {
      this.status = status;
      this.code = code;
      this.message = message;
   }
}