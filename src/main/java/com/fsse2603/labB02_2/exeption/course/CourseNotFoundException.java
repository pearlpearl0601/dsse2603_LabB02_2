package com.fsse2603.labB02_2.exeption.course;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ResponseStatus;

@ResponseStatus(HttpStatus.NOT_FOUND)
public class CourseNotFoundException extends RuntimeException {
    public CourseNotFoundException(String courseId) {
        super("Course not found: " + courseId);
    }
}