package org.choongang.global.validators;

public interface EmailValidator {
     default boolean checkEmail(String email){
         //계정@domain.com|.co.kr..
         //이메일 패턴 정의: ID부분은 @를 제외한 모든 문자/ 도메인 부분은 .을 제외한 모든 문자/ . 이후는 알파벳 소문자로 구성
         String pattern = "[^@]+@[^.]+\\.[a-z]+";

         return email.matches(pattern);
     }
}
