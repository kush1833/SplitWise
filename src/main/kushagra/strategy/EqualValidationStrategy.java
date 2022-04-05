package main.kushagra.strategy;

import main.kushagra.exception.InvalidInputException;

public class EqualValidationStrategy implements ValidationStrategy{

    @Override
    public boolean validate(String paymentInfo) throws InvalidInputException {
        return true;
    }
}
