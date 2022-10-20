package com.wkrdmsqortjd.project.springboot.domain.posts;

import org.springframework.data.jpa.repository.JpaRepository;

// Dao 의 역할, Post 클래스로 DB 를 접근하게 해줄 JpaRepository 를 구현받음
// 상속받으며 기본적인 CRUD 메서드가 자동 생성
public interface PostsRepository extends JpaRepository<Posts, Long> {   // JpaRepository<Entity 클래스, PK 타입>
}
