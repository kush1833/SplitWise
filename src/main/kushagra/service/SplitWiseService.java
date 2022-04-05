package main.kushagra.service;

import main.kushagra.exception.InvalidOptionException;
import main.kushagra.factory.EvaluationFactory;
import main.kushagra.model.Ledger;
import main.kushagra.model.User;
import main.kushagra.strategy.EvaluationStrategy;

import java.util.ArrayList;
import java.util.List;

public class SplitWiseService {
    private Ledger ledger;
    private EvaluationStrategy evaluationStrategy;
    private EvaluationFactory evaluationFactory;

    public void start() throws InvalidOptionException{
        ledger = new Ledger();
        evaluationFactory = new EvaluationFactory();
        User u1 = new User("A", "a@g.com", "9327835821");
        User u2 = new User("B", "b@g.com", "9327835822");
        User u3 = new User("C", "c@g.com", "9327835823");
        User u4 = new User("D", "d@g.com", "9327835824");
        ledger.addUser(u1);
        ledger.addUser(u2);
        ledger.addUser(u3);
        ledger.addUser(u4);

//        EXPENSE <user-id-of-person-who-paid> <amount-paid> <no-of-users> <space-separated-list-of-users>
//        <EQUAL/EXACT/PERCENT> <space-separated-values-in-case-of-non-equal>

        String input1 = String.format("EXPENSE %d 1000 4 %d %d %d %d EQUAL", u1.getUserId(), u1.getUserId(), u2.getUserId(), u3.getUserId(), u4.getUserId());
        String input2 = "SHOW";
        String input3 = String.format("EXPENSE %d 1250 2 %d %d EXACT 370 880", u1.getUserId(), u2.getUserId(), u3.getUserId());
        String input4 = String.format("EXPENSE %d 1200 4 %d %d %d %d PERCENT 40 20 20 20", u2.getUserId(), u1.getUserId(), u2.getUserId(), u3.getUserId(), u4.getUserId());
        String input5 = String.format("SHOW %d", u1.getUserId());
        String input6 = "SHOW";
        //String input7 = String.format("SHOW %d", u3.getUserId());

        List<String> inputs = new ArrayList<>();
        inputs.add(input1);
        inputs.add(input2);
        inputs.add(input3);
        inputs.add(input4);
        inputs.add(input5);
        inputs.add(input6);
        //inputs.add(input7);

        String option = "BASIC";
        evaluationStrategy = evaluationFactory.getEvaluationStrategy(option);
        evaluationStrategy.evaluate(ledger, inputs);
    }
}
