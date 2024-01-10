package com.foodDelevery.app.exception;

import java.time.LocalDateTime;

import com.foodDelevery.app.enums.ExceptionType;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@AllArgsConstructor
@NoArgsConstructor
@Data
public class MyErrorDetails {

	private LocalDateTime timestamp;
	private String message;
	private String details;
	private ExceptionType exceptionType;
}
