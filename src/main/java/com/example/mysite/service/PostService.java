package com.example.mysite.service;

import com.example.mysite.domain.Post;
import com.example.mysite.dto.PostSaveRequestDto;
import com.example.mysite.dto.PostUpdateRequestDto;
import com.example.mysite.repository.PostRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.time.LocalDateTime;

@Service
@RequiredArgsConstructor
public class PostService {

    @Autowired
    final private PostRepository postRepository;

    public Page<Post> findPosts(Pageable pageable){
        if(pageable.getPageNumber() <= 0){
            pageable = PageRequest.of(0, pageable.getPageSize());
        }else{
            pageable = PageRequest.of(pageable.getPageNumber()-1, pageable.getPageSize());
        }

        return postRepository.findAll(pageable);
    }

    @Transactional
    public void savePost(PostSaveRequestDto postSaveRequestDto) {
        Post post= Post.builder()
                .title(postSaveRequestDto.getTitle())
                .content(postSaveRequestDto.getContent())
                .createdTime(LocalDateTime.now())
                .build();
        postRepository.save(post);
    }

    @Transactional
    public void updatePost(Long postId, PostUpdateRequestDto postUpdateRequestDto) {
        Post findPost = postRepository.findById(postId).orElse(new Post());
        findPost.updatePost(postUpdateRequestDto.getTitle(),
                postUpdateRequestDto.getContent());
    }

    public Post findPostByIdx(Long idx){
        return postRepository.findById(idx).orElse(new Post());
    }
}
