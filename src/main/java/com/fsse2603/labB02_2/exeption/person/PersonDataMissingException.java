package com.fsse2603.labB02_2.exeption.person;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ResponseStatus;

@ResponseStatus(HttpStatus.BAD_REQUEST)
public class PersonDataMissingException extends RuntimeException{
    public PersonDataMissingException(String data) {
        super(String.format("Update Person Failed: %s is missing",data));
    }

}


