package com.example.demo;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.stereotype.Component;

@Component
public class DataLoader implements CommandLineRunner {

    @Autowired
    StudentRepository studentRepository;

    @Autowired
    TestRepository testRepository;

    @Override
    public void run(String... strings) throws Exception {
        Student student;
        student = new Student();
        student.setName("Reynaldo");
        student.setMajor( "Foreign Languages");

        studentRepository.save(student);
        student = new Student();
        student.setName("Hemanuel");
        student.setMajor("Pharmacy");
        studentRepository.save(student);

        Test test;
        test = new Test();
        test.setDate("Yesterday");
        test.setScore(100);
        test.setSubject("Science");
        test.setStudent(student);
        testRepository.save(test);


    }
}
