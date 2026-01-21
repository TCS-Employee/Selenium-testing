package automation;

import java.io.FileInputStream;
import java.util.Properties;

public class ConfigReader {

    private static Properties prop;

    static {
        try {
            String path = System.getProperty("user.dir")
                    + "/src/main/resources/config.properties";

            FileInputStream fis = new FileInputStream(path);
            prop = new Properties();
            prop.load(fis);

        } catch (Exception e) {
            System.out.println("Failed to load config.properties");
            e.printStackTrace();
        }
    }

    public static String get(String key) {
        return prop.getProperty(key);
    }
}
