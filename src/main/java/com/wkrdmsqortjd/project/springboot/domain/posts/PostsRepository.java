package com.wkrdmsqortjd.project.springboot.domain.posts;

import org.springframework.data.jpa.repository.JpaRepository;

// Dao 의 역할
public interface PostsRepository extends JpaRepository<Posts, Long> {   // JpaRepository<Entity 클래스, PK 타입>
}
