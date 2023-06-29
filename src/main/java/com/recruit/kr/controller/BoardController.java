package com.recruit.kr.controller;

import com.recruit.kr.domain.Board;
import com.recruit.kr.domain.BoardDTO;
import com.recruit.kr.domain.Board_JPAREPO;
import com.recruit.kr.service.BoardService;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.*;

import java.time.LocalDateTime;
import java.util.List;
import java.util.Optional;

@RestController
@RequiredArgsConstructor
public class BoardController {
    private final Board_JPAREPO boardJparepo;
    private final BoardService boardService;

    //전체 내용 호출
    @GetMapping("/api/board")
    public List<Board> getBoard(){
        return boardJparepo.findAllByOrderByBoardIdDesc();
    }

    //등록 API
    @PostMapping("/api/board")
    public Board postBoard(@RequestBody BoardDTO boardDTO){
        Board board = new Board(boardDTO);
        board.setBoardReadcount(0);
        // board.setBoardCreateDate(LocalDateTime.now());
        //  board.setBoardModifiedDate(LocalDateTime.now());
        boardJparepo.save(board);
        return board;
    }
    //id로 검색하기
    @PutMapping("/api/board/{boardid}")
    public Board putBoard(@PathVariable Long boardid, BoardDTO boardDTO){
        Optional<Board> optionalBoard = boardJparepo.findById(boardid);
        Board board = new Board();
        if(optionalBoard.isPresent()){
            board = optionalBoard.get();

        }
        return board;
    }

    //제목으로 검색하기 - 아직 미구현
    //Board_JPAREPO를 통해서 원하는 대로 수정하면 될듯
    @PutMapping("/api/board2/{boardTitle}")
    public Board putBoard2(@PathVariable String boardTtitle, BoardDTO boardDTO){
        Optional<Board> optionalBoard = boardJparepo.findByBoardTitle(boardTtitle);
        Board board = new Board();
        if(optionalBoard.isPresent()){
            board = optionalBoard.get();
        }

        return board;
    }
    //삭제 API
    @DeleteMapping("/api/board/{boardId}")
    public void deleteBoard(@PathVariable Long boardId, BoardDTO boardDTO){
        boardJparepo.deleteById(boardId);
    }

    //수정 API
    @PatchMapping("/api/board/{boardId}")
    public void updateBoard(@PathVariable Long boardId, @RequestBody BoardDTO boardDTO){
        Optional<Board> optionalBoard = boardJparepo.findById(boardId);
        Board board = new Board();
        if(optionalBoard.isPresent()){
            boardService.updateBoard(boardId,boardDTO);
        }

    }
}
