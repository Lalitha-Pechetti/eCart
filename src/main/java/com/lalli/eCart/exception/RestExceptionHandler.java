package com.lalli.eCart.exception;

import java.util.Date;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.MethodArgumentNotValidException;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.context.request.WebRequest;

@ControllerAdvice
public class RestExceptionHandler {
	@ExceptionHandler(value= UserDoesNotExistException.class)
	
	public ResponseEntity<AppErrorDetails> handleUserDoesNotExistException(UserDoesNotExistException ex, WebRequest request){
		
		//AppErrorDetails ae=new AppErrorDetails(new Date(),ex.getMessage(),request.getDescription(false), null);
		AppErrorDetails appErrorDetails=new AppErrorDetails();
		appErrorDetails.setTimestamp(new Date());
		appErrorDetails.setMessage(ex.getMessage());
		appErrorDetails.setDetails(request.getDescription(false));
		
		return  new ResponseEntity<AppErrorDetails>(appErrorDetails, HttpStatus.BAD_REQUEST);

}
	@ExceptionHandler(value=ApplicationErrorException.class)
	public ResponseEntity<AppErrorDetails> handleApplicationErrorException(ApplicationErrorException ex,WebRequest request){
//AppErrorDetails ae=new AppErrorDetails(new Date(),ex.getMessage(),request.getDescription(false),ex.getCause().getMessage());
		AppErrorDetails appErrorDetails=new AppErrorDetails();
		appErrorDetails.setTimestamp(new Date());
		appErrorDetails.setMessage(ex.getMessage());
		appErrorDetails.setDetails(request.getDescription(false));
		appErrorDetails.setCause(ex.getCause().getMessage());
		return  new ResponseEntity<AppErrorDetails>(appErrorDetails,HttpStatus.INTERNAL_SERVER_ERROR);
	}
@ExceptionHandler(value= EmailAlreadyExistsException.class)
	
	public ResponseEntity<AppErrorDetails> handleEmailAlreadyExistsException(EmailAlreadyExistsException ex, WebRequest request){
		
		//AppErrorDetails ae=new AppErrorDetails(new Date(),ex.getMessage(),request.getDescription(false), null);
		AppErrorDetails appErrorDetails=new AppErrorDetails();
		appErrorDetails.setTimestamp(new Date());
		appErrorDetails.setMessage(ex.getMessage());
		appErrorDetails.setDetails(request.getDescription(false));
		
		return  new ResponseEntity<AppErrorDetails>(appErrorDetails, HttpStatus.BAD_REQUEST);

}

	
}
	

