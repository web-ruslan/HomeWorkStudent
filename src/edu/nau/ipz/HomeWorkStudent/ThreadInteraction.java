package edu.nau.ipz.HomeWorkStudent;

import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.List;

public abstract class ThreadInteraction implements Runnable{

    protected FileManager fileManager;
    protected List<Student> students;
    protected static boolean isWritingEnded = true;
    private static int counter = 0;


    ThreadInteraction(String filename, List<Student> students) throws FileNotFoundException {
        this.students = students;
        try {
            this.fileManager = FileManager.getInstance(filename);
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    public static void setWritingEnded(boolean writingEnded) {
        isWritingEnded = writingEnded;
    }

    protected Thread newThread(Runnable r) {
        return new Thread(r, Integer.toString(counter++));
    }
}
