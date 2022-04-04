package main.kushagra.model;

public class TransactionDetails{
    private final int userId;
    private final double moneyOwed;

    public TransactionDetails(int userId, double moneyOwed){
        this.userId = userId;
        this.moneyOwed = moneyOwed;
    }
    public int getUserId() {
        return userId;
    }

    public double getMoneyOwed() {
        return moneyOwed;
    }
}