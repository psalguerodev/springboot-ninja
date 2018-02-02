package com.udemy.backendninja.component;

import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Component;

import com.udemy.backendninja.repository.CourseJpaRepository;

@Component("exampleComponent")
public class ExampleComponent {
	
	@Autowired
	@Qualifier("courseJpaRepository")
	private CourseJpaRepository courseJpaRepository;
	
	public ExampleComponent() {
		
	}
	
	public static final Log LOGGER = LogFactory.getLog(ExampleComponent.class);
	
	public void sayHellow(String name ) {
		LOGGER.info( "TRACE >> " + "Desde el componente." );
		LOGGER.info( "Tu nombre es: " + name.trim().toUpperCase() );
	}
	
}
