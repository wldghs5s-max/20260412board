package com.home.work.board.dto;

import com.home.work.board.entity.BoardEntity;
import lombok.*;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class BoardRequestDto {

    private String title;
    private String content;
    private String writer;

    public BoardEntity toEntity() {
        return BoardEntity.builder()
                .title(title)
                .content(content)
                .writer(writer)
                .build();
    }


}