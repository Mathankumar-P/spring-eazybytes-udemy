package com.springexercise.eazyschool.controller;

import com.springexercise.eazyschool.model.Person;
import jakarta.validation.Valid;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.Errors;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

@Slf4j
@Controller
@RequestMapping("public")
public class PublicController {
    //PersonService personService;
    @RequestMapping(value="/register1", method ={RequestMethod.GET})
    public String displayRegisterPage1(Model model){
        System.out.println("Request Reached");
       // model.addAttribute("person", new Person());
        return "regiser.html";
    }
    @RequestMapping(value ="/register",method = { RequestMethod.GET})
    public String displayRegisterPage(Model model) {
        System.out.println("Request Reached2");
        model.addAttribute("person", new Person());
        return "register.html";
    }

    @RequestMapping(value = "/createUser", method = RequestMethod.POST)
    public String creatUser(@Valid @ModelAttribute ("person") Person person , Errors error){
        if (error.hasErrors()){
            return "register.html";
        }
        return "redirect:/login?register=true";
    }

}
