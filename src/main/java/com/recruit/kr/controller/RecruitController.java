package com.recruit.kr.controller;

import com.recruit.kr.domain.member.Recruit;
import com.recruit.kr.domain.member.RecruitDTO;
import com.recruit.kr.domain.member.Recruit_JPAREPO;
import com.recruit.kr.service.RecruitService;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
@RequiredArgsConstructor
public class RecruitController {

    private final Recruit_JPAREPO recruitJparepo;
    private final RecruitService recruitService;
    RecruitDTO recruitDTO;

    //데이터베이스 전체 출력  API 호출
    @GetMapping("/api/recruit")
    public List<Recruit> getRecruit() {
        return recruitJparepo.findAll();
    }

    //데이터 베이스 등록 API
    @PostMapping("/api/recruit")
    public Recruit postRecruit(@RequestBody RecruitDTO recruitDTO) {
        Recruit recruit = new Recruit(recruitDTO);
        recruitJparepo.save(recruit);

        return recruit;
    }

    //지정 ID 찾기 API 호출
    @PutMapping("/api/recruit/{memberId}")
    public Recruit putRecruit(@PathVariable String memberId, RecruitDTO recruitDTO) {
        Optional<Recruit> optionalRecruit = recruitJparepo.findById(memberId);
        Recruit recruit = new Recruit();

        if (optionalRecruit.isPresent()) {
            recruit = optionalRecruit.get();
        }
        return recruit;
    }

    //삭제 API 호출
    @DeleteMapping("/api/recruit/{memberId}")
    public void deleteRecruit(@PathVariable String memberId, RecruitDTO recruitDTO) {
        recruitJparepo.deleteById(memberId);
    }

    //수정 API호출
    @PatchMapping("/api/recruit/{memberId}")
    public void updateRrecruit(@PathVariable String memberId, @RequestBody RecruitDTO recruitDTO) {
        Optional<Recruit> optionalRecruit = recruitJparepo.findById(memberId);

        if(optionalRecruit.isPresent()) {
            recruitService.updateRecruit(memberId, recruitDTO);
        }

    }
}
