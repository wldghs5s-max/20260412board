package com.home.work.board.service;

import com.home.work.board.dto.BoardRequestDto;
import com.home.work.board.dto.BoardResponseDto;
import com.home.work.board.entity.BoardEntity;
import com.home.work.board.repository.BoardRepository;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Service
@Transactional
@Slf4j
@RequiredArgsConstructor
public class BoardService {
    private final BoardRepository boardRepository;

    public void write(BoardRequestDto dto) {
        BoardEntity entity = BoardEntity.builder()
                .title(dto.getTitle())
                .content(dto.getContent())
                .writer(dto.getWriter())
                .build();

        // 3️⃣ 저장
        boardRepository.save(entity);
    }
    @Transactional(readOnly = true)
    public List<BoardResponseDto> findAll() {

        return boardRepository.findAll()
                .stream()
                .map(BoardResponseDto::from)
                .toList();
    }
    @Transactional(readOnly = true)
    public BoardResponseDto findById(Long no) {

        BoardEntity entity = boardRepository.findById(no)
                .orElseThrow(() -> new IllegalArgumentException("게시글 없음"));

        return BoardResponseDto.from(entity);
    }

    public int delete(Long no) {

        // 1️⃣ 게시글 조회
        BoardEntity board = boardRepository.findById(no)
                .orElseThrow(() -> new IllegalArgumentException("게시글 없음"));

        boardRepository.delete(board);

        return 1;
    }
}
