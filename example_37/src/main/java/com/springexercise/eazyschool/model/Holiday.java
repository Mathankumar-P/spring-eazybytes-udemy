package com.springexercise.eazyschool.model;

import jakarta.persistence.*;
import lombok.Data;
import org.hibernate.annotations.GenericGenerator;

@Data
@Entity
@Table(name="holidays")
public class Holiday  extends BaseEntry{
    @Id
    private  String   day;
    private  String   reason;
    @Enumerated(EnumType.STRING)
    private  Type type;

    public enum Type {
        FESTIVAL,FEDERAL
    }
}
