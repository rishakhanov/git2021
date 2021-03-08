package com.epam.projects.kidsshop.log4j2;

import org.apache.logging.log4j.Level;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

public class LogMain {
    static Logger logger = LogManager.getLogger();
    public static void main(String[] args) {
        logger.info("info");
        try{
            throw new RuntimeException("Exception 1");
        } catch (RuntimeException e) {
            logger.log(Level.ERROR, "runtime", e);
        }
    }
}
