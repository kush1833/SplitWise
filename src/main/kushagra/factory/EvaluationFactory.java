package main.kushagra.factory;

import main.kushagra.exception.InvalidOptionException;
import main.kushagra.strategy.BasicEvaluationStrategy;
import main.kushagra.strategy.EvaluationStrategy;

public class EvaluationFactory {
    private EvaluationStrategy evaluationStrategy;
    public EvaluationStrategy getEvaluationStrategy(String option) throws InvalidOptionException {
        switch (option){
            case "BASIC":
                evaluationStrategy = new BasicEvaluationStrategy();
                break;
            default:
                throw new InvalidOptionException();
        }
        return evaluationStrategy;
    }
}
