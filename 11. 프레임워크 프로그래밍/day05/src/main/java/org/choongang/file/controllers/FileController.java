package org.choongang.file.controllers;

import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;

@Slf4j
@Controller
@RequestMapping("/file")
public class FileController {
    
    @GetMapping("/upload")
    public String upload() {
    
        return "file/upload";
    }
    
    @ResponseBody //템플릿이 필요없는 경우 사용
    @PostMapping("/upload")
    public void uploadPs(@RequestPart("file") MultipartFile file) { //의존성 주입으로 파일 업로드 가능
        String name=file.getOriginalFilename();
        log.info("file name: "+name);
    }
}
