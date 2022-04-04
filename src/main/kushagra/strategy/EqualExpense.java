package main.kushagra.strategy;

import main.kushagra.model.Ledger;
import main.kushagra.model.TransactionDetails;

import java.util.StringTokenizer;

public class EqualExpense implements ExpenseStrategy{
    private StringTokenizer stringTokenizer;
    @Override
    public void evaluate(Ledger ledger, String paymentInfo) {
        stringTokenizer = new StringTokenizer(paymentInfo," ");
        int payerId = Integer.parseInt(stringTokenizer.nextToken());
        double amountPaid = Double.parseDouble(stringTokenizer.nextToken());
        int totalUsers = Integer.parseInt(stringTokenizer.nextToken());
        double owedAmount = amountPaid/totalUsers;
        for(int i=0;i<totalUsers-1;i++){
            int borrowerId = Integer.parseInt(stringTokenizer.nextToken());
            amountPaid = amountPaid - owedAmount;
            if(borrowerId == payerId)
                continue;
            TransactionDetails detail = new TransactionDetails(payerId, owedAmount);
            ledger.addTransaction(borrowerId, detail);
        }
        int borrowerId = Integer.parseInt(stringTokenizer.nextToken());
        TransactionDetails detail = new TransactionDetails(payerId, owedAmount);
        ledger.addTransaction(borrowerId, detail);
    }
}
// u1 1000 4 u1 u2 u3 u4 EQUAL