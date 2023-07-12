package com.recruit.kr.config;

import org.springframework.security.access.AccessDeniedException;
import org.springframework.security.web.access.AccessDeniedHandler;
import org.springframework.stereotype.Component;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;


@Component
public class CustomDeniedHandler implements AccessDeniedHandler {

    @Override
    public void handle(HttpServletRequest request, HttpServletResponse response,
                       AccessDeniedException accessDeniedException) throws IOException, ServletException {

        String alertMessage = "권한이 부족합니다.\n 로그인 후 이용하세요";
        String redirectUrl = "/login";
        String script = "<script>alert('" + alertMessage + "'); window.location='" + redirectUrl + "';</script>";
        response.getWriter().write(script);
    }
}
