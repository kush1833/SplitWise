package main.kushagra.strategy;

import main.kushagra.exception.InvalidInputException;
import main.kushagra.exception.InvalidOptionException;
import main.kushagra.factory.ExpenseFactory;
import main.kushagra.model.Ledger;
import main.kushagra.service.DisplayService;

import java.util.*;

public class BasicEvaluationStrategy implements EvaluationStrategy{
    private ExpenseStrategy expenseStrategy;
    private ExpenseFactory expenseFactory;
    private StringTokenizer stringTokenizer;
    private DisplayService displayService;
    private ValidationStrategy validationStrategy;
    @Override
    public void evaluate(Ledger ledger, List<String> inputs) {
        expenseFactory = new ExpenseFactory();
        displayService = new DisplayService();
        try {
            for (String input : inputs) {
                stringTokenizer = new StringTokenizer(input, " ");
                String command = stringTokenizer.nextToken().toUpperCase();
                if (command.equals("EXPENSE")) {
                    if (input.toUpperCase().contains("EQUAL")) {
                        expenseStrategy = expenseFactory.getExpenseInstance("EQUAL");
                        validationStrategy = new EqualValidationStrategy();
                    } else if (input.toUpperCase().contains("EXACT")) {
                        expenseStrategy = expenseFactory.getExpenseInstance("EXACT");
                        validationStrategy = new ExactValidationStrategy();
                    } else if (input.toUpperCase().contains("PERCENT")) {
                        expenseStrategy = expenseFactory.getExpenseInstance("PERCENT");
                        validationStrategy = new PercentValidationStrategy();
                    }

                    boolean t = validationStrategy.validate(input);
                    expenseStrategy.evaluate(ledger, input);
                } else if (command.equals("SHOW")) {
                    if (stringTokenizer.hasMoreTokens()) {
                        int userId = Integer.parseInt(stringTokenizer.nextToken());
                        displayService.displayUserBalance(ledger, userId);
                    } else {
                        displayService.displayAllBalance(ledger);
                    }
                }
            }
        }
        catch (InvalidOptionException e){
            System.out.println(e.getMessage());
        }
        catch (InvalidInputException e){
            System.out.println(e.getMessage());
        }
        catch (Exception e){
            System.out.println(e.getMessage());
        }
    }
}
