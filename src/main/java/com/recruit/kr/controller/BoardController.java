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

    //여기에 쓰인 이름은 가칭이므로 추후 변동 가능
    @GetMapping("/api/board/{boardWantedRole}")
    public List<Board> getBoard(@PathVariable String boardWantedRole){
        if(boardWantedRole.equals("all")){
            return boardJparepo.findAllByOrderByBoardIdDesc();
        }
        else if(boardWantedRole.equals("프론트엔드")){
            return boardJparepo.findAllByBoardWantedRoleContainingOrderByBoardIdDesc(boardWantedRole);
        }
        else if(boardWantedRole.equals("백엔드")){
            return boardJparepo.findAllByBoardWantedRoleContainingOrderByBoardIdDesc(boardWantedRole);
        }
        else if(boardWantedRole.equals(("보안"))){
            return boardJparepo.findAllByBoardWantedRoleContainingOrderByBoardIdDesc(boardWantedRole);
        }
        else if(boardWantedRole.equals("AI")){
            return boardJparepo.findAllByBoardWantedRoleContainingOrderByBoardIdDesc(boardWantedRole);
        }
        //위에 코드 압축 가능할지도? 어차피 우리가 원하는 검색 요소가 4가지로 카테고리 있는거니깐
        else{
            return null;
        }
    }
    //등록 API
    @PostMapping("/api/board")
    public Board postBoard(@RequestBody BoardDTO boardDTO){
        Board board = new Board(boardDTO);
        boardJparepo.save(board);
        return board;
    }

    /*
    //제목으로 검색하기
    //Board_JPAREPO를 통해서 원하는 대로 수정하면 될듯
    @PutMapping("/api/board/{boardTitle}")
    public Board putBoardTitle(@PathVariable String boardTitle){
        Optional<Board> optionalBoard = boardJparepo.findByBoardTitle(boardTitle);

        Board board = new Board();
        if(optionalBoard.isPresent()){
            board = optionalBoard.get();

        }

        return board;
    }
    */
    @PutMapping("/api/board/{boardTitle}")
    public List<Board> putBoardTitleSub(@PathVariable String boardTitle){
        List<Board> boardList = boardJparepo.findBoardByBoardTitleContainingOrderByBoardIdDesc(boardTitle);
        if(boardList.size()!=0){
            return boardList;
        }
        else{ return null;}

    }

    //삭제 API
    @DeleteMapping("/api/board/{boardId}")
    public void deleteBoard(@PathVariable Long boardId){
        boardJparepo.deleteById(boardId);
    }

    //수정 API
    @PatchMapping("/api/board/{boardId}")
    public void updateBoard(@PathVariable Long boardId, @RequestBody BoardDTO boardDTO){
        Optional<Board> optionalBoard = boardJparepo.findById(boardId);

        if(optionalBoard.isPresent()){
            boardService.updateBoard(boardId,boardDTO);
        }

    }
}
