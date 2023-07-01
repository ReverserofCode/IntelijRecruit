package com.recruit.kr.controller;

import com.recruit.kr.domain.member.Member;
import com.recruit.kr.domain.member.MemberDTO;
import com.recruit.kr.domain.member.Member_JPAREPO;
import com.recruit.kr.service.MemberService;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
@RequiredArgsConstructor
public class MemberController {

    private final Member_JPAREPO memberJparepo;
    private final MemberService memberService;

    //데이터베이스 전체 출력  API 호출
    @GetMapping("/api/member")
    public List<Member> getMember() {
        return memberJparepo.findAll();
    }

    //데이터 베이스 등록 API
    @PostMapping("/api/member")
    public Member postMember(@RequestBody MemberDTO memberDTO) {
        Member member = new Member(memberDTO);
        memberJparepo.save(member);

        return member;
    }

    //지정 ID 찾기 API 호출
    @PutMapping("/api/member/{memberId}")
    public Member putMember(@PathVariable String memberId) {
        Optional<Member> optionalMember = memberJparepo.findById(memberId);
        Member member = new Member();

        if (optionalMember.isPresent()) {
            member = optionalMember.get();
        }
        return member;
    }

    //삭제 API 호출
    @DeleteMapping("/api/member/{memberId}")
    public void deleteMember(@PathVariable String memberId) {
        memberJparepo.deleteById(memberId);
    }

    //수정 API호출
    @PatchMapping("/api/member/{memberId}")
    public void updateMember(@PathVariable String memberId, @RequestBody MemberDTO memberDTO) {
        Optional<Member> optionalMember = memberJparepo.findById(memberId);

        if(optionalMember.isPresent()) {
            memberService.updateMember(memberId, memberDTO);
        }

    }
}
