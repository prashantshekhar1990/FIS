package core;

public enum PropertyKey {
    ENV("env"),
    BROWSER("browser");

    private String key;
    PropertyKey(String property) {
        this.key = property;

    }
}
