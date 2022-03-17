package com.olix.order_system.api.handler;

import java.util.HashMap;
import java.util.Map;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.FieldError;
import org.springframework.validation.ObjectError;
import org.springframework.web.bind.MethodArgumentNotValidException;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;

import com.olix.order_system.common.helper.ResponseValue;
import com.olix.order_system.domain.exception.ModelNotFoundException;

@ControllerAdvice
public class DefaultExceptionHandler {

	@ExceptionHandler(MethodArgumentNotValidException.class)
	protected ResponseEntity<Map<String, String>> methodArgumentNotValidException(
			MethodArgumentNotValidException exception) {
		Map<String, String> responseBody = new HashMap<String, String>();
		for (ObjectError error : exception.getAllErrors()) {
			String fieldName = ((FieldError) error).getField();
			String contentField = error.getDefaultMessage();
			responseBody.put(fieldName, contentField);
		}
		return new ResponseEntity<Map<String, String>>(responseBody, HttpStatus.BAD_REQUEST);
	}

	@ExceptionHandler(ModelNotFoundException.class)
	protected ResponseEntity<ResponseValue> modelNotFoundException(ModelNotFoundException exception) {
		ResponseValue responseBody = new ResponseValue(exception.getMessage());
		return new ResponseEntity<ResponseValue>(responseBody, HttpStatus.BAD_REQUEST);
	}
}
