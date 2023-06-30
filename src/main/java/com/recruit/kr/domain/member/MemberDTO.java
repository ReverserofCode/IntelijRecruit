package com.recruit.kr.domain.member;

import lombok.*;

//Entity를 관리하는 DTO클래스

@Data
@RequiredArgsConstructor
public class MemberDTO {

    private String memberAge;
    private String memberId;
    private String memberPw;
    private String memberName;
    private String memberGender;
    private String memberPhoneNumber;
    private String memberEmail;
    private String memberTechStack;
    private String memberCourseIsu;
    private String memberWebUrl;

}
