package org.choongang;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication //설정 초기화, @Configuration 포함됨?
public class Day01Application {
	//main 메서드 실행하면 실행됨, springApplication.run
	//최대한 자동화할 수 있는 것들은 모두 자동화
	//기본 서버 포트는 8080
	//contex-path = '/'
	public static void main(String[] args) {
		SpringApplication.run(Day01Application.class, args);
	}

}
