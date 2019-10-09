package com.example.demo;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

@Controller
public class HomeController {

    @Autowired
    StudentRepository studentRepository;

    @Autowired
    TestRepository testRepository;

    @RequestMapping("/")
    public String home(Model model) {
        model.addAttribute("students", studentRepository.findAll());
        model.addAttribute("tests", testRepository.findAll());
        return "index";
    }

    @GetMapping("/addStudent")
    public String addStudent(Model model) {
        model.addAttribute("student", new Student());
        return "studentform";
    }

    @PostMapping("/processStudent")
    public String processStudent(@ModelAttribute Student student) {
        studentRepository.save(student);
        return "redirect:/";
    }

    @GetMapping("/addScore")
    public String addScore(Model model) {
        model.addAttribute("students", studentRepository.findAll());
        model.addAttribute("test", new Test());
        return "testform";
    }

    @PostMapping("/processScore")
    public String processStudent(@ModelAttribute Test test, @RequestParam(name = "student") String student) {
        testRepository.save(test);
        return "redirect:/";
    }



}
