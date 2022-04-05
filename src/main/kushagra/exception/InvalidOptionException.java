package main.kushagra.exception;

import main.kushagra.constant.AppConstants;

public class InvalidOptionException extends Exception{
    public InvalidOptionException(){
        super(AppConstants.INVALID_OPTION);
    }
}
