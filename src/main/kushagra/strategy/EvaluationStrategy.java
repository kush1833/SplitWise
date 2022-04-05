package main.kushagra.strategy;

import main.kushagra.model.Ledger;

import java.util.List;

public interface EvaluationStrategy {
    void evaluate(Ledger ledger, List<String> inputs);
}
