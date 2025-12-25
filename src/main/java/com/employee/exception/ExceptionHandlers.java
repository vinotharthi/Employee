package com.employee.exception;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestControllerAdvice;


@RestControllerAdvice
public class ExceptionHandlers {
		@ExceptionHandler(IdNotFoundException.class)
		public ResponseEntity<Object> IdNot(IdNotFoundException ie){
			return new ResponseEntity<Object>(ie.getMessage(),HttpStatus.BAD_GATEWAY);
		}
		
		@ExceptionHandler(NameNotFoundException.class)
		public ResponseEntity<Object>NameNot(NameNotFoundException ne){
			return new ResponseEntity<Object>(ne.getMessage(),HttpStatus.NOT_FOUND);
		}
		@ExceptionHandler(SalaryNotFoundException.class)
		public ResponseEntity<Object>SalaryNot(SalaryNotFoundException se){
			return new ResponseEntity<Object>(se.getMessage(),HttpStatus.BAD_REQUEST);
		}



}
