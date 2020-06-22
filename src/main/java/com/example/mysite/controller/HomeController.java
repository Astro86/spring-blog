package com.example.mysite.controller;

import com.example.mysite.domain.Post;
import com.example.mysite.repository.PostRepository;
import com.example.mysite.service.PostService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Pageable;
import org.springframework.data.web.PageableDefault;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

import javax.annotation.PostConstruct;
import java.time.LocalDateTime;
import java.util.List;

@Controller
public class HomeController {

    @Autowired
    PostRepository postRepository;
    @Autowired
    PostService postService;


    @GetMapping({"", "/"})
    public String home(@PageableDefault Pageable pageable, Model model){
        model.addAttribute("PostList", postService.findPosts(pageable));
        return "home";
    }

    @PostConstruct
    public void init(){
        Post post = new Post().builder()
                .title("title1")
                .content("content1")
                .createdTime(LocalDateTime.now())
                .build();
        postRepository.saveAndFlush(post);

        Post post2 = new Post().builder()
                .title("title2")
                .content("content2")
                .createdTime(LocalDateTime.now())
                .build();
        postRepository.saveAndFlush(post2);
    }
}
