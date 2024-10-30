package com.springboot.blog.entity;


import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.HashSet;
import java.util.Set;

@Data
@AllArgsConstructor
@NoArgsConstructor

@Entity
@Table(
        name = "posts" , uniqueConstraints = {@UniqueConstraint(columnNames = {"titles"})}
)
public class Post {

    @Id
    @GeneratedValue( strategy = GenerationType.IDENTITY)
    private Long id ;

    @Column(name = "title", nullable = false)
    private String title ;

    @Column(name = "description", nullable = false)
    private String description ;

    @Column(name = "author", nullable = false)
    private String author ;

    @Column(name = "content", nullable = false)
    private String content ;

    @OneToMany(mappedBy = "post",cascade = CascadeType.ALL, orphanRemoval = true)
    private Set<Comment> comments = new HashSet<>();
}
