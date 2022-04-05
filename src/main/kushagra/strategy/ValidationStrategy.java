package main.kushagra.strategy;

import main.kushagra.exception.InvalidInputException;

public interface ValidationStrategy {
    boolean validate(String paymentInfo) throws InvalidInputException;
}
