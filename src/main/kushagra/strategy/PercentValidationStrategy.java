package main.kushagra.strategy;

import main.kushagra.constant.AppConstants;
import main.kushagra.exception.InvalidInputException;

import java.util.StringTokenizer;

public class PercentValidationStrategy implements ValidationStrategy{
    private StringTokenizer stringTokenizer;
    @Override
    public boolean validate(String paymentInfo) throws InvalidInputException {
        stringTokenizer = new StringTokenizer(paymentInfo, " ");
        stringTokenizer.nextToken();stringTokenizer.nextToken();
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
            throw new InvalidInputException(AppConstants.INVALID_PERCENT);
        }
        return true;
    }
}
// u4 1200 4 u1 u2 u3 u4 PERCENT 40 20 20 20