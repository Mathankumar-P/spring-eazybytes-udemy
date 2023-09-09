package com.springexercise.eazyschool.controller;

import com.springexercise.eazyschool.model.Contact;
import com.springexercise.eazyschool.service.ContactService;
import jakarta.validation.Valid;
import lombok.extern.slf4j.Slf4j;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.Errors;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;
@Slf4j
@Controller
public class ContactController {

//    private static Logger log = LoggerFactory.getLogger(ContactController.class);
    private ContactService contactService ;
    @Autowired
    public ContactController(ContactService contactService){
        this.contactService=contactService;
    }

    @RequestMapping("/contact")
    public String displayContactPage(Model model) {
        model.addAttribute("contact", new Contact());
        return "contact.html";
    }

/*    @RequestMapping(value="/saveMsg", method = RequestMethod.POST)
    public ModelAndView saveMessage(@RequestParam String name, @RequestParam String mobileNum,
 @RequestParam String email,  @RequestParam String subject ,@RequestParam String message){
        log.info("Name : : " +name  );
        log.info("Mobile : : " +mobileNum  );
        log.info("Email  : : " +email  );
        log.info("Subject : : " +subject  );
        log.info("Message  : : " + message  );
        return new ModelAndView("redirect:/contact");
    }*/

    @RequestMapping(value="/saveMsg", method = RequestMethod.POST)
    public String saveMessage(@Valid @ModelAttribute ("contact") Contact contact, Errors errors) {
        if(errors.hasErrors()){
            log.error("contact form failed due to  : "+errors.toString());
            return "contact.html";
        }
        contactService.saveMessageDetails(contact);
        contactService.setCounter(contactService.getCounter()+1);
        log.info("Number of times the Contact form is submitted : "+contactService.getCounter());
        return "redirect:/contact";
    }

}
