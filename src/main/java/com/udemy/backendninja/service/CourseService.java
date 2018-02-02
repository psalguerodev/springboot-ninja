package com.udemy.backendninja.service;

import java.util.List;

import com.udemy.backendninja.entity.Course;

public interface CourseService {

	public abstract List<Course> listAllCourses();
	
	public abstract Course saveCourse(Course c);
	
	public abstract Course updateCourse( Course c );
	
	public abstract boolean deleteCourse( int id );
}
