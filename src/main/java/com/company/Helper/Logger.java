package com.company.Helper;

import com.company.Main;
import org.apache.logging.log4j.LogManager;

public class Logger {
    public static org.apache.logging.log4j.Logger logger = LogManager.getLogger(Main.class);

    public static void Info(Object a){
        logger.info(a);
    }
    public static void Error(Object error){
        logger.error(error);
    }
    public static void Debug(Object debug){
        logger.debug(debug);
    }

}
