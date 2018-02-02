package com.udemy.backendninja.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

import com.udemy.backendninja.constants.ViewsConstant;
import com.udemy.backendninja.entity.Course;
import com.udemy.backendninja.service.CourseService;

@Controller
@RequestMapping("/course")
public class CourseController {

	/* ===========================[ INJECTION COURSE SERVICE ]=========================== */
	@Autowired
	@Qualifier("courseServiceImpl")
	private CourseService courseService;

	
	/* ===========================[ LIST COURSES ]======================================= */	
	@GetMapping("/list")
	public ModelAndView listAllCourses() {
		ModelAndView mav = new ModelAndView(ViewsConstant.COURSE_LIST);
		mav.addObject("courses", this.courseService.listAllCourses() );
		return mav;
	}

	/* ===========================[ ADD  COURSES ]======================================= */
	@PostMapping("/add")
	public String addCourse( @ModelAttribute("course") Course course ) {
		this.courseService.saveCourse(course);
		return "redirect:/course/list";
	}
	
	
}
