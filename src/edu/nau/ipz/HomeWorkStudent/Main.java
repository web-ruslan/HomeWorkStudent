package edu.nau.ipz.HomeWorkStudent;

import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

public class Main {

    private static List<Student> students = new ArrayList<>();
    private static List<Student> newStudents = new ArrayList<>();

    public static void main(String[] args) throws FileNotFoundException {

        final int MAX_COURSE = 5;
        final double MIN_SCORE = 1;
        final double MAX_SCORE = 5;
        String regexString = "[А-ЯІЇҐЄ][а-яіїґє’]+";
        String regexStringSpases = "([А-ЯІЇҐЄ][а-яіїґє’]+\\s?)+";
        String regexNumberString = "[0-9А-ЯІЇҐЄа-яіїґє]+";
        String regexFilePathString = "[0-9A-ZA-z/\\:\\.]+";
        ThreadReader reader = null;

        String FilePath = Helper.inputStringData("Введіть шлях та назву файлу", regexFilePathString);
        int listSize = Helper.inputIntData("Ведіть кількість студентів", Integer.MAX_VALUE);
        for (int i = 0; i < listSize; i++) {
            System.out.println("Студент № " +  (i+1));
            Student one = new Student();
            one.setLastName(Helper.inputStringData("Введіть прізвище", regexString));
            one.setName(Helper.inputStringData("Введіть ім’я", regexString));
            one.setMiddleName(Helper.inputStringData("Введіть по-батькові", regexString));
            one.setStudentNumber(Helper.inputStringData("Введіть номер студ. квитка (букви та цифри)", regexNumberString));
            one.setCourse(Helper.inputIntData("Ведіть курс (1-" + MAX_COURSE + ")", MAX_COURSE));
            one.setCountry(Helper.inputStringData("Ведіть країну", regexStringSpases));
            one.setSex(Helper.inputEnumData("Ведіть стать (Ч,Ж)", Sex.class));
            one.setScore(Helper.inputDoubleData("Ведіть бал (" + MIN_SCORE + "-" + MAX_SCORE + ")", MIN_SCORE, MAX_SCORE));
            students.add(one);
        }
/*
        String FilePath = "test.txt";

        students.add(new Student("Іванов", Sex.Ч));
        students.add(new Student("Петров", Sex.Ч));
        students.add(new Student("Сидоров", Sex.Ч));
        students.add(new Student("П`яточкін", Sex.Ч));
        students.add(new Student("Коновалов", Sex.Ч));
        students.add(new Student("Веремій", Sex.Ч));
*/
        System.out.println("<< Початковий список студентів >>");
        for (Student one : students) {
            System.out.println("Студент " + one.toString());
        }

        ThreadWriter writer = new ThreadWriter(FilePath, students);
        try {
            reader = new ThreadReader(FilePath, newStudents);
        } catch (IOException e) {
            e.printStackTrace();
        }

        ThreadInteraction.setWritingEnded(false);

        while (students.size() != 0) {
            writer.run();
        }

        ThreadInteraction.setWritingEnded(true);

        if (newStudents.size() == 0) {
            if (reader != null) {
                reader.run();
            }
        }
    }
}
