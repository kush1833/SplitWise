package main.kushagra;

import main.kushagra.service.SplitWiseService;

public class SplitwiseMain {
    public static void main(String[] args) {
        try {
            new SplitWiseService().start();
        }
        catch (Exception e){
            System.out.println("Error : " + e.getMessage());
        }
    }
}
