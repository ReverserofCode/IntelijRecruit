package com.recruit.kr.service;


import com.recruit.kr.domain.recruit.Recruit;
import com.recruit.kr.domain.recruit.RecruitDTO;
import com.recruit.kr.domain.recruit.Recruit_JPAREPO;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Service
@RequiredArgsConstructor
public class RecruitService {

    private final Recruit_JPAREPO recruitJparepo;
    @Transactional
    public void updateRecruit(String memberId, RecruitDTO recruitDTO) {

        Recruit recruit = recruitJparepo.findById(memberId).orElseThrow(
                () -> new IllegalArgumentException("해당 ID가 존재하지 않습니다.")
        );

        recruit.update(memberId,recruitDTO);
    }
}
