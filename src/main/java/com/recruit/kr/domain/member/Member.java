package com.recruit.kr.domain.member;


import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;
import org.springframework.data.jpa.domain.support.AuditingEntityListener;

import javax.persistence.*;
import java.util.Set;

@Entity //데이터 베이스 테이블
@Getter //게터 세팅
@Builder
@NoArgsConstructor
@EntityListeners(AuditingEntityListener.class) //변화 감지
public class Member {

    @Id //PK 설정
    @Column(name="memberid",unique = true) //컬럼 직접설정
    private String memberId;

    private String memberPw;

    private String memberName;

    private String memberGender;

    private String memberAge;

    private String memberPhoneNumber;

    private String memberEmail;

    private String memberTechStack;

    private String memberCourseIsu;

    private String memberWebUrl;

    @ElementCollection(fetch = FetchType.LAZY)
    private Set<MemberRole> roleSet;

    public void addMemberRole(MemberRole memberRole){
        roleSet.add(memberRole);
    }

    @Builder
    public Member(String memberId, String memberPw, String memberName, String memberGender, String memberAge,
                  String memberPhoneNumber, String memberEmail, String memberTechStack, String memberCourseIsu,
                  String memberWebUrl, Set<MemberRole> roleSet) {
        this.memberId = memberId;
        this.memberPw = memberPw;
        this.memberName = memberName;
        this.memberGender = memberGender;
        this.memberAge = memberAge;
        this.memberPhoneNumber = memberPhoneNumber;
        this.memberEmail = memberEmail;
        this.memberTechStack = memberTechStack;
        this.memberCourseIsu = memberCourseIsu;
        this.memberWebUrl = memberWebUrl;
        this.roleSet = roleSet;
    }

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
