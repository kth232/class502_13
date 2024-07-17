package org.choongang.config;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.servlet.config.annotation.ResourceHandlerRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurer;

@Configuration
public class FileConfig implements WebMvcConfigurer {
    
    @Value("${file.upload.path}") //프로퍼티 설정에 입력한 명칭으로 업로드 경로 설정값 주입
    private String uploadPath;

    @Override
    public void addResourceHandlers(ResourceHandlerRegistry registry) {
        //파일 업로드 정적 경로 설정

        registry.addResourceHandler("/uploads/**")
                .addResourceLocations("file:///" + uploadPath);
                // 앞의 '/'가 제거되기 때문에 ///로 입력해야 file://로 동작하게 됨
        //경로가 바뀔 수 있기 때문에 프로퍼티 설정 추가해서 변경 가능성 고려함->주소 대체
    }
}
