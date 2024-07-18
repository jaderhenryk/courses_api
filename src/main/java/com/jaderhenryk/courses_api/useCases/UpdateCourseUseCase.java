package com.jaderhenryk.courses_api.useCases;

import java.util.UUID;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.util.StringUtils;

import com.jaderhenryk.courses_api.exceptions.BodyNotProvidedUpdateCourseException;
import com.jaderhenryk.courses_api.models.dto.UpdateCourseRequest;
import com.jaderhenryk.courses_api.repositories.CourseRepository;

@Service
public class UpdateCourseUseCase {
    
    @Autowired
    private CourseRepository courseRepository;

    public void execute(UUID id, UpdateCourseRequest updateCourseRequest) throws Exception {
        if (updateCourseRequest == null) {
            throw new BodyNotProvidedUpdateCourseException();
        }
        if (!StringUtils.hasLength(updateCourseRequest.name()) && !StringUtils.hasLength(updateCourseRequest.category())) {
            throw new BodyNotProvidedUpdateCourseException();
        }
        if (StringUtils.hasLength(updateCourseRequest.name()) && StringUtils.hasLength(updateCourseRequest.category())) {
            this.courseRepository.updateCourseById(id, updateCourseRequest.name(), updateCourseRequest.category());
        } else if (StringUtils.hasLength(updateCourseRequest.name())) {
            this.courseRepository.updateCourseNameById(id, updateCourseRequest.name());
        } else {
            this.courseRepository.updateCourseCategoryById(id, updateCourseRequest.category());
        }
    }
    
}
