package org.iptime.naduri.controller;

import lombok.RequiredArgsConstructor;
import org.iptime.naduri.config.auth.LoginUser;
import org.iptime.naduri.config.auth.dto.CheckUser;
import org.iptime.naduri.config.auth.dto.SessionUser;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.*;


import javax.persistence.Query;
import java.util.Map;
@RequiredArgsConstructor
@Controller
public class MainController {

    //유저가 회원인지 확인하는 개체
    private final CheckUser checkUser;

    @RequestMapping("/main")
    public String main(Model model, @LoginUser SessionUser user, @RequestParam Map<String, Object> param) {
        if (user != null) {
            model.addAttribute("userName", user.getNickName());
            if (!checkUser.isUser()) {
                return "signup";
            }
        }
        String a =(String) param.get("a");
        String b =(String) param.get("b");
        String c =(String) param.get("c");
        String d =(String) param.get("d");
        if(a != null){
            System.out.println(a);
        }
        if(b != null){
            System.out.println(b);
        }
        if(c != null){
            System.out.println(c);
        }
        if(d != null){
            System.out.println(d);
        }

        return "main";
    }
}
