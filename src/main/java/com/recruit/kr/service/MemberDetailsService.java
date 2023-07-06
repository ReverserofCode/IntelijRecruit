package com.recruit.kr.service;

import com.recruit.kr.domain.member.Member;
import com.recruit.kr.domain.member.MemberAuthDTO;
import com.recruit.kr.domain.member.MemberDTO;
import com.recruit.kr.domain.member.Member_JPAREPO;
import lombok.RequiredArgsConstructor;
import lombok.extern.log4j.Log4j2;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.Optional;
import java.util.stream.Collectors;

@Log4j2
@Service
@Transactional
@RequiredArgsConstructor
public class MemberDetailsService implements UserDetailsService {
    private final Member_JPAREPO memberJparepo;

    @Override
    public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
        log.info("ClubUserDetailsService loadUserByUsername " + username);
        Optional<Member> result = memberJparepo.findById(username);
        Member member = result.orElse(null);

        if (member == null) {
            throw new UsernameNotFoundException("Check User Email or from Social ");
        }
        member = result.get();
        log.info("-----------------------------");
        log.info(member);

        MemberAuthDTO memberAuthDTO = new MemberAuthDTO(
                member.getMemberId(),
                member.getMemberPw(),
                member.getMemberAge(),
                member.getMemberName(),
                member.getMemberGender(),
                member.getMemberPhoneNumber(),
                member.getMemberEmail(),
                member.getMemberTechStack(),
                member.getMemberCourseIsu(),
                member.getMemberWebUrl(),
                member.getRoleSet().stream()
                        .map(role -> new SimpleGrantedAuthority("ROLE_" + role.name()))
                        .collect(Collectors.toSet())
        );
        memberAuthDTO.setMemberName(member.getMemberName());
        return memberAuthDTO;
    }
}
