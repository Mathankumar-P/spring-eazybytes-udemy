package com.springexercise.eazyschool.controller;

import com.springexercise.eazyschool.model.EazyClass;
import com.springexercise.eazyschool.model.Person;
import com.springexercise.eazyschool.repository.EazyClassRepository;
import com.springexercise.eazyschool.repository.PersonRepository;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;

import java.util.List;
import java.util.Optional;

@Slf4j
@Controller
@RequestMapping("admin")
public class AdminController {

    @Autowired
    EazyClassRepository eazyClassRepository;

    @Autowired
    PersonRepository personRepository;
    @RequestMapping(value = "/displayClasses")
    public ModelAndView displayClasses(Model model){
        List<EazyClass> eazyClasses = eazyClassRepository.findAll();
        ModelAndView modelAndView = new ModelAndView("classes.html");
        modelAndView.addObject("eazyClass", new EazyClass());
        modelAndView.addObject("eazyClasses", eazyClasses);
        return modelAndView;
    }
    @PostMapping(value = "/addNewClass")
    public ModelAndView addNewClass(Model model , @ModelAttribute("eazyClass") EazyClass eazyClass){
        eazyClassRepository.save(eazyClass);
        ModelAndView modelAndView = new ModelAndView(("redirect:/admin/displayClasses"));
        return modelAndView;
    }

    @RequestMapping(value =  "deleteClass")
    public ModelAndView deleteClass(Model model , @RequestParam int id){
        Optional<EazyClass> eazyClass = eazyClassRepository.findById(id);
        for(Person person : eazyClass.get().getPerson()){
            person.setEazyClass(null);
            personRepository.save(person);
        }
        eazyClassRepository.deleteById(id);
        ModelAndView modelAndView = new ModelAndView(("redirect:/admin/displayClasses"));
        return modelAndView;
    }
}
