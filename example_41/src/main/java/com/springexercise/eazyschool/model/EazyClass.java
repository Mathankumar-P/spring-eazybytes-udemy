package com.springexercise.eazyschool.model;

import jakarta.annotation.sql.DataSourceDefinitions;
import jakarta.persistence.*;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.Size;
import lombok.Data;
import lombok.Singular;
import org.hibernate.annotations.GenericGenerator;

import java.util.Set;

@Data
@Entity
@Table(name ="class")
public class EazyClass extends BaseEntry {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO, generator = "native")
    @GenericGenerator(name="native", strategy = "native")
    private  int classId;

    @NotBlank(message ="Class Name must not be blank")
    @Size(min=3, message = "Name must have at least 3 characters")
    private String name;

    @OneToMany(mappedBy = "eazyClass", fetch = FetchType.LAZY, cascade = CascadeType.PERSIST, targetEntity = Person.class)
    private Set<Person> person;

}
