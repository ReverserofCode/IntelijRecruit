package com.recruit.kr.domain.member;

import lombok.*;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.userdetails.User;

import java.util.Collection;

//Entity를 관리하는 DTO클래스


@Data
@RequiredArgsConstructor
public class MemberDTO {

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

}
