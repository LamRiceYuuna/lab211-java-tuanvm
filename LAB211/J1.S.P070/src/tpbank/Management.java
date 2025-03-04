/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package tpbank;

import java.util.Locale;
import java.util.Random;
import java.util.ResourceBundle;

/**
 *
 * @author win
 */
public class Management {

    // randomCaptcha
    private String randomCaptcha() {
        Random rand = new Random();
        // string anphabet
        StringBuilder anphabet = new StringBuilder();
        // check 
        boolean isLowerExisted = false;
        boolean isUpperExisted = false;
        boolean isDigitExisted = false;

        for (char i = 'a'; i <= 'z'; i++) {
            anphabet.append(i);// connect string from a->z to anphabet
        }
        for (char i = 'A'; i <= 'Z'; i++) {
            anphabet.append(i); // connect string from A->Z to anphabet
        }
        for (char i = '0'; i <= '9'; i++) {
            anphabet.append(i);// connect string from 0->9 to anphabet
        }
        
        //random 5 characters in alphabet
        StringBuilder captCha;
        
        do {
            captCha = new StringBuilder();
            // repeat 5 times to get 5 characters
            for (int i = 0; i < 5; i++) {
                // each loop is random 1 index in the alphabet 
                int index = rand.nextInt(anphabet.length());
                // at that index can determine the character
                char randomChar = anphabet.charAt(index);
                if (randomChar >= 'a' && randomChar <= 'z') {
                    isLowerExisted = true;
                } else if (randomChar >= 'A' && randomChar <= 'Z') {
                    isUpperExisted = true;
                } else {
                    isDigitExisted = true;
                }
                
                captCha.append(randomChar);
            }
        } while (!isLowerExisted || !isUpperExisted || !isDigitExisted);
        return captCha.toString();
    }

    // login
    public void login(Locale locale) {
        ResourceBundle bundle = ResourceBundle.getBundle("tpbank.language", locale);
        // get a string and set to accountNumber variable
        String accountNumber = GetInput.getString(bundle.getString("account"),
                bundle.getString("account.error"), "^\\d{10}$");
        // get a string and set to password variable
        String password = GetInput.getPassword(bundle.getString("password"),
                bundle.getString("password.error"));

        //random captcha 5 character include alphanumeric
        while (true) {
            String captcha = randomCaptcha();
            System.out.println("Captcha: " + captcha);
            //enter again capcha
            String reCaptcha = GetInput.getString(bundle.getString("captcha"),
                    bundle.getString("captcha.error"), "^[a-zA-Z0-9]{5}$");
            if (captcha.equals(reCaptcha)) {
                System.out.println(bundle.getString("login.success"));
                break;
            } else {
                System.out.println(bundle.getString("captcha.incorrect"));
            }
        }
    }

}
