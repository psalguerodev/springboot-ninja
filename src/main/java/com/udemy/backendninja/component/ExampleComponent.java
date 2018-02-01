package com.udemy.backendninja.component;

import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.springframework.stereotype.Component;

@Component("exampleComponent")
public class ExampleComponent {
	
	public static final Log LOGGER = LogFactory.getLog(ExampleComponent.class);
	
	public void sayHellow(String name ) {
		LOGGER.info( "TRACE >> " + "Desde el componente." );
		LOGGER.info( "Tu nombre es: " + name.trim().toUpperCase() );
	}
	
}
