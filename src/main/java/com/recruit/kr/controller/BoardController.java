package com.recruit.kr.controller;

import com.recruit.kr.domain.Board;
import com.recruit.kr.domain.BoardDTO;
import com.recruit.kr.domain.Board_JPAREPO;
import com.recruit.kr.service.BoardService;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
@RequiredArgsConstructor
public class BoardController {
    private final Board_JPAREPO boardJparepo;
    private final BoardService boardService;
     //아아아아아아아아아아앙주석이용
    @GetMapping("/api/board")
    public List<Board> getBoard(){
        return boardJparepo.findAllByOrderByBoardIdDesc();
    }
    //등록 API
    @PostMapping("/api/board")
    public Board postBoard(@RequestBody BoardDTO boardDTO){
        Board board = new Board(boardDTO);
        boardJparepo.save(board);
        return board;
    }
    /* ID로 검색하는 영역인데 삭제해도 무관
    @PutMapping("/api/board/{boardid}")
    public Board putBoard(@PathVariable Long boardid, BoardDTO boardDTO){
        Optional<Board> optionalBoard = boardJparepo.findById(boardid);
        Board board = new Board();
        if(optionalBoard.isPresent()){
            board = optionalBoard.get();

        }
        return board;

    }*/
    //제목으로 검색하기
    //Board_JPAREPO를 통해서 원하는 대로 수정하면 될듯
    @PutMapping("/api/board/{boardTitle}")
    public Board putBoardTitle(@PathVariable String boardTitle, BoardDTO boardDTO){
        Optional<Board> optionalBoard = boardJparepo.findByBoardTitle(boardTitle);

        Board board = new Board();
        if(optionalBoard.isPresent()){
            board = optionalBoard.get();

        }

        return board;
    }
    @PutMapping("/api/board/sub/{boardTitle}")
    public List<Board> putBoardTitleSub(@PathVariable String boardTitle){
        return  boardJparepo.findBoardByBoardTitleContainingOrderByBoardIdDesc(boardTitle);

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
