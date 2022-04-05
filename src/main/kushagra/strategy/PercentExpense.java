package main.kushagra.strategy;

import main.kushagra.model.Ledger;
import main.kushagra.model.TransactionDetails;

import java.util.ArrayList;
import java.util.List;
import java.util.StringTokenizer;

public class PercentExpense implements ExpenseStrategy{
    private StringTokenizer stringTokenizer;
    @Override
    public void evaluate(Ledger ledger, String paymentInfo) {
        stringTokenizer = new StringTokenizer(paymentInfo," ");
        stringTokenizer.nextToken();
        int payerId = Integer.parseInt(stringTokenizer.nextToken());
        double amountPaid = Double.parseDouble(stringTokenizer.nextToken());
        int totalUsers = Integer.parseInt(stringTokenizer.nextToken());
        List<Integer> list = new ArrayList<>();
        for(int i=0;i<totalUsers;i++){
            list.add(Integer.parseInt(stringTokenizer.nextToken()));
        }
        stringTokenizer.nextToken();
        for(Integer userId: list){
            double percent = Double.parseDouble(stringTokenizer.nextToken());
            TransactionDetails details = new TransactionDetails(payerId, percent/100*amountPaid);
            ledger.addTransaction(userId, details);
        }
    }
}
// u4 1200 4 u1 u2 u3 u4 PERCENT 40 20 20 20