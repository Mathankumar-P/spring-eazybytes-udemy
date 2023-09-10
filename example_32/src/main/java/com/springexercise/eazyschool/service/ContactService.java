package com.springexercise.eazyschool.service;

import com.springexercise.eazyschool.constants.EazySchoolConstants;
import com.springexercise.eazyschool.controller.ContactController;
import com.springexercise.eazyschool.model.Contact;
import com.springexercise.eazyschool.repository.ContactRepository;
import lombok.extern.slf4j.Slf4j;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.context.annotation.ApplicationScope;
import org.springframework.web.context.annotation.RequestScope;
import org.springframework.web.context.annotation.SessionScope;

import java.time.LocalDateTime;

@Slf4j
@Service
public class ContactService {
    @Autowired
    private ContactRepository contactRepository;
    public ContactService(){
        System.out.println("Contact Service Bean initialized");
    }
    public boolean saveMessageDetails(Contact contact){
        boolean isSaved = false;
        contact.setStatus(EazySchoolConstants.OPEN);
        contact.setCreated_by(EazySchoolConstants.ANONYMOUS);
        contact.setCreated_At(LocalDateTime.now());
        int result = contactRepository.saveMessageDetails(contact);
        if(result>0){
            isSaved =true;
        }
        return isSaved;
    }
}
