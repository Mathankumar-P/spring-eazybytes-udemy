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
import java.util.List;
import java.util.Optional;

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
        contact= contactRepository.save(contact);
        if(contact != null && contact.getContact_id()>0){
            isSaved =true;
        }
        return isSaved;
    }

    public List<Contact> findMsgWithOpenStatus() {
        List<Contact>contactList = contactRepository.findByStatus(EazySchoolConstants.OPEN);
        return contactList;
    }

    public boolean updateMsgStatus(int contact_id, String updated_by) {
        boolean isUpdated = false;
        Optional<Contact>contact =contactRepository.findById(contact_id);
        contact.ifPresent(contact1 -> {
            contact1.setStatus(EazySchoolConstants.CLOSE);
            contact1.setUpdated_At(LocalDateTime.now());
            contact1.setUpdated_by(updated_by);
        });
        Contact updateContact  = contactRepository.save(contact.get());
        if(updateContact != null && updateContact.getUpdated_by()!=null){
            isUpdated =true;
        }
        return isUpdated;
    }
}
