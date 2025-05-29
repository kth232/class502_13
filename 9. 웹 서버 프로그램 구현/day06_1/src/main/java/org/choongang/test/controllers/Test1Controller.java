package org.choongang.test.controllers;

import org.choongang.member.controllers.RequestJoin;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/test1")
public class Test1Controller {

    @GetMapping(path="/exam01", params="t1")
    public void exam01_1() {
        System.out.println("exam01_1 - t1");
    }

    @GetMapping(path="/exam01", params="t2")
    public void exam01_2() {
        System.out.println("exam01_2 - t2");
    }

    @GetMapping(path="/exam02", headers="h1")
    public void exam02_1() {
        System.out.println("exam02_1 - h1");
    }

    @GetMapping(path="/exam02", headers="h2")
    public void exam02_2() {
        System.out.println("exam02_2 - h2");
    }

    @PostMapping(path="/exam03", consumes = MediaType.APPLICATION_FORM_URLENCODED_VALUE)
    public void exam03_1() {
        System.out.println("exam03_1 - form-urlencoded");
    }

    @PostMapping(path="/exam03", consumes = MediaType.APPLICATION_JSON_VALUE)
    public void exam03_2() {
        System.out.println("exam03_2 - application/json");
    }

    // jackson-dataformat-xml 의존성 추가해야 함
    @GetMapping(path="/exam04", produces = MediaType.APPLICATION_JSON_VALUE)
    public RequestJoin exam04() {
        RequestJoin form = new RequestJoin();
        form.setEmail("user01@test.org");
        form.setName("user");
        form.setPassword("12345678");

        return form;
    }
}
