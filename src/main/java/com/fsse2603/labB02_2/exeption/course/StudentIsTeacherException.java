package com.fsse2603.labB02_2.exeption.course;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ResponseStatus;

@ResponseStatus(HttpStatus.BAD_REQUEST)
public class StudentIsTeacherException extends RuntimeException {
    public StudentIsTeacherException(String hkid) {
        super("Student is Teacher: " + hkid);
    }
}