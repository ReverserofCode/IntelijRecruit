package com.recruit.kr.domain.board;


import lombok.Data;
import lombok.RequiredArgsConstructor;

@Data
@RequiredArgsConstructor
public class BoardDTO {
    private Long boardId;
    private String boardTitle;
    private String boardContent;
    private String boardAuthor;
    private int boardReadcount;



}
