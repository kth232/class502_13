package org.choongang.global;

import jakarta.servlet.http.HttpServletRequest;
import lombok.RequiredArgsConstructor;
import org.springframework.context.MessageSource;
import org.springframework.context.support.ResourceBundleMessageSource;
import org.springframework.stereotype.Component;
import org.springframework.validation.Errors;
import org.springframework.validation.FieldError;

import java.util.Arrays;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

@Component
@RequiredArgsConstructor
public class Utils {
    
    private final MessageSource messageSource;
    private final HttpServletRequest request; //locale 정보 가져오기 위함
    
    public Map<String, List<String>> getErrorMessages(Errors errors) {
        //FieldErrors

        Map<String, List<String>> messages = errors.getFieldErrors() //error 코드 정보를 string으로 가져와서 map형태로 만듦
                .stream() //스트림 잘 활용하면 코드 길이 축소
                .collect(Collectors.toMap(FieldError::getField, e -> getCodeMessages(e.getCodes()))); //메서드 참조
                //키에는 필드명, 값에는 메세지 코드
        //getCodes()가 가져오는 코드= resource#application.properties에 작성한 코드들

        //GlobalErrors
        List<String> gMessages = errors.getGlobalErrors()
                .stream()
                .flatMap(e->getCodeMessages(e.getCodes()).stream()).toList();
        //1차원적인 플랫맵 형태
        
        if(!gMessages.isEmpty()) { //global메세지가 항상 있는 것은 아님
            messages.put("global", gMessages); //gMessage가 있을 때만
        }
        return messages;
    }

    //반복되는 코드는 함수로 분리
    public List<String> getCodeMessages(String[] codes) { //코드 배열을 메세지로 일괄적으로 바꿔줌

        ResourceBundleMessageSource ms = (ResourceBundleMessageSource) messageSource;
        ms.setUseCodeAsDefaultMessage(false); //코드 그 자체로 메세지 대체->예외 발생
        
        List<String> messages = Arrays.stream(codes)
                .map(c-> {
                        try {
                            //code, 치환되는 부분은 필요없기 때문에 null, 지역화를 위해 브라우저 locale 정보 가져옴(언어설정이 영어이면 영어로)
                            return ms.getMessage(c, null, request.getLocale());
                        } catch (Exception e) {
                            return ""; //비어있는 메세지는 안나옴
                        }
                    })
                .filter(s -> s != null && !s.isBlank()) //null이 아니고 blank가 아닐 때
                .toList(); //리스트 형태로 만듦
        
        ms.setUseCodeAsDefaultMessage(true); //싱글톤으로 관리하기 때문에 사용하면 다시 원래 상태로 돌려줌
        return messages;
    }
}
