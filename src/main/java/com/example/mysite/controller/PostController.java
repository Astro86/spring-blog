package com.example.mysite.controller;

import com.example.mysite.domain.Post;
import com.example.mysite.dto.PostSaveRequestDto;
import com.example.mysite.repository.PostRepository;
import com.example.mysite.service.PostService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;

import java.time.LocalDateTime;


@Controller
public class PostController {

    @Autowired
    PostRepository postRepository;
    @Autowired
    PostService postService;

    @GetMapping("/{id}")
    public String post(@PathVariable Long id, Model model){
        Post post = postService.findPostByIdx(id);
        return "/post/postDetail";
    }

    @GetMapping("/new")
    public String createPost(@ModelAttribute("postForm")PostSaveRequestDto postSaveRequestDto, Model model){
        return "/post/createPostForm";
    }

    @PostMapping("/new")
    public String newPost(@ModelAttribute("postForm")PostSaveRequestDto postSaveRequestDto, Model model){
        postService.savePost(postSaveRequestDto);
        return "redirect:";
    }
}
