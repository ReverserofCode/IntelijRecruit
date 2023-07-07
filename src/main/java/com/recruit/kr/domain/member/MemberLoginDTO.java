package com.recruit.kr.domain.member;


import lombok.Data;

@Data
public class MemberLoginDTO {
    private String  memberId;
    private String  memberPw;

    public MemberLoginDTO(String memberId, String memberPw){
        this.memberId = memberId;
        this.memberPw = memberPw;
    }
}
