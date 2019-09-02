package com.jeejava.local.clazz;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class LocalClassExample {

    static String regularExpression = "^([a-zA-Z0-9])+([a-zA-Z0-9\\._-])*@([a-zA-Z0-9_-])+([a-zA-Z0-9\\._-]+)+$";

    public static void validateEmail(String email1, String email2) {

        class EmailAddress {

            Pattern pattern;
            Matcher matcher;

            EmailAddress(String email) {
                pattern = Pattern.compile(regularExpression);
                matcher = pattern.matcher(email);
            }

            public boolean validate() {
                return matcher.matches();
            }

        }

        EmailAddress emailAddress1 = new EmailAddress(email1);
        EmailAddress emailAddress2 = new EmailAddress(email2);

        if (emailAddress1.validate())
            System.out.println(email1 + " is valid.");
        else
            System.out.println(email1 + " is invalid.");

        if (emailAddress2.validate())
            System.out.println(email2 + " is valid.");
        else
            System.out.println(email2 + " is invalid.");

    }

    public static void main(String[] args) {
        validateEmail("soumitra", "soumitrajuster@email.com");
    }

}