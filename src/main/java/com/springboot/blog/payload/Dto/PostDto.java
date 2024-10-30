package com.springboot.blog.payload.Dto;

import jakarta.validation.constraints.NotEmpty;
import jakarta.validation.constraints.Size;
import lombok.Data;

import java.util.Set;

@Data
public class PostDto {
    private Long id ;

    @NotEmpty
    @Size(min = 2, message = "Post tittle should have at least 2 characters")
    private String title ;

    @NotEmpty
    @Size(min = 10, message = "Post description cannot be blank ")
    private String description ;

    private String author ;

    @NotEmpty
    private String content ;

    private Set<CommentDto> comments ;
}
