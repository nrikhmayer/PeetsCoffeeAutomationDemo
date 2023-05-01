package framework;
import java.util.HashMap;
import java.util.Map;

public enum BrowserType {
    CHROME,
    FIREFOX;

    private static final Map<String, BrowserType> browsersMap = new HashMap<String, BrowserType>();

    static {
        browsersMap.put("firefox", BrowserType.FIREFOX);
        browsersMap.put("gc", BrowserType.CHROME);
    }

    public static BrowserType Browser(String name) {
        BrowserType browserType = browsersMap.get(name.toLowerCase().trim());
        if (browserType == null) {
            try {
                throw new Exception("Unknown browser [" + name + "]. ");
            } catch (Exception e) {
                throw new RuntimeException(e);
            }
        }
        return browserType;
    }
}