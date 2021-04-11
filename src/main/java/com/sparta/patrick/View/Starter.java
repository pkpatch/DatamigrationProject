package com.sparta.patrick.View;

import com.sparta.patrick.Controller.FileReader;
import com.sparta.patrick.utils.myTimer;

import static com.sparta.patrick.App.logger;

public class Starter {
    private static FileReader fileReader = new FileReader("resources/employees.csv");
    private static FileReader fileReader2 = new FileReader("resources/EmployeeRecordsLarge.csv");

    public static void start() {
        logger.info("Application Started:: ");
        logger.info("Timer initialised:: ");

        long start = System.nanoTime();
        startNoThread();
        long finish = System.nanoTime();
        myTimer.time("The entire process with no extra threads other than the main took: ", start, finish);

        start = System.nanoTime();
        startOneThread();
        finish = System.nanoTime();
        myTimer.time("The entire process with one extra thread as well as the main took: ", start, finish);

        start = System.nanoTime();
        startTwoThread();
        finish = System.nanoTime();
        myTimer.time("The entire process with 2 extra threads took: ", start, finish);
    }

    public static void startNoThread() {
        logger.info("Non-Threaded:: ");
        fileReader.readFile();
        fileReader2.readFile();

    }

    public static void startOneThread() {

        logger.info("1-Thread:: ");
        Thread thread = new Thread(fileReader);
        thread.start();
        fileReader2.readFile();

    }

    public static void startTwoThread() {

        logger.info("Multi-Threaded:: ");
        Thread thread = new Thread(fileReader);
        Thread thread2 = new Thread(fileReader2);
        try {
            thread.start();
            thread2.start();
            thread.join();
            thread2.join();
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }

}
