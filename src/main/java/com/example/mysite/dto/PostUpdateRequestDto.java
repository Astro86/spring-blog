package com.example.mysite.dto;

import lombok.Getter;
import lombok.Setter;

import javax.validation.constraints.NotEmpty;

@Getter
@Setter
public class PostUpdateRequestDto {
    @NotEmpty
    private String title;
    private String content;
}
