package com.fsse2603.labB02_2.exeption.course;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ResponseStatus;

@ResponseStatus(HttpStatus.BAD_REQUEST)
public class CourseExistedException extends RuntimeException {
    public CourseExistedException(String courseId) {
        super("Course Existed: " + courseId);
    }
}