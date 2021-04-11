package com.sparta.patrick.utils;

import static com.sparta.patrick.App.logger;

public class myTimer {
    public static void time(String message, long start, long finish, int numRecords) {
        long time = finish - start;
        double timeSeconds = (double) time / 1000000000;
        int recordsPerSecond = (int) (numRecords / timeSeconds);
        logger.info( message +" which took: " + timeSeconds + " seconds. Approximately a rate of " + recordsPerSecond + " records per Second");
        Printer.printMessage("");
    }

    public static void time(String message, long start, long finish) {
        long time = finish - start;
        double timeSeconds = (double) time / 1000000000;
        logger.info( message + timeSeconds + " seconds.");
        Printer.printMessage("");
    }
}
