package com.brainyinvoiceai.controller;

import java.io.IOException;
import java.sql.SQLException;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.web.HttpRequestMethodNotSupportedException;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.multipart.MultipartException;

import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

@ControllerAdvice
public class GlobalExceptionHandler {
 
	private static final Logger logger = LoggerFactory.getLogger(GlobalExceptionHandler.class);
	
	
	@ExceptionHandler(SQLException.class)
	public String handleSQLException(HttpServletRequest request, Exception ex){
		logger.info("SQLException Occured:: URL="+request.getRequestURL());
		logger.info("SQLException Occured:: URL="+ex.getMessage());
		return "connect_error";
	}
	
	@ExceptionHandler(IOException.class)
    public String handleIOException(HttpServletRequest request, Exception ex) {
        return "connect_error";
    } 
    @ExceptionHandler(MultipartException.class)
    public String handleMultipartException(HttpServletRequest request) {
        return "connect_error";
    }
     
    @ExceptionHandler(HttpRequestMethodNotSupportedException.class)
    public String handleMethodNotSupported(HttpServletRequest request) {
        return "connect_error";
    }
     
    @ExceptionHandler(Exception.class)
    public String handleGeneralError(HttpServletRequest request, HttpServletResponse response, Exception ex) {
         
        // do something with request and response
         
        return "connect_error";
    }
}