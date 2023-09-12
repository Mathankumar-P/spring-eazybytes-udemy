package com.springexercise.eazyschool.model;

import com.springexercise.eazyschool.annotation.FieldsValueMatch;
import com.springexercise.eazyschool.annotation.PasswordValidator;
import jakarta.persistence.*;
import jakarta.validation.constraints.*;
import lombok.Data;
import org.hibernate.annotations.GenericGenerator;

@Data
@Entity
@FieldsValueMatch.List({
        @FieldsValueMatch( field = "pwd" , fieldMatch ="confirmPwd", message = "Passwords do not match !"),
        @FieldsValueMatch(field = "email", fieldMatch = "confirmEmail", message = "Emails do not match !")
        })
public class Person extends BaseEntry {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO, generator= "native")
    @GenericGenerator(name ="native" , strategy = "native")
    private  int person_id;

    @NotBlank(message = "Name must not be blank")
    @Size(min=3, message ="Name must be  at-least 3 character long ")
    private  String name;

    @NotBlank(message = "Mobile number must not be blank")
    @Pattern(regexp="(^$|[0-9]{10})", message ="Name must be  at-least 3 character long ")
    private String mobileNumber;

    @NotBlank(message = "Email must not be blank")
    @Email(message="Please provide valid mail id")
    private String email;

    @NotBlank(message = "Confirm mail must not be blank")
    @Email(message="Please provide valid mail id")
    @Transient
    private String confirmEmail;

    @NotBlank(message = "Password must not be blank")
    @Size(min=5, message ="Name must be  at-least 3 character long ")
    @PasswordValidator
    private String pwd;

    @NotBlank(message = "Confirm password must not be blank")
    @Size(min=5, message ="Name must be at-least 3 character long ")
    @Transient
    private String confirmPwd;

}
