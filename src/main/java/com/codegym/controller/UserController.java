package com.codegym.controller;


import com.codegym.model.User;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.servlet.ModelAndView;


@Controller
public class UserController {
    @GetMapping("/user")
    public ModelAndView showForm(){
        ModelAndView modelAndView=new ModelAndView("/index");
        modelAndView.addObject("user",new User());
        return modelAndView;
    }
    @PostMapping("/validate")
    public String checkValidate(@Validated @ModelAttribute("user") User user, BindingResult bindingResult, ModelAndView modelAndView){
        new User().validate(user,bindingResult);
        if (bindingResult.hasFieldErrors()){
            return "/index";
        }else {
            modelAndView.addObject("user",user);
            return "/success";
        }
    }
}