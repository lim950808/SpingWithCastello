package com.fastcampus.ch2;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.io.PrintWriter;

@Controller
public class TwoDice {
    @RequestMapping("/rollDice")
    //    public static void main(String[] args) {
    public void main(HttpServletResponse response) throws IOException {
        int idx1 = (int)(Math.random()*6)+1; //브라우저 새로고침 할 때 마다 랜덤 주사위 사진이 보여짐.
        int idx2 = (int)(Math.random()*6)+1;

        response.setContentType("text/html");
        response.setCharacterEncoding("utf-8");
        PrintWriter out = response.getWriter();
        out.println("<html>");
        out.println("<head>");
        out.println("</head>");
        out.println("<body>");
        out.println("<img src='resources/img/dice"+idx1+".jpg'>");
        out.println("<img src='resources/img/dice"+idx2+".jpg'>");
        out.println("</body>");
        out.println("</html>");
        out.close();
    }
}

//리소스: 동적리소스(스트리밍), 정적리소스(이미지)
//클라이언트: 서비스를 요청하는 애플리케이션
//서버: 서비스를 제공하는 애플리케이션
//Toggle Breakpoint를 찍어서 디버그 중간점을 설정함.
//Thread pool
//Dispatcher Servlet