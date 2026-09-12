package com.fsse2603.labB02_2.mapper.course;

import com.fsse2603.labB02_2.data.course.domainObject.request.CreateCourseRequestData;
import com.fsse2603.labB02_2.data.course.domainObject.request.UpdateCourseRequestData;
import com.fsse2603.labB02_2.data.course.domainObject.response.CourseResponseData;
import com.fsse2603.labB02_2.data.course.dto.request.CreateCourseRequestDto;
import com.fsse2603.labB02_2.data.course.dto.request.UpdateCourseRequestDto;
import com.fsse2603.labB02_2.data.course.entity.CourseEntity;
import com.fsse2603.labB02_2.mapper.person.PersonDataMapper;
import org.springframework.stereotype.Component;

import java.util.ArrayList;
import java.util.List;

@Component
public class CourseDataMapper {
    private final PersonDataMapper personDataMapper;

    public CourseDataMapper(PersonDataMapper personDataMapper) {
        this.personDataMapper = personDataMapper;
    }

    //    Request
    public CreateCourseRequestData toCreateCourseRequestData(CreateCourseRequestDto requestDto) {
        CreateCourseRequestData requestData = new CreateCourseRequestData();
        requestData.setCourseId(requestDto.getCourseId());
        requestData.setCourseName(requestDto.getCourseName());
        requestData.setPrice(requestDto.getPrice());
        requestData.setTeacherHkid(requestDto.getTeacherHkid());
        return requestData;
    }

    public UpdateCourseRequestData toUpdateCourseRequestData(UpdateCourseRequestDto requestDto) {
        UpdateCourseRequestData requestData = new UpdateCourseRequestData();
        requestData.setCourseId(requestDto.getCourseId());
        requestData.setCourseName(requestDto.getCourseName());
        requestData.setPrice(requestDto.getPrice());
        requestData.setTeacherHkid(requestDto.getTeacherHkid());
        return requestData;
    }

    //    Response
    public CourseResponseData toCourseResponseData(CourseEntity entity) {
        CourseResponseData responseData = new CourseResponseData();
        responseData.setCourseId(entity.getCourseId());
        responseData.setCourseName(entity.getCourseName());
        responseData.setPrice(entity.getPrice());
        responseData.setTeacher(
                personDataMapper.toPersonResponseData(entity.getTeacher())
        );
        responseData.setStudents(
                personDataMapper.toPersonResponseDataList(entity.getStudents())
        );
        return responseData;
    }

    public List<CourseResponseData> toCourseResponseDataList(List<CourseEntity> entityList) {
        List<CourseResponseData> responseDataList = new ArrayList<>();

        for (CourseEntity entity : entityList) {
            responseDataList.add(toCourseResponseData(entity));
        }

        return responseDataList;
    }
}
