package edu.nau.ipz.HomeWorkStudent;

import java.io.FileNotFoundException;
import java.util.List;

class ThreadWriter extends ThreadInteraction {

    ThreadWriter(String filename, List<Student> students) throws FileNotFoundException {
        super(filename, students);
        fileManager.clear();
    }

    public synchronized void run() {
                Student student = students.stream().reduce((a1, a2) -> a2).orElse(null);
                if (student != null) {
                    students.remove(student);
                    Thread t = newThread(() -> {
                        System.out.println("WriteThread-" + Thread.currentThread().getName() + " починає працювати");
                        fileManager.write(student, Thread.currentThread());
                        System.out.println("WriteThread-" + Thread.currentThread().getName() + " завершив роботу");
                    });
                    t.start();
            }
    }
}
