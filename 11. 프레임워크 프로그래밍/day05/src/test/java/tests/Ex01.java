package tests;

import com.fasterxml.jackson.core.type.TypeReference;
import com.fasterxml.jackson.databind.ObjectMapper;
import org.choongang.config.MvcConfig;
import org.choongang.exam.PostData;
import org.choongang.member.controllers.RequestJoin;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.*;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit.jupiter.web.SpringJUnitWebConfig;
import org.springframework.util.LinkedMultiValueMap;
import org.springframework.util.MultiValueMap;
import org.springframework.web.client.RestTemplate;
import org.springframework.web.util.UriComponentsBuilder;

import java.net.URI;
import java.util.List;

@SpringJUnitWebConfig
@ContextConfiguration(classes = MvcConfig.class)
public class Ex01 {
    //환경변수 설정할 것!

    @Autowired
    private ObjectMapper om;

    @Test
    void test01() {
        URI url = UriComponentsBuilder.fromUriString("https://www.naver.com")
                .path("/news/{0}") //{} 사용하면 uri 변수/ 숫자, 문자 상관없음
                .queryParam("t1", "v1")
                .queryParam("t2", "v2")
                .queryParam("t3", "한글") //16진수로 출력됨 -> %ED%95%9C%EA%B8%80
                .queryParam("t4", "aa{1}")
                .fragment("hash") //해시코드
                .encode()
                .build("aaa", "bbb"); //순서대로 입력하면 변수 자리에 대체됨
                //.build(true) //->인코딩이 되어있는 상태라는 것, 한글 넣으면 에러 발생함

        System.out.println(url.getQuery());
        System.out.println(url);
    }

    @Test
    void test02() {
        RestTemplate restTemplate = new RestTemplate();
        String data = restTemplate.getForObject("https://jsonplaceholder.typicode.com/posts", String.class);

        System.out.println(data);
    }

    @Test
    void test03() throws Exception {
        RestTemplate restTemplate = new RestTemplate();
        String body = restTemplate.getForObject("https://jsonplaceholder.typicode.com/posts/1", String.class);

        //단일 객체 변환
        PostData data = om.readValue(body, PostData.class);
        System.out.println(data);
        
        //복합 데이터 객체 변환-List, Set, Map..
        String itemsBody = restTemplate.getForObject("https://jsonplaceholder.typicode.com/posts", String.class);
        //목록형으로 데이터 출력

        //typeReference형으로 리스트 값 조회
        List<PostData> items = om.readValue(itemsBody, new TypeReference<>() {}); //추상 클래스이기 때문에 {} 넣어줌

        items.forEach(System.out::println);
    }

    @Test
    @DisplayName("JSON 형식으로 POST 방식 처리")
    void test04() throws Exception{
        RestTemplate restTemplate = new RestTemplate();

        RequestJoin form = new RequestJoin(); //요청 데이터로 보낼 커맨드 객체 생성
        form.setEmail("user98@test.org");
        form.setPassword("12345678");
        form.setConfirmPassword(form.getPassword());
        form.setUserName("user98");
        form.setAgree(true);

        String params = om.writeValueAsString(form);

        HttpHeaders headers = new HttpHeaders();
        headers.setContentType(MediaType.APPLICATION_JSON); //_VALUE가 붙으면 String, 없으면 MediaType

        HttpEntity<String> request = new HttpEntity<>(params, headers);

        String url = "http://localhost:3000/day05/api/member";
        ResponseEntity<String> response = restTemplate.postForEntity(url, request, String.class);
        //원래는 원격 서버에 주로 하지만 예제는 로컬 서버로 확인
        System.out.println(response);
    }

    @Test
    @DisplayName("일반 양식으로 전송-content-type: application/x-www-form-urlencoded")
    void test05() {
        RestTemplate restTemplate = new RestTemplate();

        MultiValueMap<String, String> params = new LinkedMultiValueMap<>();
        params.add("email", "user97@test.org");
        params.add("password", "12345678");
        params.add("confirmPassword", "12345678");
        params.add("userName", "user97");
        params.add("agree", "true");

        HttpHeaders headers = new HttpHeaders();
        headers.setContentType(MediaType.APPLICATION_FORM_URLENCODED);

        HttpEntity<MultiValueMap<String, String>> request = new HttpEntity<>(params, headers);

        String url = "http://localhost:3000/day05/api/member/join";
        //스트링에 미리 정의된 multivalueMap->알아서 변환됨

        ResponseEntity<String> response = restTemplate.postForEntity(url, request, String.class);
        System.out.println(response);
    }
}
