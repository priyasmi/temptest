package com.example.demo.exceptionHandle;

import java.util.List;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.servlet.mvc.method.annotation.ResponseEntityExceptionHandler;

import com.example.demo.domain.Employee;
import com.example.demo.domain.ResponseDTO;




@ControllerAdvice
@ResponseStatus
public class GeneralException extends ResponseEntityExceptionHandler {
	
	@ExceptionHandler(BusinessException.class)	
	private ResponseEntity<ResponseDTO<Object>> processException(BusinessException exc) {
		int code = exc.getErrorCode();
		ResponseDTO<Object> response = new ResponseDTO<>(true,code ,exc.getMessage(), null);
		return new ResponseEntity<>(response,HttpStatus.CONFLICT);
	}
	
	@ExceptionHandler(DataRepositoryException.class)
	@ResponseStatus(HttpStatus.INTERNAL_SERVER_ERROR)
	private ResponseDTO<Object> processException(DataRepositoryException exc) {
		return new ResponseDTO<>(true, HttpStatus.INTERNAL_SERVER_ERROR.value(), "DBException", null);
	}

}
