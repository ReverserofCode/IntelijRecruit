package com.recruit.kr.domain;

import lombok.*;

//Entity를 관리하는 DTO클래스

@Data
@RequiredArgsConstructor
public class RecruitDTO {

    private int memberAge;
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
