package com.example.demo.exceptionHandle;


public class BusinessException extends RuntimeException {

	private int errorCode;

	public BusinessException(String exceptionMessage) {
		super(exceptionMessage);
	}

	public BusinessException(String exceptionMessage, int errorCode) {
		super(exceptionMessage);
		this.errorCode = errorCode;
	}


	public BusinessException(BusinessException be) {
		super();
	}

	public int getErrorCode() {
		return errorCode;
	}

}
