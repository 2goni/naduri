package org.iptime.naduri.controller;

import lombok.RequiredArgsConstructor;
import org.iptime.naduri.config.auth.LoginUser;
import org.iptime.naduri.config.auth.dto.CheckUser;
import org.iptime.naduri.config.auth.dto.SessionUser;
import org.iptime.naduri.domain.user_info.UserInfo;
import org.iptime.naduri.domain.user_info.UserInfoRepository;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;

@RequiredArgsConstructor
@Controller
public class LoginController {
    //유저가 회원인지 확인하는 개체
    private final CheckUser checkUser;
    private final UserInfoRepository userInfoRepository;

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

    @PostMapping("/signupuser")
    public String signUpUser(@LoginUser SessionUser user){

        return "redirect:/";
    }
}
