package com.recruit.kr.domain.member;


import lombok.Getter;
import lombok.NoArgsConstructor;
import org.springframework.data.jpa.domain.support.AuditingEntityListener;

import javax.persistence.*;

@Entity //데이터 베이스 테이블
@Getter //게터 세팅
@NoArgsConstructor //기본 생성자 자동 생성
@EntityListeners(AuditingEntityListener.class) //변화 감지
public class Member {

    @Id //PK 설정
    @Column(name="memberid",unique = true) //컬럼 직접설정
    private String memberId;

    @Column(nullable = false)
    private String memberPw;

    @Column(nullable = false)
    private String memberName;

    @Column(nullable = false)
    private String memberGender;

    @Column(nullable = false)
    private String memberAge;

    @Column(nullable = false)
    private String memberPhoneNumber;

    @Column(nullable = false)
    private String memberEmail;

    @Column(nullable = false)
    private String memberTechStack;

    @Column(nullable = false)
    private String memberCourseIsu;

    @Column(nullable = false)
    private String memberWebUrl;

    //엔티티로 값을 넘겨주는 DTO 설계
    public Member(MemberDTO memberDTO) {
        this.memberId = memberDTO.getMemberId();
        this.memberPw = memberDTO.getMemberPw();
        this.memberName = memberDTO.getMemberName();
        this.memberGender = memberDTO.getMemberGender();
        this.memberAge = memberDTO.getMemberAge();
        this.memberPhoneNumber = memberDTO.getMemberPhoneNumber();
        this.memberEmail = memberDTO.getMemberEmail();
        this.memberTechStack = memberDTO.getMemberTechStack();
        this.memberCourseIsu = memberDTO.getMemberCourseIsu();
        this.memberWebUrl = memberDTO.getMemberWebUrl();
    }

    public void update (String memberId, MemberDTO memberDTO){
        this.memberId = memberId;
        this.memberPw = memberDTO.getMemberPw();
        this.memberName = memberDTO.getMemberName();
        this.memberGender = memberDTO.getMemberGender();
        this.memberAge = memberDTO.getMemberAge();
        this.memberPhoneNumber = memberDTO.getMemberPhoneNumber();
        this.memberEmail = memberDTO.getMemberEmail();
        this.memberTechStack = memberDTO.getMemberTechStack();
        this.memberCourseIsu = memberDTO.getMemberCourseIsu();
        this.memberWebUrl = memberDTO.getMemberWebUrl();
    }
}
