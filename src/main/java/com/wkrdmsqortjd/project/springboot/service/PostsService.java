package com.wkrdmsqortjd.project.springboot.service;

import com.wkrdmsqortjd.project.springboot.domain.posts.Posts;
import com.wkrdmsqortjd.project.springboot.domain.posts.PostsRepository;
import com.wkrdmsqortjd.project.springboot.web.dto.PostsResponseDto;
import com.wkrdmsqortjd.project.springboot.web.dto.PostsSaveRequestDto;
import com.wkrdmsqortjd.project.springboot.web.dto.PostsUpdateRequestDto;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import javax.transaction.Transactional;

@RequiredArgsConstructor    // final 필드의 생성자 자동 생성, 주입
@Service
public class PostsService {

    private final PostsRepository postsRepository;

    // 저장
    @Transactional
    public Long save(PostsSaveRequestDto requestDto) {
        return postsRepository.save(requestDto.toEntity()).getId();
    }

    // 수정
    @Transactional
    public Long update(Long id, PostsUpdateRequestDto requestDto) {
        Posts posts = postsRepository.findById(id)
                .orElseThrow(() -> new IllegalArgumentException("해당 게시글이 없습니다. id = " + id));

        posts.update(requestDto.getTitle(), requestDto.getContent());

        return id;  // 영속성 컨텍스트 때문에 DB에 쿼리를 날리는 부분이 없음
    }

    // 조회
    public PostsResponseDto findById (Long id) {
        Posts entity = postsRepository.findById(id)
                .orElseThrow(() -> new IllegalArgumentException("해당 게시물이 없습니다. id = " + id));

        return new PostsResponseDto(entity);
    }
}
