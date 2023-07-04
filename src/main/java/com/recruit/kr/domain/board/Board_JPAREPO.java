package com.recruit.kr.domain.board;


import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.config.EnableJpaAuditing;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;

import java.util.List;

@EnableJpaRepositories
@EnableJpaAuditing
public interface Board_JPAREPO extends JpaRepository<Board,Long> {

    //모든 모집 역할에 대해서 받아올 수 있게 하는 것
    List<Board> findAllByOrderByBoardIdDesc();

    //특정한 모집 역할에 대해 받아오는 리스트
    List<Board> findAllByBoardWantedRoleContainingOrderByBoardIdDesc(String boardWantedRole);

    // 검색시 사용하는 리스트
    List<Board> findAllByBoardWantedRoleContainingAndBoardTitleContainingOrderByBoardIdDesc(String boardWantedRole, String title);

    List<Board> findBoardsByBoardTitleContainingOrderByBoardIdDesc(String title);
    //수정할때 사용하는 Optional
   // Optional<Board> findByBoardTitle(String boardTitle);


}
