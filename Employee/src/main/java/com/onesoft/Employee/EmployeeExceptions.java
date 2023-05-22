package com.onesoft.Employee;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestControllerAdvice;

@RestControllerAdvice
public class EmployeeExceptions {
	@ExceptionHandler(EmployeeNotFoundException.class)
	public ResponseEntity<Object> idNotfound(){
		return new ResponseEntity<> ("no such employee",HttpStatus.NOT_FOUND);
	}
@ExceptionHandler(NameNotFoundException.class)
public ResponseEntity<Object> namenotFound(){
	return new ResponseEntity<> ("name of employee not found",HttpStatus.NOT_FOUND);
}
@ExceptionHandler(AgeNotFoundException.class)
public ResponseEntity<Object> agenotFound(){
	return new ResponseEntity<> ("under age",HttpStatus.NOT_FOUND);
}
}
