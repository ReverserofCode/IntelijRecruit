package com.recruit.kr.service;

import com.recruit.kr.domain.member.Member;
import com.recruit.kr.domain.member.MemberAuthDTO;
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
    public UserDetails loadUserByUsername(String memberId) throws UsernameNotFoundException {
        log.info("----------------------------------UserDetailService----------------------------------------------");
        log.info("UserDetailService loadUserByUsername " + memberId);

        Optional<Member> result = memberJparepo.findById(memberId);

        if(!(result.isPresent())){
            throw new UsernameNotFoundException("Check Your ID");
        }

        Member member = result.get();

        log.info("---------------------------------------------------------------------------------------------------");
        log.info(member.toString());

        MemberAuthDTO memberAuth = new MemberAuthDTO(
                member.getMemberId(),
                member.getMemberPw(),
                member.getMemberName(),
                member.getMemberGender(),
                member.getMemberAge(),
                member.getMemberPhoneNumber(),
                member.getMemberEmail(),
                member.getMemberTechStack(),
                member.getMemberCourseIsu(),
                member.getMemberWebUrl(),
                member.getRoleSet().stream().map(role->new SimpleGrantedAuthority("ROLE_"+role.name())).collect(Collectors.toSet())
        );
        memberAuth.setMemberName(member.getMemberName());
        log.info(memberAuth.toString());
        return memberAuth;
    }
}
