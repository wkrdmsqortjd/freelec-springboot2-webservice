package com.wkrdmsqortjd.project.springboot.web;

import com.wkrdmsqortjd.project.springboot.service.PostsService;
import com.wkrdmsqortjd.project.springboot.web.dto.PostsResponseDto;
import com.wkrdmsqortjd.project.springboot.web.dto.PostsSaveRequestDto;
import com.wkrdmsqortjd.project.springboot.web.dto.PostsUpdateRequestDto;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.*;

@RequiredArgsConstructor    // final 필드의 생성자 자동 생성, 주입
@RestController
public class PostsApiController {

    private final PostsService postsService;

    @PostMapping("/api/v1/posts")   // 등록
    public Long save(@RequestBody PostsSaveRequestDto requestDto) {
        return postsService.save(requestDto);
    }

    @PutMapping("/api/v1/posts/{id}")   // 수정
    public Long update(@PathVariable Long id, @RequestBody PostsUpdateRequestDto requestDto) {
        return postsService.update(id, requestDto);
    }
    
    @GetMapping("/api/v1/posts/{id}")   // 조회
    public PostsResponseDto findById(@PathVariable Long id) {
        return postsService.findById(id);
    }
}
