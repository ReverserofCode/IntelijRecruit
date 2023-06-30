package com.recruit.kr.domain.member;


import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;

@EnableJpaRepositories
public interface Member_JPAREPO extends JpaRepository<Member, String> {
}
