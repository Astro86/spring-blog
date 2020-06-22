package com.example.mysite.dto;

import lombok.Getter;
import lombok.Setter;

import javax.persistence.Column;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.Lob;
import javax.validation.constraints.NotEmpty;
import java.time.LocalDateTime;

@Setter
@Getter
public class PostSaveRequestDto {
    @NotEmpty
    private String title;
    @Lob
    private String content;
}
