//@Component is used to tell the spring to create an object of that class
//@Auto wired is used to send to object of its child class
//@values is used to set the default values
//@Primary is used make the priority to send the object of child class
//@Qualifier is used to make more priority than the primary annotation
//@Scope is used to set the scope to create an object of a particular class
//Singletype and prototype
//@RequestMapping is used to map the url with the method
//@RequestParam("num1") is used to map the values coming from client to the variables in the logic
//@RestController is used give the RestApi to create an object of controller class
//@GetMapping is used to get the data from the db to the client
//@PostMaping is used to send the data from the client side
//@PutMapping is used to update the data from the client side on the db
//@deleteMaping is used to delete the data inthe db from client
//Response Entity is responsible to send the status code
//In return type we need to add the return type in generics form
//we need to create a new reponse entity which takes 2 parameter 1 is the object and the Http status
//@Json format
//@Lob
//@RequestPart
package com.monish.app;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.ApplicationContext;
import org.springframework.context.ApplicationListener;

@SpringBootApplication
public class SpringDemoApplication {

	public static void main(String[] args) {

		ApplicationContext context=SpringApplication.run(SpringDemoApplication.class, args);
		Alien ref = context.getBean(Alien.class);
		System.out.println(ref.getAge());
		ref.show();

	}

}
