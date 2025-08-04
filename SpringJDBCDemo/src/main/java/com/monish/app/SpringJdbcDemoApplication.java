package com.monish.app;

import com.monish.app.model.Student;
import com.monish.app.service.StudentService;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.ApplicationContext;

import java.util.List;

@SpringBootApplication
public class SpringJdbcDemoApplication {

	public static void main(String[] args) {

		ApplicationContext context = SpringApplication.run(SpringJdbcDemoApplication.class, args);

		Student s1 = context.getBean(Student.class);
		s1.setRollNo(104);
		s1.setName("Monish");
		s1.setMarks(99);

		StudentService service = context.getBean(StudentService.class);
		service.addStudent(s1);

		List<Student> students = service.getStudents();
		System.out.println(students);


	}

}
