package com.home.work.board.entity;

import jakarta.persistence.*;
import lombok.*;

import java.time.LocalDateTime;

@Entity
@Table(name = "BOARD")
@Getter
@NoArgsConstructor(access = AccessLevel.PROTECTED)
@AllArgsConstructor
@Builder
public class BoardEntity {

    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "SEQ_BOARD")
    @SequenceGenerator(
            name = "SEQ_BOARD",
            sequenceName = "SEQ_BOARD",
            allocationSize = 1
    )
    private Long no;

    @Column(name = "TITLE", length = 200)
    private String title;

    @Column(name = "CONTENT", length = 4000)
    private String content;
    @Column(name = "WRITER", length = 100)
    private String writer;

    @Column(name = "CREATED_AT")
    private LocalDateTime createdAt;
    @Column(name = "MODIFIED_AT")
    private LocalDateTime modifiedAt;


    public void update(String title, String content) {
        this.title = title;
        this.content = content;
        this.modifiedAt = LocalDateTime.now();
    }

}
