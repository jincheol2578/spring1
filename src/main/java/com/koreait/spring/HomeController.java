package com.koreait.spring;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
public class HomeController {
    @RequestMapping("/")
    public String home(){
        return "main/home";
    } // 리턴해야할 파일명과 메소드명이 같으면 void 사용가능
}
