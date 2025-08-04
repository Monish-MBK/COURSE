package com.monish.Hibernate_Practice.Service;

import com.monish.Hibernate_Practice.Entity.Student;
import com.monish.Hibernate_Practice.Repository.StudentRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.multipart.MultipartFile;

import java.io.IOException;
import java.util.List;

@Service
public class StudentService {
    @Autowired
    private StudentRepo repo;


    public Student addStudent(Student student) {
        return repo.save(student);
    }

    public Student addingImage(int id, MultipartFile image) throws IOException {
        Student student=repo.getReferenceById(id);
        if (student != null){
            student.setImage(image.getBytes());
            repo.save(student);
        }
        return student;
    }

    public Student allAll(Student student, MultipartFile image) throws IOException {
        student.setImage(image.getBytes());
        return repo.save(student);
    }

    public List<Student> getAll() {
        return repo.findAll();
    }
    public Student getStudentById(int id) {
        return repo.findById(id).orElse(new Student(-1));
    }
}
