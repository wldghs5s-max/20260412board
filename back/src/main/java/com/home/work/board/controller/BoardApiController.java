package com.home.work.board.controller;

import com.home.work.board.dto.BoardRequestDto;
import com.home.work.board.dto.BoardResponseDto;
import com.home.work.board.service.BoardService;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RequiredArgsConstructor
@RestController
@RequestMapping("/api/board")
@CrossOrigin
@Slf4j
public class BoardApiController {

    private final BoardService boardService;

    @PostMapping
    public int write(@RequestBody BoardRequestDto dto){
        boardService.write(dto);
        return 1;
    }
    @GetMapping
    public List<BoardResponseDto> list(){
        return boardService.findAll();
    }

    @GetMapping("{no}")
    public BoardResponseDto detail(@PathVariable Long no){
        return boardService.findById(no);
    }

    @DeleteMapping("{no}")
    public int delete(@PathVariable Long no){

        return boardService.delete(no);
    }

}
