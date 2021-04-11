package com.sparta.patrick.View;

import com.sparta.patrick.Controller.FileReader;

import static com.sparta.patrick.App.logger;

public class Starter {
    public static void start() {


        FileReader fileReader = new FileReader("resources/employees.csv");
        FileReader fileReader2 = new FileReader("resources/EmployeeRecordsLarge.csv");

        logger.info("Non-Threaded:: ");
        fileReader.readFile();
        fileReader2.readFile();

        /*logger.info("1-Thread:: ");
        Thread thread = new Thread(fileReader);
        thread.start();
        fileReader2.readFile();*/

        /*logger.info("Multi-Threaded:: ");
        Thread thread = new Thread(fileReader);
        Thread thread2 = new Thread(fileReader2);
        try {
            thread.start();
            thread2.start();
            thread.join();
            thread2.join();
        } catch (InterruptedException e) {
            e.printStackTrace();
        }*/
    }
}
