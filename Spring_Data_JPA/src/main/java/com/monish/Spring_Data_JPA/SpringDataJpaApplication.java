package com.monish.Spring_Data_JPA;

import com.monish.Spring_Data_JPA.Repository.StudentRepo;
import com.monish.Spring_Data_JPA.model.Student;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.ApplicationContext;

import java.util.Optional;

@SpringBootApplication
public class SpringDataJpaApplication {

	public static void main(String[] args) {

		ApplicationContext context=SpringApplication.run(SpringDataJpaApplication.class, args);
		Student s1= context.getBean(Student.class);
		Student s2= context.getBean(Student.class);
		Student s3= context.getBean(Student.class);
		StudentRepo studentRepo=context.getBean(StudentRepo.class);
//		s1.setRollno(101);
//		s1.setSname("Monish");
//		s1.setMarks(100);
//
//		s2.setRollno(102);
//		s2.setSname("Kanaka");
//		s2.setMarks(90);
//
//		s3.setRollno(103);
//		s3.setSname("Kanishka");
//		s3.setMarks(98);
//
//		studentRepo.save(s1);
//		studentRepo.save(s2);
//		studentRepo.save(s3);

//		System.out.println(studentRepo.findAll());

//		Optional<Student> id = studentRepo.findById(104);
//		System.out.println(id.orElse(null));
//
//		//Some methods are not defined in the JPA but we can use these finding methods using the variables names we can actually use
//		System.out.println(studentRepo.findBySname("Monish"));
//
//		System.out.println(studentRepo.findByMarks(90));
//		System.out.println(studentRepo.findByMarksGreaterThan(90));

		s2.setRollno(102);
		s2.setSname("Kanaka");
		s2.setMarks(85);
//
//		studentRepo.save(s2);        //Updating the marks of s2

		studentRepo.delete(s2);


	}

}
