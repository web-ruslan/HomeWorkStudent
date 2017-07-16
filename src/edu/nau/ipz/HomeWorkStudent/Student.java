package edu.nau.ipz.HomeWorkStudent;

import java.io.Serializable;

public class Student implements Serializable {
    private String lastName;
    private String name;
    private String middleName;
    private String studentNumber;
    private int course;
    private String country;
    private Sex s;
    private double score;

    public Student() {

    }

    public Student(String lastName, Sex sex) {
        this.lastName = lastName;
        this.s = sex;
    }

    public String getLastName() {
        return lastName;
    }

    public void setLastName(String lastName) {
        this.lastName = lastName;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getMiddleName() {
        return middleName;
    }

    public void setMiddleName(String middleName) {
        this.middleName = middleName;
    }

    public String getStudentNumber() {
        return studentNumber;
    }

    public void setStudentNumber(String studentNumber) {
        this.studentNumber = studentNumber;
    }

    public int getCourse() {
        return course;
    }

    public void setCourse(int course) {
        this.course = course;
    }

    public String getCountry() {
        return country;
    }

    public void setCountry(String country) {
        this.country = country;
    }

    public Sex getSex() {
        return s;
    }

    public void setSex(Sex s) {
        this.s = s;
    }

    public double getScore() {
        return score;
    }

    public void setScore(double score) {
        this.score = score;
    }

    public String toString() {
        return "Прізвище " + this.getLastName() + " | Ім'я " + this.getName() + " | По-батькові " + this.getMiddleName() + " | № " +
                this.getStudentNumber() + " | Курс " + this.getCourse() + " | Країна " + this.getCountry() +
                " | Стать " + this.getSex() + " | Бал " + this.getScore();
    }

}
