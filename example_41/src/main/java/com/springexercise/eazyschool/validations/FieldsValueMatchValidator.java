package com.springexercise.eazyschool.validations;

import com.springexercise.eazyschool.annotation.FieldsValueMatch;
import jakarta.validation.ConstraintValidator;
import jakarta.validation.ConstraintValidatorContext;
import org.springframework.beans.BeanWrapperImpl;

public class FieldsValueMatchValidator implements ConstraintValidator <FieldsValueMatch, Object>{

    private String field;
    private String fieldMatch;
    public void initialize (FieldsValueMatch constrainAnnotation){
        this.field = constrainAnnotation.field();
        this.fieldMatch = constrainAnnotation.fieldMatch();
    }
    @Override
    public boolean isValid(Object value, ConstraintValidatorContext context) {
        Object fieldValue = new BeanWrapperImpl(value).getPropertyValue(field);
        Object fieldMatchValue = new BeanWrapperImpl(value).getPropertyValue(fieldMatch);
        if(fieldValue!=null){
            return fieldValue.equals(fieldMatchValue);
        } else {
            return fieldMatchValue == null;
        }
    }
}
