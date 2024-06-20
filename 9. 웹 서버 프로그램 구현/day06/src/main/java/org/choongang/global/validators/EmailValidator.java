package org.choongang.global.validators;

public interface EmailValidator {
     default boolean checkEmail(String email){
         //계정@domain.com|.co.kr..
         String pattern = "[^@]+@[^.]+\\.[a-z]+";

         return email.matches(pattern);
     }
}
