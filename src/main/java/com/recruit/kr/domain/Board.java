package com.recruit.kr.domain;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import org.hibernate.annotations.Columns;
import org.springframework.data.jpa.domain.support.AuditingEntityListener;

import javax.persistence.*;

@Entity
@Getter
@NoArgsConstructor
@EntityListeners(AuditingEntityListener.class)
public class Board extends TimeStamp{
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)//자동증가
    private Long boardId;

    @Column(nullable = false)
    private String boardTitle;

    @Column(nullable = false)
    private String boardContent;

    @Column(nullable = false)
    private String boardAuthor;

    @Column(nullable = false)
    private int boardReadcount;

    //? 추가 예정?
    // 추가된다면 모집 조건 들어갈 항목
    @Column(nullable = false)
    private String boardWantedRole;


    //Entity로 값을 넘겨주는 DTO 설계

    public Board(BoardDTO boardDTO){

        this.boardTitle = boardDTO.getBoardTitle();
        this.boardContent = boardDTO.getBoardContent();
        this.boardAuthor = boardDTO.getBoardAuthor();
        this.boardReadcount = boardDTO.getBoardReadcount();

    }

    public void updateBoard(Long boardId, BoardDTO boardDTO){
        this.boardId = boardId;
        this.boardTitle = boardDTO.getBoardTitle();
        this.boardContent = boardDTO.getBoardContent();
        this.boardAuthor = boardDTO.getBoardAuthor();
        this.boardReadcount = boardDTO.getBoardReadcount();

    }
}
