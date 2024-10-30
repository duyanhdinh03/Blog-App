package com.springboot.blog.controller;


import com.springboot.blog.payload.PostDto;
import com.springboot.blog.payload.PostResponse;
import com.springboot.blog.service.PostService;
import com.springboot.blog.ultis.AppConstant;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/posts")
public class PostController {
    private PostService postService;

    public PostController(PostService postService) {
        this.postService = postService;
    }

    //Create Blog post
    @PostMapping
    public ResponseEntity<PostDto> createPost(@RequestBody PostDto postDto) {
        return new ResponseEntity<>(postService.createPost(postDto), HttpStatus.CREATED);
    }


    //Get all posts
    @GetMapping
    public PostResponse getAllPosts(
            @RequestParam (value = "pageNo" , defaultValue = AppConstant.DEFAULT_PAGE_NUMBER, required = false) int pageNo,
            @RequestParam (value = "pageSize" , defaultValue = AppConstant.DEFAULT_PAGE_SIZE, required = false) int pageSize,
            @RequestParam(value = "sortBy" , defaultValue = AppConstant.DEFAULT_SORT_BY,required = false)String sortBy,
            @RequestParam(value = "sortDir", defaultValue = AppConstant.DEFAULT_SORT_DIRECTION, required = false)String sortDir
    ) {
        return postService.getAllPosts(pageNo, pageSize, sortBy, sortDir);
    }

    // Get post by ID
    @GetMapping("/{id}")
    public ResponseEntity<PostDto> getPostById(@PathVariable(name = "id") Long id) {
        return ResponseEntity.ok(postService.getPostById(id));
    }

    //Update post by id
    @PutMapping("/{id}")
    public ResponseEntity<PostDto> updatePost( @RequestBody PostDto postDto, @PathVariable(name = "id") Long id) {

        PostDto postResponse = postService.updatePost(postDto, id);

        return new ResponseEntity<>(postResponse, HttpStatus.OK);
    }

    //Delete Post
    @DeleteMapping("/{id}")
    public ResponseEntity<String> deletePost(@PathVariable(name = "id") Long id) {
        postService.deletePostById(id);
        return new ResponseEntity<>("Post deleted successfully", HttpStatus.OK);
    }
}
