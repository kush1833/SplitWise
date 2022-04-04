package main.kushagra.strategy;

import java.util.StringTokenizer;

public class PercentValidation implements ValidationStrategy{
    private StringTokenizer stringTokenizer;
    @Override
    public boolean validate(String paymentInfo) {
        stringTokenizer = new StringTokenizer(paymentInfo, " ");
        stringTokenizer.nextToken();
        stringTokenizer.nextToken();
        double percent = 0;
        int totalUsers = Integer.parseInt(stringTokenizer.nextToken());
        for(int i=0;i<totalUsers;i++){
            stringTokenizer.nextToken();
        }
        stringTokenizer.nextToken();
        for (int i=0;i<totalUsers;i++){
            percent = percent + Double.parseDouble(stringTokenizer.nextToken());
        }
        if(stringTokenizer.hasMoreTokens() || percent != 100){
            return false;
        }
        return true;
    }
}
// u4 1200 4 u1 u2 u3 u4 PERCENT 40 20 20 20