package com.springexercise.eazyschool.service;

import com.springexercise.eazyschool.constants.EazySchoolConstants;
import com.springexercise.eazyschool.model.Person;
import com.springexercise.eazyschool.model.Roles;
import com.springexercise.eazyschool.repository.PersonRepository;
import com.springexercise.eazyschool.repository.RolesRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class PersonService {
    @Autowired
    private PersonRepository personRepository;
    @Autowired
    private RolesRepository rolesRepository;
    public boolean createNewPerson(Person person){
        boolean isSaved = false;
        Roles roles = rolesRepository.getByRoleName(EazySchoolConstants.STUDENT_ROLE);
        person.setRoles(roles);
        person=personRepository.save(person);
        if (person != null && person.getPerson_id()>0){
            isSaved=true;
        }
        return isSaved;
    }
}
