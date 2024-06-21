package org.choongang.file.controllers;

import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import org.choongang.global.exceptions.CommonException;

import java.io.*;
import java.nio.file.Files;

@WebServlet("/file/download")
public class FileDownloadController extends HttpServlet {
    @Override
    public void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        File file = new File("D:/uploads/gradle.jpg");
        String contentType = Files.probeContentType(file.toPath());
        //윈도우즈에서 한글 깨짐 문제 발생, 인코딩 UTF-8->CPC949,EUC-KR, ISO8859_1
        String fileName = new String(file.getName().getBytes(), "ISO8859_1");

        //브라우저에게 알려주는 파일 정보
        resp.setHeader("Content-Disposition", "attachment; filename=" + fileName);
        //응답 헤더: Content-Disposition
        resp.setContentType(contentType);
        resp.setHeader("Cache-Control", "must-revalidate");
        resp.setIntHeader("Expires", 0); //만료기간 없애기
        resp.setContentLengthLong(file.length());

        try {
            BufferedInputStream bis = new BufferedInputStream(new FileInputStream(file));
            OutputStream out = resp.getOutputStream(); //바디 데이터가 헤더에 실림
            out.write(bis.readAllBytes());
        /*
        PrintWriter out = resp.getWriter();
        out.println("ABC");
        out.println("DEF"); //화면 출력을 파일로 출력하도록 바꿔주기
        */
        } catch (CommonException e) {
            e.printStackTrace();
        }
    }
}