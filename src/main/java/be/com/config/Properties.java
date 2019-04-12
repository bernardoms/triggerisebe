package be.com.config;

import java.io.FileNotFoundException;
import java.io.InputStream;

public class Properties {
    public static java.util.Properties getProperties()  {
        InputStream inputStream;
        java.util.Properties prop = new java.util.Properties();
        try {
            inputStream = CassandraConfig.class.getClassLoader().getResourceAsStream("application.properties");
            if (inputStream != null) {
                prop.load(inputStream);
            } else {
                throw new FileNotFoundException("property file application.properties not found in the classpath");
            }
        }catch (Exception e){
            System.out.println("Exception: " + e);
        }
        return prop;
    }
}
