package com.wkrdmsqortjd.project.springboot.domain.posts;

import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;

import javax.persistence.*;

@Getter                 // 롬복 어노테이션
@NoArgsConstructor      // 롬복 어노테이션, 기본 생성자 자동 추가 public Posts(){}
@Entity                 // JPA 어노테이션, 테이블과 링크 될 클래스임을 표현. 기본값으로 네이밍 설정 ex) SalesManager.java -> sales_manager table
public class Posts {    // 실제 DB의 테이블과 매칭될 클래스 Entity 클래스라고도 불림, JPA 를 사용해 Entity 클래스를 통해 DB 데이터 수정

    @Id // 해당 테이블의 PK 필드
    @GeneratedValue(strategy = GenerationType.IDENTITY) // PK의 생성 규칙을 나타냄. 지금은 auto_increment 를 의미
    private Long id;

    @Column(length = 500, nullable = false) // @Column 테이블의 칼럼을 나타냄. 괄호 안에 설정 내용을 명시. 생략가능 (변경이 필요한 옵션이 있으면 명시)
    private String title;

    @Column(columnDefinition = "TEXT", nullable = false)
    private String content;

    private String author;

    @Builder    // 해당 클래스의 빌더 패턴 클래스 생성, 생성자 상단에 선언 시 생성자에 포함된 필드만 빌더에 포함
    public Posts(String title, String content, String author) {
        this.title = title;
        this.content = content;
        this.author = author;
    }

    public void update(String title, String content) {
        this.title = title;
        this.content = content;
    }
}
