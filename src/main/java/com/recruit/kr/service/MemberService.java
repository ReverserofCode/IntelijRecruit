package com.recruit.kr.service;


import com.recruit.kr.domain.member.Member;
import com.recruit.kr.domain.member.MemberDTO;
import com.recruit.kr.domain.member.Member_JPAREPO;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Service
@RequiredArgsConstructor
public class MemberService {

    private final Member_JPAREPO memberJparepo;
    @Transactional
    public void updateMember(String memberId, MemberDTO memberDTO) {

        Member member = memberJparepo.findById(memberId).orElseThrow(
                () -> new IllegalArgumentException("해당 ID가 존재하지 않습니다.")
        );

        member.update(memberId, memberDTO);
    }
}
