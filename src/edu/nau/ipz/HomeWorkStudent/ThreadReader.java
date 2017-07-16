package edu.nau.ipz.HomeWorkStudent;

import java.io.IOException;
import java.util.List;

class ThreadReader extends ThreadInteraction {

    ThreadReader(String filename, List<Student> students) throws IOException {
        super(filename, students);
    }

    public synchronized void run() {
        String line = null;
        while(true) {
                Thread t = newThread(() -> {
                    System.out.println("ReadThread-" + Thread.currentThread().getName() + " починає працювати");
                    try {
                        fileManager.read(Thread.currentThread(), this.students);
                        display();
                    } catch (IOException e) {
                        e.printStackTrace();
                    }
                    System.out.println("ReadThread-" + Thread.currentThread().getName() + " завершив роботу");
                });
                t.start();
            try {
                Thread.sleep(1);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
            if (line == null) {
                break;
            }
        }
    }

    public void display() {
        System.out.println("<< Десеріалізовані студенти >>");
        for(Student one:this.students) {
            System.out.println(one.toString());
        }
    }

}