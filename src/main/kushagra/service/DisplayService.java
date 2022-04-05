package main.kushagra.service;

import main.kushagra.model.Ledger;
import main.kushagra.model.TransactionDetails;

import java.util.HashMap;
import java.util.List;

public class DisplayService {
    private HashMap<Integer, List<TransactionDetails>> allTransactionDetails;
    public void displayUserBalance(Ledger ledger, int userId){
        allTransactionDetails = ledger.getAllTransactionDetails();
        if(allTransactionDetails.containsKey(userId)){
            List<TransactionDetails> details = allTransactionDetails.get(userId);
            for(TransactionDetails detail: details){
                System.out.println(userId + " owes " + detail.getUserId() + " : "+ detail.getMoneyOwed());
            }
        }
        else{
            allTransactionDetails.forEach((k,v) -> {
                for(TransactionDetails detail: v){
                    if(detail.getUserId() == userId){
                        System.out.println(k + " owes " + detail.getUserId() + " : "+ detail.getMoneyOwed());
                    }
                }
            });
        }
    }
    public void displayAllBalance(Ledger ledger){
        allTransactionDetails = ledger.getAllTransactionDetails();
        allTransactionDetails.forEach((k,v) -> {
            for(TransactionDetails detail: v){
                System.out.println(k + " owes " + detail.getUserId() + " : "+ detail.getMoneyOwed());
            }
        });
    }
}
// <user-id-of-x> owes <user-id-of-y>: <amount>