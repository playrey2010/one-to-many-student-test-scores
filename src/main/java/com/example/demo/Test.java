package com.example.demo;

import javax.persistence.*;

@Entity
public class Test {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private long testid;
    private String subject;
    private String date;
    private int score;
    @ManyToOne
    @JoinColumn(name = "student_id")
    private Student student;

    public long getTestid() {
        return testid;
    }

    public void setTestid(long testid) {
        this.testid = testid;
    }

    public String getSubject() {
        return subject;
    }

    public void setSubject(String subject) {
        this.subject = subject;
    }

    public String getDate() {
        return date;
    }

    public void setDate(String date) {
        this.date = date;
    }

    public int getScore() {
        return score;
    }

    public void setScore(int score) {
        this.score = score;
    }

    public Student getStudent() {
        return student;
    }

    public void setStudent(Student student) {
        this.student = student;
    }
}
