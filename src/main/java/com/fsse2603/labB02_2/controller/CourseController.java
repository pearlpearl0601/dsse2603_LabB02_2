package com.fsse2603.labB02_2.controller;

import com.fsse2603.labB02_2.data.course.domainObject.request.CreateCourseRequestData;
import com.fsse2603.labB02_2.data.course.domainObject.request.UpdateCourseRequestData;
import com.fsse2603.labB02_2.data.course.domainObject.response.CourseResponseData;
import com.fsse2603.labB02_2.data.course.dto.request.CreateCourseRequestDto;
import com.fsse2603.labB02_2.data.course.dto.request.UpdateCourseRequestDto;
import com.fsse2603.labB02_2.data.course.dto.response.CourseResponseDto;
import com.fsse2603.labB02_2.mapper.course.CourseDataMapper;
import com.fsse2603.labB02_2.mapper.course.CourseDtoMapper;
import com.fsse2603.labB02_2.service.CourseService;
import jakarta.validation.Valid;
import jakarta.validation.constraints.NotBlank;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/courses")
@Validated
public class CourseController {
    private final CourseDataMapper courseDataMapper;
    private final CourseService courseService;
    private final CourseDtoMapper courseDtoMapper;

    public CourseController(CourseDataMapper courseDataMapper, CourseService courseService, CourseDtoMapper courseDtoMapper) {
        this.courseDataMapper = courseDataMapper;
        this.courseService = courseService;
        this.courseDtoMapper = courseDtoMapper;
    }

    @PostMapping
    public CourseResponseDto createCourse(@Valid @RequestBody CreateCourseRequestDto requestDto) {
//        Lv2
//        CreateCourseRequestData requestData = courseDataMapper.toCreateCourseRequestData(requestDto);
//        CourseResponseData responseData = courseService.createCourse(requestData);
//        CourseResponseDto responseDto = courseDtoMapper.toCourseResponseDto(responseData);
//        return responseDto;

//        Lv3
        return courseDtoMapper.toCourseResponseDto(
                courseService.createCourse(
                        courseDataMapper.toCreateCourseRequestData(requestDto)
                )
        );
    }

    @GetMapping
    public List<CourseResponseDto> getAllCourses() {
//        Lv2
//        List<CourseResponseData> responseDataList = courseService.getAllCourses();
//        List<CourseResponseDto> responseDtoList = courseDtoMapper.toCourseResponseDtoList(responseDataList);
//        return responseDtoList;

//        Lv3
        return courseDtoMapper.toCourseResponseDtoList(
                courseService.getAllCourses()
        );
    }

    @PutMapping
    public CourseResponseDto updateCourse(@Valid @RequestBody UpdateCourseRequestDto requestDto) {
//        Lv2
//        UpdateCourseRequestData requestData = courseDataMapper.toUpdateCourseRequestData(requestDto);
//        CourseResponseData responseData = courseService.updateCourse(requestData);
//        CourseResponseDto responseDto = courseDtoMapper.toCourseResponseDto(responseData);
//        return responseDto;

//        Lv3
        return courseDtoMapper.toCourseResponseDto(
                courseService.updateCourse(
                        courseDataMapper.toUpdateCourseRequestData(requestDto)
                )
        );
    }

    @DeleteMapping("/{course_id}")
    public CourseResponseDto deleteCourse(@NotBlank @PathVariable(value = "course_id") String courseId) {
//        Lv2
//        CourseResponseData responseData = courseService.deleteCourse(courseId);
//        CourseResponseDto responseDto = courseDtoMapper.toCourseResponseDto(responseData);
//        return responseDto;

//        Lv3
        return courseDtoMapper.toCourseResponseDto(
                courseService.deleteCourse(courseId)
        );
    }

    @PostMapping("/{course_id}/students/{person_hkid}")
    public CourseResponseDto addStudent(@PathVariable(value = "course_id") String courseId,
                                        @PathVariable(value = "person_hkid") String personHkid) {
//        Lv2
//        CourseResponseData responseData = courseService.addStudent(courseId, personHkid);
//        CourseResponseDto responseDto = courseDtoMapper.toCourseResponseDto(responseData);
//        return responseDto;

//        Lv3
        return courseDtoMapper.toCourseResponseDto(
                courseService.addStudent(courseId, personHkid)
        );
    }

    @DeleteMapping("/{course_id}/students/{person_hkid}")
    public CourseResponseDto deleteStudent(@PathVariable(value = "course_id") String courseId,
                                           @PathVariable(value = "person_hkid") String personHkid) {
//        Lv2
//        CourseResponseData responseData = courseService.deleteStudent(courseId, personHkid);
//        CourseResponseDto responseDto = courseDtoMapper.toCourseResponseDto(responseData);
//        return responseDto;

//        Lv3
        return courseDtoMapper.toCourseResponseDto(
                courseService.deleteStudent(courseId, personHkid)
        );
    }

}