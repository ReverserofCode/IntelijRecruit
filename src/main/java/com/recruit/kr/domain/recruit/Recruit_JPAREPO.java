package com.recruit.kr.domain.recruit;


import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;

@EnableJpaRepositories
public interface Recruit_JPAREPO extends JpaRepository<Recruit, String> {
}
