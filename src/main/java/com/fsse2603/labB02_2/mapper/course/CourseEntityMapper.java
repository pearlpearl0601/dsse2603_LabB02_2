package com.fsse2603.labB02_2.mapper.course;

import com.fsse2603.labB02_2.data.course.domainObject.request.CreateCourseRequestData;
import com.fsse2603.labB02_2.data.course.entity.CourseEntity;
import com.fsse2603.labB02_2.data.person.entity.PersonEntity;
import org.springframework.stereotype.Component;

@Component
public class CourseEntityMapper {
    public CourseEntity toCourseEntity(CreateCourseRequestData requestData, PersonEntity teacher) {
        CourseEntity courseEntity = new CourseEntity();
        courseEntity.setCourseId(requestData.getCourseId());
        courseEntity.setCourseName(requestData.getCourseName());
        courseEntity.setPrice(requestData.getPrice());
        courseEntity.setTeacher(teacher);
        return courseEntity;
    }
}
