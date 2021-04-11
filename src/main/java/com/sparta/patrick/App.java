package com.sparta.patrick;

import com.sparta.patrick.View.Starter;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

/**
 *
 */
public class App {
    public static final Logger logger = LogManager.getLogger(App.class);

    public static void main(String[] args) {
        Starter.start();
    }
}
