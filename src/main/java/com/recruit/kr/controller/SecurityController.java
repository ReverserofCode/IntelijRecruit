package com.recruit.kr.controller;

import com.recruit.kr.domain.member.MemberAuthDTO;
import lombok.extern.log4j.Log4j2;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;

@Log4j2
@Controller
public class SecurityController {
    @GetMapping("/login")
    public void getLoginPage(){
        log.info("call by Login page");
    }
    @GetMapping("/member")
    public void getMember(){
        log.info("Request pass to member");
    }
    @GetMapping("/admin")
    public void getAdmin(){
        log.info("Request pass to Admin");
    }
}