package main.kushagra.factory;

import main.kushagra.exception.InvalidOptionException;
import main.kushagra.strategy.EqualExpense;
import main.kushagra.strategy.ExactExpense;
import main.kushagra.strategy.ExpenseStrategy;
import main.kushagra.strategy.PercentExpense;

public class ExpenseFactory {
    private ExpenseStrategy expenseStrategy;
    public ExpenseStrategy getExpenseInstance(String option) throws InvalidOptionException {
        option = option.toUpperCase();
        switch (option){
            case "EQUAL":
                expenseStrategy = new EqualExpense();
                break;
            case "EXACT":
                expenseStrategy = new ExactExpense();
                break;
            case "PERCENT":
                expenseStrategy = new PercentExpense();
                break;
            default:
                throw new InvalidOptionException();
        }
        return expenseStrategy;
    }
}
