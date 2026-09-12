package com.fsse2603.labB02_2.service.impl;

import com.fsse2603.labB02_2.data.course.domainObject.request.CreateCourseRequestData;
import com.fsse2603.labB02_2.data.course.domainObject.request.UpdateCourseRequestData;
import com.fsse2603.labB02_2.data.course.domainObject.response.CourseResponseData;
import com.fsse2603.labB02_2.data.course.entity.CourseEntity;
import com.fsse2603.labB02_2.data.person.entity.PersonEntity;
import com.fsse2603.labB02_2.exception.course.*;
import com.fsse2603.labB02_2.mapper.course.CourseDataMapper;
import com.fsse2603.labB02_2.mapper.course.CourseEntityMapper;
import com.fsse2603.labB02_2.service.CourseService;
import com.fsse2603.labB02_2.service.PersonService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
public class CourseServiceImpl implements CourseService {
    private final Logger log = LoggerFactory.getLogger(CourseServiceImpl.class);
    private final CourseEntityMapper courseEntityMapper;
    private final CourseDataMapper courseDataMapper;

    private List<CourseEntity> courseEntityList = new ArrayList<>();

    private final PersonService personService;


    public CourseServiceImpl(PersonService personService, CourseEntityMapper courseEntityMapper, CourseDataMapper courseDataMapper) {
        this.personService = personService;
        this.courseEntityMapper = courseEntityMapper;
        this.courseDataMapper = courseDataMapper;
    }

    @Override
    public CourseResponseData createCourse(CreateCourseRequestData requestData) {
        try {
            if (isCourseExist(requestData.getCourseId())) {
                throw new CourseExistedException(requestData.getCourseId());
            }

//            Lv2
//            PersonEntity teacherEntity = personService.getEntityByHkid(requestData.getTeacherHkid());
//
//            CourseEntity courseEntity = courseEntityMapper.toCourseEntity(requestData, teacherEntity);
//            courseEntityList.add(courseEntity);
//
//            CourseResponseData responseData = courseDataMapper.toCourseResponseData(courseEntity);
//            return responseData;

//            Lv3
            CourseEntity courseEntity = courseEntityMapper.toCourseEntity(
                    requestData,
                    personService.getEntityByHkid(requestData.getTeacherHkid())
            );
            courseEntityList.add(courseEntity);

            return courseDataMapper.toCourseResponseData(courseEntity);
        } catch (Exception ex) {
            log.warn("Create Course Failed: {}", ex.getMessage());
            throw ex;
        }
    }

    @Override
    public List<CourseResponseData> getAllCourses() {
//        Lv2
//        List<CourseResponseData> responseDataList = courseDataMapper.toCourseResponseDataList(courseEntityList);
//        return responseDataList;

//        Lv3
        return courseDataMapper.toCourseResponseDataList(courseEntityList);
    }

    @Override
    public CourseResponseData updateCourse(UpdateCourseRequestData requestData) {
        try {
//            Lv2
//            CourseEntity courseEntity = getEntityByCourseId(requestData.getCourseId());
//            PersonEntity teacherEntity = personService.getEntityByHkid(requestData.getTeacherHkid());
//
//            courseEntity.setCourseName(requestData.getCourseName());
//            courseEntity.setPrice(requestData.getPrice());
//            courseEntity.setTeacher(teacherEntity);
//
//            CourseResponseData courseResponseData = courseDataMapper.toCourseResponseData(courseEntity);
//            return courseResponseData;

//            Lv3
            CourseEntity courseEntity = getEntityByCourseId(requestData.getCourseId());

            courseEntity.setCourseName(requestData.getCourseName());
            courseEntity.setPrice(requestData.getPrice());
            courseEntity.setTeacher(
                    personService.getEntityByHkid(requestData.getTeacherHkid())
            );

            return courseDataMapper.toCourseResponseData(courseEntity);
        } catch (Exception ex) {
            log.warn("Update Course Failed: {}", ex.getMessage());
            throw ex;
        }
    }

    @Override
    public CourseResponseData deleteCourse(String courseId) {
        try {
            CourseEntity courseEntity = getEntityByCourseId(courseId);
            courseEntityList.remove(courseEntity);
            return courseDataMapper.toCourseResponseData(courseEntity);
        } catch (Exception ex) {
            log.warn("Delete Course Failed: {}", ex.getMessage());
            throw ex;
        }
    }

    @Override
    public CourseResponseData addStudent(String courseId, String hkid) {
        try {
//            Lv2
//            CourseEntity courseEntity = getEntityByCourseId(courseId);
//            PersonEntity studentEntity = personService.getEntityByHkid(hkid);
//
//            if (courseEntity.getTeacher().getHkid().equals(hkid)) {
//                throw new StudentIsTeacherException(hkid);
//            }
//
//            for (PersonEntity entity : courseEntity.getStudents()) {
//                if (entity.getHkid().equals(hkid)) {
//                    throw new StudentDuplicatedException(hkid);
//                }
//            }
//
//            courseEntity.getStudents().add(studentEntity);
//            CourseResponseData responseData = courseDataMapper.toCourseResponseData(courseEntity);
//            return responseData;

//            Lv3
            CourseEntity courseEntity = getEntityByCourseId(courseId);

            if (courseEntity.getTeacher().getHkid().equals(hkid)) {
                throw new StudentIsTeacherException(hkid);
            }

            for (PersonEntity entity : courseEntity.getStudents()) {
                if (entity.getHkid().equals(hkid)) {
                    throw new StudentDuplicatedException(hkid);
                }
            }

            courseEntity.getStudents().add(personService.getEntityByHkid(hkid));
            return courseDataMapper.toCourseResponseData(courseEntity);
        } catch (Exception ex) {
            log.warn("Add Student to Course Failed: {}", ex.getMessage());
            throw ex;
        }
    }

    @Override
    public CourseResponseData deleteStudent(String courseId, String hkid) {
        try {
            CourseEntity courseEntity = getEntityByCourseId(courseId);
            for (PersonEntity studentEntity : courseEntity.getStudents()) {
                if (studentEntity.getHkid().equals(hkid)) {
                    courseEntity.getStudents().remove(studentEntity);
                    return courseDataMapper.toCourseResponseData(courseEntity);
                }
            }

            throw new StudentNotFoundException(hkid);
        } catch (Exception ex) {
            log.warn("Delete Student Failed: {}", ex.getMessage());
            throw ex;
        }
    }

    public boolean isCourseExist(String courseId) {
        for (CourseEntity courseEntity : courseEntityList) {
            if (courseEntity.getCourseId().equals(courseId)) {
                return true;
            }
        }
        return false;
    }

    public CourseEntity getEntityByCourseId(String courseId) {
        for (CourseEntity entity : courseEntityList) {
            if (entity.getCourseId().equals(courseId)) {
                return entity;
            }
        }

        throw new CourseNotFoundException(courseId);
    }
}
