package edu.nau.ipz.HomeWorkStudent;

import java.io.*;
import java.util.ArrayList;
import java.util.List;

class FileManager {

    private static volatile FileManager instance;
    private File file;
    private BufferedReader reader;
    private List<String> contentList = new ArrayList<>();

    private FileManager(String fileName) throws FileNotFoundException {
        this.file = new File(fileName);
    }

    static FileManager getInstance(String fileName) throws IOException {
        if (instance == null && fileName != null) {
            if (instance == null) {
                instance = new FileManager(fileName);
                instance.reader = new BufferedReader(new FileReader(fileName));
            }
        }
        return instance;
    }

    public void clear() {
        try {
            PrintWriter cl = new PrintWriter(this.file);
            cl.print("");
            cl.close();
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        }

    }

    public void read(Thread thread, List<Student> Students) throws IOException {

        String line;
        if (contentList.isEmpty()) {
            while ((line = reader.readLine()) != null) {
                if (!line.isEmpty()) {
                    contentList.add(line);
                }
            }
        }
        while (!contentList.isEmpty()) {
            String so = contentList.stream().reduce((a1, a2) -> a2).orElse(null);
            contentList.remove(so);
            if (so != null) {
                System.out.println("ReadThread-" + thread.getName() + " читає студента");
                String[] tmp = so.split(" \\| ");
                Student student = new Student();
                student.setLastName(tmp[0].split(" ")[1]);
                student.setName(tmp[1].split(" ")[1]);
                student.setMiddleName(tmp[2].split(" ")[1]);
                student.setStudentNumber(tmp[3].split(" ")[1]);
                student.setCourse(Integer.parseInt(tmp[4].split(" ")[1]));
                student.setCountry(tmp[5].split(" ")[1]);
                student.setSex(Sex.valueOf(tmp[6].split(" ")[1]));
                student.setScore(Double.parseDouble(tmp[7].split(" ")[1]));
                System.out.println("Прочитав: " + student.toString());
                Students.add(student);
            }
        }
    }

    public void write(Student student, Thread thread) {
        System.out.println("WriteThread-" + thread.getName() + " пише студента \n" + student.toString());
        try (FileWriter fw = new FileWriter(this.file,true);
             BufferedWriter bw = new BufferedWriter(fw);
             PrintWriter out = new PrintWriter(bw)) {
            out.println(student.toString());
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
