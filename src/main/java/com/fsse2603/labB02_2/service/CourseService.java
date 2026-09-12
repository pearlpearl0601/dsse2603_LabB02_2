package com.fsse2603.labB02_2.service;

import com.fsse2603.labB02_2.data.course.domainObject.request.CreateCourseRequestData;
import com.fsse2603.labB02_2.data.course.domainObject.request.UpdateCourseRequestData;
import com.fsse2603.labB02_2.data.course.domainObject.response.CourseResponseData;

import java.util.List;

public interface CourseService {
    CourseResponseData createCourse(CreateCourseRequestData requestData);

    List<CourseResponseData> getAllCourses();

    CourseResponseData updateCourse(UpdateCourseRequestData requestData);

    CourseResponseData deleteCourse(String courseId);

    CourseResponseData addStudent(String courseId, String hkid);

    CourseResponseData deleteStudent(String courseId, String hkid);
}
