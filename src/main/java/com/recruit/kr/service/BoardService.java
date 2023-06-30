package com.recruit.kr.service;

import com.recruit.kr.domain.board.Board;
import com.recruit.kr.domain.board.BoardDTO;
import com.recruit.kr.domain.board.Board_JPAREPO;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import javax.transaction.Transactional;

@Service
@RequiredArgsConstructor
public class BoardService {
    private final Board_JPAREPO boardJparepo;
    @Transactional
    public void updateBoard(Long boardId, BoardDTO boardDTO){
        Board board = boardJparepo.findById(boardId).orElseThrow(
                ()-> new IllegalArgumentException("해당 ID가 존재하지 않습니다.")
        );

        board.updateBoard(boardDTO);
    }
}
