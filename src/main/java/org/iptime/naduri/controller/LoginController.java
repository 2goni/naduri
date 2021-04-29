package org.iptime.naduri.controller;

import lombok.RequiredArgsConstructor;
import org.iptime.naduri.config.auth.LoginUser;
import org.iptime.naduri.config.auth.dto.CheckUser;
import org.iptime.naduri.config.auth.dto.SessionUser;
import org.springframework.stereotype.Component;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

@RequiredArgsConstructor
@Controller
public class LoginController {
    //유저가 회원인지 확인하는 개체
    private final CheckUser checkUser;

    @GetMapping("/")
    public String login(Model model, @LoginUser SessionUser user){
        if(user != null){
            model.addAttribute("userName", user.getNickName());
            if(!checkUser.isUser()){
                return "signup";
            }
        }
        return "main";
    }
}
