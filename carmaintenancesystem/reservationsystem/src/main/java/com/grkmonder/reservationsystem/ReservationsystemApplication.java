package com.grkmonder.reservationsystem;

import java.util.HashMap;

import org.modelmapper.ModelMapper;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;
import org.springframework.http.HttpStatus;
import org.springframework.transaction.annotation.EnableTransactionManagement;
import org.springframework.validation.FieldError;
import org.springframework.web.bind.MethodArgumentNotValidException;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestControllerAdvice;

import com.grkmonder.reservationsystem.core.utilities.exceptions.BusinessException;
import com.grkmonder.reservationsystem.core.utilities.exceptions.ProblemDetails;
import com.grkmonder.reservationsystem.core.utilities.exceptions.ValidationProblemDetails;

@SpringBootApplication
@RestControllerAdvice
@EnableTransactionManagement
public class ReservationsystemApplication {

	public static void main(String[] args) {
		SpringApplication.run(ReservationsystemApplication.class, args);
	}
	@ExceptionHandler
	@ResponseStatus(code=HttpStatus.BAD_REQUEST)
	public ProblemDetails handleBusinessException(BusinessException businessException)
	{
		ProblemDetails problemDetails = new ProblemDetails();
		problemDetails.setMessage(businessException.getMessage());
		
		return problemDetails;
	}
	
	@ExceptionHandler
	@ResponseStatus(code=HttpStatus.BAD_REQUEST)
	public ProblemDetails handleValidationException(MethodArgumentNotValidException methodArgumentNotValidException)
	{
		ValidationProblemDetails validationProblemDetails = new ValidationProblemDetails();
		validationProblemDetails.setMessage("VALIDATION.EXCEPTION");
		
		
		validationProblemDetails.setValidationErrors(new HashMap<String, String>());
		
		for (FieldError fieldError : methodArgumentNotValidException.getBindingResult().getFieldErrors()) {
		validationProblemDetails.getValidationErrors().put(fieldError.getField(), fieldError.getDefaultMessage());	
		}
		
		return validationProblemDetails;
	}
	
	@Bean
	public ModelMapper getModelMapper() {
		return new ModelMapper();
	}
}
