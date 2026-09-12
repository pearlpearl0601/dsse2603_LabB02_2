package com.fsse2603.labB02_2.mapper.course;

import com.fsse2603.labB02_2.data.course.domainObject.response.CourseResponseData;
import com.fsse2603.labB02_2.data.course.dto.response.CourseResponseDto;
import com.fsse2603.labB02_2.mapper.person.PersonDtoMapper;
import org.springframework.stereotype.Component;

import java.util.ArrayList;
import java.util.List;

@Component
public class CourseDtoMapper {
    private final PersonDtoMapper personDtoMapper;

    public CourseDtoMapper(PersonDtoMapper personDtoMapper) {
        this.personDtoMapper = personDtoMapper;
    }

    public CourseResponseDto toCourseResponseDto(CourseResponseData responseData) {
        CourseResponseDto responseDto = new CourseResponseDto();
        responseDto.setCourseId(responseData.getCourseId());
        responseDto.setCourseName(responseData.getCourseName());
        responseDto.setPrice(responseData.getPrice());
        responseDto.setTeacher(
                personDtoMapper.toPersonResponseDto(responseData.getTeacher())
        );
        responseDto.setStudents(
                personDtoMapper.toPersonResponseDtoList(responseData.getStudents())
        );
        return responseDto;
    }

    public List<CourseResponseDto> toCourseResponseDtoList(List<CourseResponseData> responseDataList) {
        List<CourseResponseDto> responseDtoList = new ArrayList<>();

        for (CourseResponseData courseResponseData : responseDataList) {
            responseDtoList.add(toCourseResponseDto(courseResponseData));
        }

        return responseDtoList;
    }
}