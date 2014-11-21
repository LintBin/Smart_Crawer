package com.lin.exception;

import com.lin.exception.util.ExceptionMessage;

public class TagPropertyExcption extends Exception{
	public TagPropertyExcption(){
		super(ExceptionMessage.TAG_PROPERTY_ERROR);
	}
}
