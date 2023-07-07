package com.recruit.kr.controller;

import lombok.extern.log4j.Log4j2;
import com.recruit.kr.domain.member.MemberLoginDTO;
import org.springframework.web.bind.annotation.*;

@Log4j2
@RestController
@RequestMapping("/login")
public class LoginController {
    @PostMapping("/requestLogin")
    public void loginCheck(@RequestBody MemberLoginDTO memberLoginDTO) {
        log.info("---------------------------------------Login Controller--------------------------------------");
        log.info(memberLoginDTO);
    }
}