package com.srm.hirehub.hirehub_portal.validation;

import com.srm.hirehub.hirehub_portal.service.ValidationMessage;

public class UserException extends RuntimeException {
	
	private ValidationMessage validationMessage;
	
	public UserException(String message) {
		super(message);
	}

	public ValidationMessage getValidationMessage() {
		return validationMessage;
	}

	public void setValidationMessage(ValidationMessage validationMessage) {
		this.validationMessage = validationMessage;
	}
	
	
	
	

}
