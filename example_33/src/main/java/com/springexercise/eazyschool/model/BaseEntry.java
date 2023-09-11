package com.springexercise.eazyschool.model;

import lombok.Data;

import java.time.LocalDateTime;

@Data
public class BaseEntry {
    private LocalDateTime created_At;
    private String  created_by;
    private LocalDateTime updated_At;
    private String updated_by;
}
