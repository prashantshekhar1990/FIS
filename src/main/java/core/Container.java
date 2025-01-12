package core;

import java.util.HashMap;
import java.util.Map;

public class Container {
    private final Map<String, String> container = new HashMap<>();

    public Map<String, String> getContainer() {
        return container;
    }

    public String get(String key) {
        return container.get(key);
    }

    public void put(String key, String value) {
        container.put(key, value);
    }

}
