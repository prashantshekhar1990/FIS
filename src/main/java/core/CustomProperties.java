package core;

import java.io.*;
import java.util.HashMap;
import java.util.Map;
import java.util.Properties;

public class CustomProperties {
    public static final String workspaceDirPath = System.getProperty("user.dir");

    public static Map<String, String> getProperties() throws IOException {
        return readPropertiesFromXML("properties.xml");
    }

    private static Map<String, String> readPropertiesFromXML(String xmlFileName) throws IOException {
        File file = new File(workspaceDirPath + String.format("%1$ssrc%1$smain%1$sresources%1$s%2$s", File.separator, xmlFileName));
        InputStream in = new FileInputStream(file);
        Properties properties = new Properties();
        properties.loadFromXML(in);
        return propAsMap(properties);
    }

    private static Map<String, String> propAsMap(Properties properties) {
        Map<String, String> map = new HashMap<>();
        for (final String name : properties.stringPropertyNames()) {
            map.put(name, properties.getProperty(name).trim());
        }
        return map;
    }
}
