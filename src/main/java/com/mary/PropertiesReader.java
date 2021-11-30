package com.mary;

import java.io.FileReader;
import java.util.Properties;

public class PropertiesReader {

    private static FileReader reader;
    private static Properties p;

    static {
        try {
            reader = new FileReader("src/main/resources/testdata.properties");
            p =  new Properties();
            p.load(reader);
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    public static String getValue(String key) {
        return p.getProperty(key);
    }
}
