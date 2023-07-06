package com.recruit.kr.controller;


import lombok.extern.log4j.Log4j2;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

@Log4j2
@Controller
@RequestMapping("/")
public class LoginController {
    @GetMapping("/all")
    public void exAll() {
        log.info("exAll..........");
    }

    @GetMapping("/member")
    public void Member() {
        log.info("exMember..........");
    }

    @GetMapping("/admin")
    @PreAuthorize("hasRole('ADMIN')")
    public void exAdmin() {
        log.info("exAdmin..........");
    }


}
