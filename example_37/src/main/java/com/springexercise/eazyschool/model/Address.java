package com.springexercise.eazyschool.model;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.Pattern;
import jakarta.validation.constraints.Size;
import lombok.Data;
import org.hibernate.annotations.GenericGenerator;

@Data
@Entity
public class Address  extends BaseEntry{
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO, generator = "native")
    @GenericGenerator(name="native",strategy = "native")
    private int addressId;

    @NotBlank(message = "Address 1 cannot be blank")
    @Size(min=5, message = "Address 1 must be minimum 5 character long")
    private String address1;
    private String address2;
    @NotBlank(message = "City must not be blank")
    @Size(min=3, message = "City must be minimum 3 character long")
    private String city;
    @NotBlank(message = "State must not be blank")
    @Size(min=3, message = "State  must be minimum 3 character long")
    private String state;
    @NotBlank(message = "Zip code must not be blank")
    @Pattern(regexp="(^$|[0-9]{5})", message = "Zip Code must be minimum 3 character long")
    private String zipCode;
}
