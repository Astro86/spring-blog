package com.example.mysite.domain;

import lombok.*;

import javax.persistence.*;
import java.time.LocalDateTime;

@Entity
@Getter
@NoArgsConstructor
public class Post {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column
    private String title;

    @Column
    @Lob
    private String content;

    @Column
    private LocalDateTime createdTime;

    public void updatePost(String title, String content){
        this.title = title;
        this.content = content;
    }

    @Builder
    public Post(String title, String content, LocalDateTime createdTime){
        this.title = title;
        this.content = content;
        this.createdTime = createdTime;
    }
}
