package com.springexercise.eazyschool.repository;

import com.springexercise.eazyschool.model.Contact;
import com.springexercise.eazyschool.rowmapper.ContactRowMapper;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.PreparedStatementSetter;
import org.springframework.stereotype.Repository;

import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.sql.Timestamp;
import java.time.LocalDateTime;
import java.util.List;

@Repository
public class ContactRepository {
   private final JdbcTemplate jdbcTemplate ;

    public ContactRepository(JdbcTemplate jdbcTemplate) {
        this.jdbcTemplate = jdbcTemplate;
    }
    public int saveMessageDetails (Contact contact ){
        String sql = "INSERT INTO CONTACT_MSG (NAME,MOBILE_NUM,EMAIL,SUBJECT,MESSAGE,STATUS," +
                "CREATED_AT,CREATED_BY) VALUES (?,?,?,?,?,?,?,?)";
        return jdbcTemplate.update(sql, contact.getName(),
                contact.getMobileNum(), contact.getEmail(),
                contact.getSubject(),contact.getMessage(),
                contact.getStatus(),contact.getCreated_At(),contact.getCreated_by());
    }

    public List<Contact> findMsgWithStatus(String status) {
        String sql = "SELECT *  FROM CONTACT_MSG WHERE STATUS = ?";
        return jdbcTemplate.query(sql, new PreparedStatementSetter() {
            @Override
            public void setValues(PreparedStatement ps) throws SQLException {
                ps.setString(1, status); } } , new ContactRowMapper() );
    }

    public int updateMessageStatus(int id, String close, String name) {
        String sql = "UPDATE CONTACT_MSG SET STATUS = ?, UPDATED_AT = ? , UPDATED_BY =? WHERE CONTACT_ID =?";
        return jdbcTemplate.update(sql, new PreparedStatementSetter() {
            @Override
            public void setValues(PreparedStatement ps) throws SQLException {
                ps.setString(1,close);
                ps.setTimestamp(2, Timestamp.valueOf(LocalDateTime.now()));
                ps.setString(3, name);
                ps.setInt(4,id);
                }
            });

    }
}
