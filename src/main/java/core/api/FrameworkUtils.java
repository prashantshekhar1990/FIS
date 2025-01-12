package core.api;

import java.io.FileInputStream;
import java.io.IOException;
import java.util.Properties;

public class FrameworkUtils {
    public static String loadPropertyFromXML(String filePath, String propertyKey) {
        Properties properties = new Properties();

        try (FileInputStream fileInputStream = new FileInputStream(filePath)) {
            // Load properties from XML file
            properties.loadFromXML(fileInputStream);

            // Retrieve the value of the specified property
            return properties.getProperty(propertyKey);
        } catch (IOException e) {
            e.printStackTrace();
            return null;
        }
    }
}
