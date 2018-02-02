package com.udemy.backendninja.service.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;

import com.udemy.backendninja.entity.Course;
import com.udemy.backendninja.repository.CourseJpaRepository;
import com.udemy.backendninja.service.CourseService;

public class CourseServiceImpl  implements CourseService{

	@Autowired
	@Qualifier("courseJpaRepository")
	private CourseJpaRepository courseJpaRepository;
	
	@Override
	public List<Course> listAllCourses() {
		// TODO Auto-generated method stub
		return this.courseJpaRepository.findAll();
	}

	@Override
	public Course saveCourse(Course c) {
		// TODO Auto-generated method stub
		return this.courseJpaRepository.save(c);
	}

	@Override
	public Course updateCourse(Course c) {
		// TODO Auto-generated method stub
		return this.courseJpaRepository.save(c);
	}

	@Override
	public boolean deleteCourse(int id) {
		// TODO Auto-generated method stub
		this.courseJpaRepository.delete(id);
		return true;
	}

	
	
}
