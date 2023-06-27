package com.recruit.kr.domain;


import lombok.Getter;
import lombok.NoArgsConstructor;
import org.springframework.data.jpa.domain.support.AuditingEntityListener;

import javax.persistence.*;
import java.util.List;

@Entity //데이터 베이스 테이블
@Getter //게터 세팅
@NoArgsConstructor //기본 생성자 자동 생성
@EntityListeners(AuditingEntityListener.class) //변화 감지
public class Recruit {

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
    private int memberAge;

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

    @Column
    @ElementCollection
    private List<String> ages;

    //엔티티로 값을 넘겨주는 DTO 설계
    public Recruit(RecruitDTO recruitDTO) {
        this.memberId = recruitDTO.getMemberId();
        this.memberPw = recruitDTO.getMemberPw();
        this.memberName = recruitDTO.getMemberName();
        this.memberGender = recruitDTO.getMemberGender();
        this.memberAge = recruitDTO.getMemberAge();
        this.memberPhoneNumber = recruitDTO.getMemberPhoneNumber();
        this.memberEmail = recruitDTO.getMemberEmail();
        this.memberTechStack = recruitDTO.getMemberTechStack();
        this.memberCourseIsu = recruitDTO.getMemberCourseIsu();
        this.memberWebUrl = recruitDTO.getMemberWebUrl();
    }

    public void update (String memberId, RecruitDTO recruitDTO){
        this.memberId = memberId;
        this.memberPw = recruitDTO.getMemberPw();
        this.memberName = recruitDTO.getMemberName();
        this.memberGender = recruitDTO.getMemberGender();
        this.memberAge = recruitDTO.getMemberAge();
        this.memberPhoneNumber = recruitDTO.getMemberPhoneNumber();
        this.memberEmail = recruitDTO.getMemberEmail();
        this.memberTechStack = recruitDTO.getMemberTechStack();
        this.memberCourseIsu = recruitDTO.getMemberCourseIsu();
        this.memberWebUrl = recruitDTO.getMemberWebUrl();
    }
}
