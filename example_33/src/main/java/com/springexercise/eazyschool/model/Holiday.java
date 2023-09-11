package com.springexercise.eazyschool.model;

import lombok.Data;

@Data

public class Holiday  extends BaseEntry{


    private  String   day;
    private  String   reason;
    private  Type type;

    public enum Type {
        FESTIVAL,FEDERAL
    }
}
