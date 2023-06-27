package com.recruit.kr.domain;


import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.config.EnableJpaAuditing;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;

import java.util.List;
import java.util.Optional;

@EnableJpaRepositories
@EnableJpaAuditing
public interface Board_JPAREPO extends JpaRepository<Board,Long> {

    List<Board> findAllByOrderByBoardIdDesc();

    List<Board> findBoardByBoardTitleContainingOrderByBoardIdDesc(String title);
    Optional<Board> findByBoardTitle(String boardTitle);


}
