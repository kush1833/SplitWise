package main.kushagra.model;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.stream.IntStream;

public class Ledger {
    private final HashMap<Integer, User> userIdList;
    private final HashMap<Integer, List<TransactionDetails>> transactionDetails;

    public Ledger(){
        this.userIdList = new HashMap<>();
        this.transactionDetails = new HashMap<>();
    }

    public void addUser(User user){
        this.userIdList.put(user.getUserId(), user);
    }
    public User getUser(int userId){
        return this.userIdList.get(userId);
    }
    public void addTransaction(int userId, TransactionDetails detail){
        if(this.transactionDetails.containsKey(userId)){
            List<TransactionDetails> detailsList = this.transactionDetails.get(userId);
            int index;
            if((index = containsUserId(detailsList, detail.getUserId()))!= -1){
                TransactionDetails details = detailsList.get(index);
                details.addToMoneyOwed(detail.getMoneyOwed());
            }
        }
        else{
            List<TransactionDetails> list = new ArrayList<>();
            list.add(detail);
            this.transactionDetails.put(userId, list);
        }
    }
    public HashMap<Integer,List<TransactionDetails>> getAllTransactionDetails(){
        return this.transactionDetails;
    }
    private int containsUserId(List<TransactionDetails> list, int userId){
        return IntStream.range(0, list.size())
                .filter(id -> list.get(id).getUserId()==userId)
                .findFirst()
                .orElse(-1);
    }
}
