package com.udemy.backendninja.controller;

import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
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
	
	private static final Log LOG = LogFactory.getLog(CourseController.class);
	
	/* ===========================[ INJECTION COURSE SERVICE ]=========================== */
	@Autowired
	@Qualifier("courseServiceImpl")
	private CourseService courseService;

	@GetMapping("/")
	public String index() {
		return "redirect:/course/list";
	}
	
	/* ===========================[ LIST COURSES ]======================================= */	
	@GetMapping("/list")
	public ModelAndView listAllCourses() {
		LOG.info("Call: " + "listAllCourses()");
		ModelAndView mav = new ModelAndView( ViewsConstant.COURSE_LIST );
		mav.addObject("course" , new Course());
		mav.addObject("courses", this.courseService.listAllCourses() );
		return mav;
	}

	/* ===========================[ ADD  COURSES ]======================================= */
	@PostMapping("/add")
	public String addCourse( @ModelAttribute("course") Course course ) {
		LOG.info("Call: " + "addCourse( Course course ) -- PARAM " + course.toString() );
		this.courseService.saveCourse(course);
		return "redirect:/course/list";
	}
	
	
}
