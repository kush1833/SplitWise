package main.kushagra.model;

public class User {
    private static int USER_ID = 0;
    private final int userId;
    private final String name;
    private final String email;
    private final String phoneNo;

    public User(String name, String email, String phoneNo){
        this.userId = USER_ID;
        this.email = email;
        this.phoneNo = phoneNo;
        this.name = name;
        USER_ID = USER_ID + 1;
    }

    public String getName(){
        return this.name;
    }
    public String getEmail(){
        return this.email;
    }
    public String getPhoneNo(){
        return this.phoneNo;
    }
    public int getUserId(){
        return this.userId;
    }
}
