package com.home.work.board.dto;

import com.home.work.board.entity.BoardEntity;
import lombok.*;

import java.time.LocalDateTime;

@Getter
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class BoardResponseDto {

    private Long no;
    private String title;
    private String content;

    private String writer;

    private LocalDateTime createdAt;

    public static BoardResponseDto from(BoardEntity entity){
        return BoardResponseDto.builder()
                .no(entity.getNo())
                .title(entity.getTitle())
                .content(entity.getContent())
                .writer(entity.getWriter())
                .createdAt(entity.getCreatedAt())
                .build();
    }
}