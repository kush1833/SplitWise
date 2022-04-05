package main.kushagra.strategy;

import main.kushagra.model.Ledger;
import main.kushagra.model.TransactionDetails;

import java.util.ArrayList;
import java.util.List;
import java.util.StringTokenizer;

public class ExactExpense implements ExpenseStrategy{
    private StringTokenizer stringTokenizer;
    @Override
    public void evaluate(Ledger ledger, String paymentInfo) {
        stringTokenizer = new StringTokenizer(paymentInfo," ");
        stringTokenizer.nextToken();
        int payerId = Integer.parseInt(stringTokenizer.nextToken());
        double amountPaid = Double.parseDouble(stringTokenizer.nextToken());
        int totalUsers = Integer.parseInt(stringTokenizer.nextToken());
        List<Integer> users = new ArrayList<>();
        for(int i=0;i<totalUsers;i++){
            users.add(Integer.parseInt(stringTokenizer.nextToken()));
        }
        stringTokenizer.nextToken();
        for(Integer userId: users){
            if(userId == payerId)
                continue;
            TransactionDetails details = new TransactionDetails(payerId, Integer.parseInt(stringTokenizer.nextToken()));
            ledger.addTransaction(userId, details);
        }
    }
}
// u1 1250 2 u2 u3 EXACT 370 880