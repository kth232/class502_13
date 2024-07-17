package org.choongang.file.controllers;

import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;

import java.io.File;
import java.io.IOException;

@Slf4j
@Controller
@RequestMapping("/file")
public class FileController {

    @Value("${file.upload.path}")
    private String uploadDir;
    
    @GetMapping("/upload")
    public String upload() {
    
        return "file/upload";
    }
    
    @ResponseBody //템플릿이 필요없는 경우 사용
    @PostMapping("/upload")
    public void uploadPs(@RequestPart("file") MultipartFile file) { //의존성 주입으로 파일 업로드 가능
        String name=file.getOriginalFilename();
        log.info("file name: {}", name);

        File uploadPath = new File(uploadDir + name);
        //경로를 고정하는 것보다 프로퍼티 설정에 입력한 값으로 대체하는 것이 추후 수정하기 좋다

        try {
            file.transferTo(uploadPath);
        } catch (IOException e) {

        }
    }
}
