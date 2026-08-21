package com.fsse2603.labB02_2.exeption.person;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ResponseStatus;

@ResponseStatus(HttpStatus.NOT_FOUND)
public class PersonNotFoundException extends RuntimeException {
    public PersonNotFoundException(String hkid){
        super("Person Not Found:" + hkid);
    }
}
