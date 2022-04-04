package main.kushagra.strategy;

import java.util.StringTokenizer;

public class ExactValidationStrategy implements ValidationStrategy{
    private StringTokenizer stringTokenizer;
    @Override
    public boolean validate(String paymentInfo) {
        stringTokenizer = new StringTokenizer(paymentInfo, " ");
        stringTokenizer.nextToken();
        double amountPaid = Double.parseDouble(stringTokenizer.nextToken());
        int totalUsers = Integer.parseInt(stringTokenizer.nextToken());
        for(int i=0;i<totalUsers;i++){
            stringTokenizer.nextToken();
        }
        stringTokenizer.nextToken();
        for (int i=0;i<totalUsers;i++){
            amountPaid = amountPaid - Double.parseDouble(stringTokenizer.nextToken());
        }
        if(stringTokenizer.hasMoreTokens() || amountPaid != 0){
            return false;
        }
        return true;
    }
}
// u1 1250 2 u2 u3 EXACT 370 880