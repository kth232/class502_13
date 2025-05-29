package org.choongang.member.controllers;

public record RequestJoin2 (
        String email,
        String password,
        String confirmPassword,
        String name,
        boolean termsAgree
) {
    // record 클래스
}
