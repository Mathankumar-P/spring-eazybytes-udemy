package com.springexercise.eazyschool.controller;

import com.springexercise.eazyschool.model.Holiday;
import com.springexercise.eazyschool.repository.HolidaysRepository;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;

import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.StreamSupport;


@Controller
public class HolidaysController {
    private final HolidaysRepository holidaysRepository;

    public HolidaysController(HolidaysRepository holidaysRepository) {
        this.holidaysRepository = holidaysRepository;
    }
    @GetMapping("/holidays/{display}")
    public String displayHolidays(@PathVariable String display, Model model) {
        if(null != display && display.equals("all")){
            model.addAttribute("festival",true);
            model.addAttribute("federal",true);
        }else if(null != display && display.equals("federal")){
            model.addAttribute("federal",true);
        }else if(null != display && display.equals("festival")){
            model.addAttribute("festival",true);
        }
       Iterable<Holiday> holidays =  holidaysRepository.findAll();
        List<Holiday>listHolidays = StreamSupport.stream(holidays.spliterator(),false).collect(Collectors.toList());
        Holiday.Type[] types = Holiday.Type.values();
        for (Holiday.Type type : types) {
            model.addAttribute(type.toString(),
                    (listHolidays.stream().filter(holiday -> holiday.getType().equals(type)).collect(Collectors.toList())));
        }
        return "holidays.html";
    }
}
