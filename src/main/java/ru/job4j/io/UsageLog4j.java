package ru.job4j.io;

import org.apache.log4j.BasicConfigurator;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
public class UsageLog4j {

    /**
     *         Вывод сообщений в логе.
     *         LOG.trace("trace message");
     *         LOG.debug("debug message");
     *         LOG.info("info message");
     *         LOG.warn("warn message");
     *         LOG.error("error message");
     */

    private static final Logger LOG = LoggerFactory.getLogger(UsageLog4j.class.getName());

    public static void main(String[] args) {
        BasicConfigurator.configure();
        String name = "Roman Manco";
        int age = 25;
        boolean male = true;
        char charValue = 1234;
        short shortValue = 12345;
        long longValue = 144999;
        float floatValue = 235.6f;
        double doubleValue = 65.4;
        byte byteValue = 3;
        LOG.debug("User info name : {}, age : {}, male : {}, charValue : {}, shortValue : {}, longValue : {}, floatValue : {}, doubleValue : {}, byteValue : {}",
                name, age, male, charValue, shortValue, longValue, floatValue, doubleValue, byteValue);
    }
}
