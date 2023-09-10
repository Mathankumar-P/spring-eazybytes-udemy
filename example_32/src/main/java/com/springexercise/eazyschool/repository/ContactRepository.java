package com.springexercise.eazyschool.repository;

import com.springexercise.eazyschool.model.Contact;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Repository;

@Repository
public class ContactRepository {
   private final JdbcTemplate jdbcTemplate ;

    public ContactRepository(JdbcTemplate jdbcTemplate) {
        this.jdbcTemplate = jdbcTemplate;
    }
    public int saveMessageDetails (Contact contact ){
        String sql = "insert into contact_msg (name,mobile_no, email,subject,message, status, " +
                "created_at, created_by) values (?,?,?,?,?,?,?,?)";
        return jdbcTemplate.update(sql, contact.getName(),
                contact.getMobileNum(), contact.getEmail(),
                contact.getSubject(),contact.getMessage(),
                contact.getStatus(),contact.getCreated_At(),contact.getCreated_by());
    }
}
