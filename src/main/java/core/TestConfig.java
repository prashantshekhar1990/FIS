package core;

import java.io.IOException;
import java.util.Map;

public class TestConfig {
    private Map<String, String> properties;
    private String env;
    private String baseURL;
    private String driverPath;

    public String getDriverName() {
        return driverName;
    }

    public void setDriverName(String driverName) {
        this.driverName = driverName;
    }

    public String getDriverPath() {
        return driverPath;
    }

    public void setDriverPath(String driverPath) {
        this.driverPath = driverPath;
    }

    private String driverName;

    public TestConfig() throws IOException {
        setProperties();
        setConfiguration();
    }

    private void setProperties() throws IOException {
        if (properties == null) {
            properties = CustomProperties.getProperties();
        }
    }

    private void setConfiguration() {
        setBaserURL();
    }

    public String getEnv() {
        return env;
    }

    private void setBaserURL() {
        this.env = getPropertyByKey(PropertyKey.ENV);
        this.baseURL = "https://" + env;
    }

    public String getPropertyByKey(PropertyKey key) {
        return properties.get(key.toString());
    }
}
