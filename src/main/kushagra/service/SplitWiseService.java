package main.kushagra.service;

import main.kushagra.model.Ledger;
import main.kushagra.model.User;

import java.util.ArrayList;
import java.util.List;

public class SplitWiseService {
    private Ledger ledger;
    private DisplayService displayService;

    public void start() {
        ledger = new Ledger();
        displayService = new DisplayService();

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

        String input1 = String.format("EXPENSE %d %f 4 %d %d %d %d EQUAL", u1.getUserId(), 1000, u1.getUserId(), u2.getUserId(), u3.getUserId(), u4.getUserId());
        String input2 = "SHOW";
        String input3 = String.format("EXPENSE %d %f 2 %d %d EXACT %f %f", u1.getUserId(), 1250, u2.getUserId(), u3.getUserId(), 370, 880);
        String input4 = String.format("EXPENSE %d %f 4 %d %d %d %d PERCENT 40 20 20 20", u1.getUserId(), 1200, u1.getUserId(), u2.getUserId(), u3.getUserId(), u4.getUserId());
        String input5 = String.format("SHOW %d", u1.getUserId());
        String input6 = "SHOW";
        String input7 = String.format("SHOW %d", u3.getUserId());

        List<String> inputs = new ArrayList<>();
        inputs.add(input1);
        inputs.add(input2);
        inputs.add(input3);
        inputs.add(input4);
        inputs.add(input5);
        inputs.add(input6);
        inputs.add(input7);


    }
}
