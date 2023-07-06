package com.recruit.kr.security;


import com.recruit.kr.domain.member.Member;
import com.recruit.kr.domain.member.MemberRole;
import com.recruit.kr.domain.member.Member_JPAREPO;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.security.crypto.password.PasswordEncoder;

import java.util.HashSet;
import java.util.Optional;
import java.util.stream.IntStream;

@SpringBootTest
public class MemberTests {

    @Autowired
    private Member_JPAREPO memberJparepo;

    @Autowired
    private PasswordEncoder passwordEncoder;

    @Test
    public void insertDummies() {

        //1 - 80까지는 USER만 지정
        //81- 90까지는 USER,MANAGER
        //91- 100까지는 USER,MANAGER,ADMIN

        IntStream.rangeClosed(1,100).forEach(i -> {
            Member member = Member.builder()
                    .memberId("user"+i+"@zerock.org")
                    .memberName("사용자"+i)
                    .roleSet(new HashSet<MemberRole>())
                    .memberPw(  passwordEncoder.encode("1111") )
                    .build();
            //default role
            member.addMemberRole(MemberRole.USER);
            if(i > 80){
                member.addMemberRole(MemberRole.MANAGER);
            }
            if(i > 90){
                member.addMemberRole(MemberRole.ADMIN);
            }
            memberJparepo.save(member);

        });

    }
}
