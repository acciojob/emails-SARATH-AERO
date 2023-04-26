package com.driver;

import java.util.ArrayList;
import java.util.Objects;

public class Email {

    private String emailId;
    private String password;

    public Email(String emailId){
        this.emailId = emailId;
        this.password = "Accio@123";
    }

    public String getEmailId() {
        return emailId;
    }

    public String getPassword() {
        return password;
    }

    public void changePassword(String oldPassword, String newPassword){
        //Change password only if the oldPassword is equal to current password and the new password meets all of the following:
        // 1. It contains at least 8 characters
        // 2. It contains at least one uppercase letter
        // 3. It contains at least one lowercase letter
        // 4. It contains at least one digit
        // 5. It contains at least one special character. Any character apart from alphabets and digits is a special character
        if (oldPassword.equals(newPassword)) {
            if (check(newPassword)) {
                password = newPassword;
            }
        }
    }

    public boolean check(String password) {
        if(password.length() < 8 )
            return false;

        ArrayList<Character> list = new ArrayList<>();
        for(int i=0; i<password.length(); i++)
            list.add(password.charAt(i));

        boolean lower = false;
        boolean upper = false;
        boolean digit = false;
        boolean special = false;
        String specialChar = "!@#$%^&*()-<>?:|+";
        char prev = '.';

        for(Character c : list){
            if(c == prev)
                return false;
            prev = c;
            if(c >= 'a' && c <= 'z')
                lower = true;
            else if(c >= 'A' && c <= 'Z')
                upper = true;
            else if(c >= '0' && c <= '9')
                digit = true;
            else if(specialChar.indexOf(c) != -1)
                special = true;
        }
        return lower && upper && digit && special;
    }
}
