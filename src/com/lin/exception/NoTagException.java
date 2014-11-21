package com.lin.exception;

import com.lin.exception.util.ExceptionMessage;

public class NoTagException extends Exception {
	public NoTagException(){
		super(ExceptionMessage.NO_THIS_TAG);
	}
}
