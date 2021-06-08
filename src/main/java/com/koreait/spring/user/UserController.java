package com.koreait.spring.user;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.multipart.MultipartFile;

@Controller
@RequestMapping("/user")  // 1차 주소값
public class UserController {  // Controller에는 호출만

    @Autowired
    private UserService service;

    @RequestMapping(value = "/login", method = RequestMethod.GET)  // 2차 주소값, GET 메소드는 Default
    public String login(Model model, @RequestParam(value = "err", defaultValue = "0") int err) {
        switch (err) {
            case 1: // 아이디 없음
                model.addAttribute("errMsg", "아이디를 확인해 주세요.");
                break;
            case 2: // 비번 틀림
                model.addAttribute("errMsg", "비밀번호를 확인해 주세요.");
                break;
        }
        return "user/login";
    }

    @RequestMapping(value = "/login", method = RequestMethod.POST)
    public String login(UserEntity param) {
        return "redirect:" + service.login(param);
    }


    @RequestMapping("/join")
    public String join() {
        return "user/join";
    }

    @RequestMapping(value = "join", method = RequestMethod.POST)
    public String join(UserEntity param) {
        service.join(param);
        return "redirect:/user/login";
    }

    @RequestMapping(value = "/profile")
    public String profile() {
        return "user/profile";
    }

    //    @RequestMapping(value = "/profile", method = RequestMethod.POST)
    @PostMapping("/profile")
    public String profile(MultipartFile profileImg) {
        return "redirect:" + service.uploadProfile(profileImg);
    }
}
