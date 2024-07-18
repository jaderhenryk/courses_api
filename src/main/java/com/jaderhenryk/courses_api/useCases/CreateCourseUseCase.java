package com.jaderhenryk.courses_api.useCases;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.jaderhenryk.courses_api.models.Course;
import com.jaderhenryk.courses_api.repositories.CourseRepository;

@Service
public class CreateCourseUseCase {

    @Autowired
    private CourseRepository courseRepository;
    
    public Course execute(Course course) {
        var createdCourse = this.courseRepository.save(course);
        return createdCourse;
    }
}
