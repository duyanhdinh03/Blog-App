package com.springboot.blog.payload.Dto;

import lombok.Data;

import java.util.Set;

@Data
public class PostDto {
    private Long id ;
    private String title ;
    private String description ;
    private String author ;
    private String content ;

    private Set<CommentDto> comments ;
}
