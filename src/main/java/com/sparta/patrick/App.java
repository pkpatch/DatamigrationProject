package com.sparta.patrick;

import com.sparta.patrick.View.Starter;
import com.sparta.patrick.utils.myTimer;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

/**
 * Hello world!
 *
 */
public class App 
{
    public static final Logger logger = LogManager.getLogger(App.class);

    public static void main( String[] args )
    {
        logger.info("Application Started:: ");
        logger.info("Timer initialised:: ");
        long start = System.nanoTime();
        Starter.start();
        long finish = System.nanoTime();
        myTimer.time("The entire process took: ", start, finish);
    }
}
