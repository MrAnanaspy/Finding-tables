package com.SolSur.findingtables.users;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import java.util.List;


@Controller
public class UserController {

    private final UserService userService;

    public UserController(UserService userService) {
        this.userService = userService;
    }

    @GetMapping("/syte")
    public String syte(Model model){
        model.addAttribute("user", userService.list());
        return "syte";
    }

    @GetMapping("/reg")
    public String regload(Model model){
        return "registr";
    }

    @PostMapping(path = "reg")
    public String reg(@ModelAttribute User user, Model model) {
        String er = "";
        System.out.println(user);
        boolean a = userService.add(user);
        if (a == false){
            er = "Эта почта уже используется!";
        }
        model.addAttribute("er", er);
        return "registr";

    }
}
