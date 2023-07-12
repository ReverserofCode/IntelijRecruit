package com.recruit.kr.domain.board;


import lombok.Data;
import lombok.RequiredArgsConstructor;

import java.util.List;

@Data
@RequiredArgsConstructor
public class BoardDTO {
    private String boardTitle;
    private String boardContent;
    private String boardAuthor;
    private String boardWantedRole;
    private int boardReadCount;

}