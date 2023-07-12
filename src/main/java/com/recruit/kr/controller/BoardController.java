package com.recruit.kr.controller;

import com.recruit.kr.domain.board.Board;
import com.recruit.kr.domain.board.BoardDTO;
import com.recruit.kr.domain.board.Board_JPAREPO;
import com.recruit.kr.service.BoardService;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.ModelAndView;

import java.util.ArrayList;
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
        switch (boardWantedRole){
            case "프론트엔드": // 프론트 엔드 항목으로 글 출력

            case "백엔드": // 백엔드 항목으로 글 출력

            case "보안": // 보안 항목으로 글 출력

            case "AI": // AI 항목으로 글 출력
                return boardJparepo.findBoardsByBoardWantedRoleContainingOrderByBoardIdDesc(boardWantedRole);

            default: // 기본값은 ALL 항목으로 글 출력
                return boardJparepo.findBoardsByOrderByBoardIdDesc();
        }
    }

    @RequestMapping("/api/boardOne/{boardId}")
    public ModelAndView getRead(@PathVariable Long boardId, ModelAndView model){
        Optional <Board> optionalBoard = boardJparepo.findById(boardId);
        Board board = new Board();
        if(optionalBoard.isPresent()) {
            board = optionalBoard.get();
        }
        model.setViewName("ProjectPage.html");
        model.addObject("title", board.getBoardTitle());
        model.addObject("content",board.getBoardContent());
        model.addObject("wantedRole", board.getBoardWantedRole());
        model.addObject("author", board.getBoardAuthor());
        model.addObject("createdTime",board.getBoardcreatedTime());
        return model;
    }
    //상세페이지
    @GetMapping("/api/board/getOne/{boardId}")
    public Board getRead(@PathVariable Long boardId){
        Optional <Board> optionalBoard = boardJparepo.findById(boardId);
        Board board = new Board();
        if(optionalBoard.isPresent()) {
            board = optionalBoard.get();
        }
        return board;
    }
    //게시판 들어가서 확인할때 호출하는 부분

//    @RequestMapping("/api/board/getOne/{boardId}")
//    public ModelAndView getRead(@PathVariable Long boardId, ModelAndView model){
//        Optional <Board> optionalBoard = boardJparepo.findById(boardId);
//        Board board = new Board();
//        if(optionalBoard.isPresent()) {
//            board = optionalBoard.get();
//        }
//        model.setViewName("ProjectPage.html");
//        model.addObject("board", board);
//        return model;
//    }

    //게시판 들어가서 확인할때 호출하는 부분


    @RequestMapping("/ProjectPage.html/{boardId}")
    public String getOne() {
        return "";
    }

    //등록 API
    @PostMapping("/api/board")
    public Board postBoard(@RequestBody BoardDTO boardDTO){
        Board board = new Board(boardDTO);
        boardJparepo.save(board);
        return board;
    }

    @PutMapping("/api/board/{boardWantedRole}/{boardTitle}")
    public List<Board> putBoardTitle(@PathVariable String boardWantedRole, @PathVariable String boardTitle){
        //boardWantedRole="프론트엔드";
        //위에 wantedRole은 임시 변수 선언한거(테스트용)
        List<Board> boardList = new ArrayList<>();
        switch (boardWantedRole){
            case "프론트엔드": // 프론트 엔드 항목으로 글 출력

            case "백엔드": // 백엔드 항목으로 글 출력

            case "보안": // 보안 항목으로 글 출력

            case "AI": // AI 항목으로 글 출력
                boardList = boardJparepo.findBoardsByBoardWantedRoleContainingAndBoardTitleContainingOrderByBoardIdDesc(boardWantedRole, boardTitle);
                break;

            default: // 기본값은 ALL 항목으로 글 출력
                boardList = boardJparepo.findBoardsByBoardTitleContainingOrderByBoardIdDesc(boardTitle);
                break;
        }

        return boardList;
        //검색 결과 없을때 굳이 return null 해 줄 필요 없어 보여서 그냥 검색 결과 명단만 출력 하게 만듬
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
