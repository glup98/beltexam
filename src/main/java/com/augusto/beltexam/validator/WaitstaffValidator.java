package com.augusto.beltexam.validator;

import org.springframework.stereotype.Component;
import org.springframework.validation.Errors;
import org.springframework.validation.Validator;

import com.augusto.beltexam.models.Waitstaff;

@Component
public class WaitstaffValidator implements Validator {

    @Override
    public boolean supports(Class<?> clazz) {
        return Waitstaff.class.equals(clazz);
    }

        @Override
        public void validate(Object target, Errors errors) {
            Waitstaff waitstaff = (Waitstaff) target;
            
            if (!waitstaff.getPasswordConfirmation().equals(waitstaff.getPassword())) {

            errors.rejectValue("passwordConfirmation", "Match");
        }         
    }
}