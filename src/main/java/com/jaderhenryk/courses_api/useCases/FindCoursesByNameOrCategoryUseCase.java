package com.jaderhenryk.courses_api.useCases;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.jaderhenryk.courses_api.models.Course;
import com.jaderhenryk.courses_api.repositories.CourseRepository;

@Service
public class FindCoursesByNameOrCategoryUseCase {

    @Autowired
    private CourseRepository courseRepository;
    
    public List<Course> execute(String name, String category) {
        return this.courseRepository.findByNameOrCategoryIgnoreCase(name, category);
    }
}
