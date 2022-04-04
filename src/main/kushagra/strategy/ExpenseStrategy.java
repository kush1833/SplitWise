package main.kushagra.strategy;

import main.kushagra.model.Ledger;

public interface ExpenseStrategy {
    void evaluate(Ledger ledger, String paymentInfo);
}
