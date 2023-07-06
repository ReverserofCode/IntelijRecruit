package com.recruit.kr.domain.member;


import lombok.Getter;
import lombok.Setter;
import lombok.ToString;
import lombok.extern.log4j.Log4j2;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.userdetails.User;

import java.util.Collection;

@Log4j2
@Getter
@Setter
@ToString
public class MemberAuthDTO extends User {

    private String memberId;
    private String memberPw;
    private String memberAge;
    private String memberName;
    private String memberGender;
    private String memberPhoneNumber;
    private String memberEmail;
    private String memberTechStack;
    private String memberCourseIsu;
    private String memberWebUrl;

    public MemberAuthDTO(String username, String password,
                         String memberAge, String memberEmail, String memberGender,
                         String memberPhoneNumber, String memberTechStack,
                         String memberCourseIsu, String memberWebUrl, String memberName,Collection<? extends GrantedAuthority> authorities) {

        super(username, password, authorities);
        this.memberId = username;
        this.memberPw = password;
        this.memberAge = memberAge;
        this.memberName = memberName;
        this.memberGender = memberGender;
        this.memberPhoneNumber = memberPhoneNumber;
        this.memberEmail = memberEmail;
        this.memberTechStack = memberTechStack;
        this.memberCourseIsu = memberCourseIsu;
        this.memberWebUrl = memberWebUrl;
    }

}
