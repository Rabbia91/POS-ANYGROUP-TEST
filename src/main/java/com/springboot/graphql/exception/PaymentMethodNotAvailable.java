package com.springboot.graphql.exception;

import java.util.Collections;
import java.util.List;
import java.util.Map;

import graphql.ErrorClassification;
import graphql.GraphQLError;
import graphql.language.SourceLocation;

public class PaymentMethodNotAvailable extends RuntimeException implements GraphQLError{
	
    private String invalidField;


    public PaymentMethodNotAvailable(String message) {
       super(message);
    }

	@Override
	public ErrorClassification getErrorType() {
		return null;
	}

	@Override
	public List<SourceLocation> getLocations() {
		return null;
	}
	
	 @Override
	 public String getMessage() {
	     return super.getMessage();
	 }
	 
	 @Override
	 public Map<String, Object> getExtensions() {
	     return Collections.singletonMap("invalidField", invalidField);
	 }
}