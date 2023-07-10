package com.recruit.kr.controller;

import lombok.extern.log4j.Log4j2;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;

@Log4j2
@Controller
public class SecurityController {
    @GetMapping("/login")
    public void getLoginPage() {
        log.info("call by Login page");
    }

    @GetMapping("/member")
    public void getMember() {
        log.info("Request pass to member");
    }

    @GetMapping("/admin")
    public void getAdmin() {
        log.info("Request pass to Admin");
    }

    @GetMapping("/ProjectMain")
    public void getProjectMain() {
        log.info("Request Project Main");
    }
}