package main.kushagra.model;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

public class Ledger {
    private final HashMap<Integer, User> userIdList;
    private final HashMap<Integer, List<TransactionDetails>> transactionDetails;

    public Ledger(int userId){
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
            this.transactionDetails.get(userId).add(detail);
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
}
