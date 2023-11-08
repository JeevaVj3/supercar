package com.onesoft.supercar.exception;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RestControllerAdvice;

@RestControllerAdvice
public class GlobalException {

	@ExceptionHandler(ColourNotFound.class)
	public ResponseEntity<Object> ColourNotFoundhandling(ColourNotFound a) {
		return new ResponseEntity<>(a.getMessage(), HttpStatus.NOT_FOUND);
	}

	@ExceptionHandler(PriceNotAvailable.class)
	public ResponseEntity<Object> PriceNotAvailablehandling(PriceNotAvailable b) {
		return new ResponseEntity<>(b.getMessage(), HttpStatus.NOT_FOUND);
	}

	@ExceptionHandler(MilageNotAvailable.class)
	public ResponseEntity<Object> MilageNotAvailablehandling(MilageNotAvailable a) {
		return new ResponseEntity<>(a.getMessage(), HttpStatus.NOT_FOUND);
	}

	@ExceptionHandler(BrandNotFound.class)
	public ResponseEntity<Object> BrandNotFoundhandling(BrandNotFound c) {
		return new ResponseEntity(c.getMessage(), HttpStatus.NOT_FOUND);
	}

	@ExceptionHandler(CcNotAvailable.class)
	public ResponseEntity<Object> CcNotAvailablehandling(CcNotAvailable c) {
		return new ResponseEntity<Object>(c.getMessage(), HttpStatus.NOT_FOUND);
	}
	
}
