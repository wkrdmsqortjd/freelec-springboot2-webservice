package com.wkrdmsqortjd.project.springboot.web;

import com.wkrdmsqortjd.project.springboot.web.dto.HelloResponseDto;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

@RestController                     // JSON 를 반환하는 컨트롤러, @ResponseBody 를 한번에 사용할 수 있게 설정
public class HelloController {

    @GetMapping("/hello")           // HTTP Method 인 GET 요청을 받을 수 있는 API 설정
    public String hello() {
        return "hello";
    }

    @GetMapping("/hello/dto")
    public HelloResponseDto helloDto(@RequestParam String name, @RequestParam int amount) {
        return new HelloResponseDto(name, amount);
    }
}
