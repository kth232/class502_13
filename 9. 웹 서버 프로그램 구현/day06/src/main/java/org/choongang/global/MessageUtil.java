package org.choongang.global;

import jakarta.servlet.http.HttpServletResponse;
import org.choongang.global.exceptions.CommonException;

import java.io.IOException;
import java.io.PrintWriter;

public class MessageUtil {
    public static void alertError(Exception e, HttpServletResponse resp) throws IOException {
        resp.setContentType("text/html; charset=UTF-8");
        /*
        if (e instanceof CommonException){
            CommonException commonException = (CommonException) e;
            resp.setStatus(commonException.getStatus());
        }
         */
        //어짜피 형변환 해야하기 때문에 짧게 쓸 수 있게 적용됨, 최근 버전에서 바뀐 듯..
        if (e instanceof CommonException commonException){
            resp.setStatus(commonException.getStatus());
        }
        PrintWriter out = resp.getWriter();
        out.printf("<script>alert('%s');</script>", e.getMessage());
        //history.back() 뒤로 가기, 히든 프레임이 있다면 없어도 됨(히든 프레임 때문에 같은 페이지에서 머무르고 있음)
    }

    public static void go(String url, String target, HttpServletResponse resp) throws IOException{
        target = target == null || target.isBlank() ? "self" : target;

        resp.setContentType("text/html; charset=UTF-8");
        PrintWriter out = resp.getWriter();
        //out.printf("<script>%s.location.href='%s';</script>", target, url);
        out.printf("<script>%s.location.replace('%s');</script>", target, url);
    } //부모창으로 이동할 수 있도록 통제, url을 주면 해당 주소로 이동/없으면 부모창으로 이동
    /*
    * location: href: 주소 이동 시 이동 기록이 남는다.
    * 뒤로 가기 버튼을 누른 경우 post 방식으로 중복 처리되어 넘어가기 때문에 데이터가 남아있음
    * POST 처리 시 기존 데이터를 남기지 않고 이동하려면 location.replace() 사용
    */

    public static void go(String url, HttpServletResponse resp) throws IOException {
        go(url, "self", resp);
    } //target은 null이나 공백을 넣어도 부모창으로 이동함
    // 많이 사용하는 메서드를 오버로드한 것
}
