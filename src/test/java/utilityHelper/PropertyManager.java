package utilityHelper;

import java.io.FileInputStream;
import java.io.IOException;
import java.util.Properties;

public class PropertyManager {
    private static final String getUserDirectory = System.getProperty("user.dir");
    private static final String configPropertiesPath = getUserDirectory + "\\src\\test\\java\\utilityHelper\\config.properties";

    public String getSiteUrl() throws IOException {
        Properties prop = new Properties();
        FileInputStream input = new FileInputStream(configPropertiesPath);
        prop.load(input);
        return System.getProperty("webUrl", prop.getProperty("url"));
    }

    public String getBrowser() throws IOException {
        Properties prop = new Properties();
        FileInputStream input = new FileInputStream(configPropertiesPath);
        prop.load(input);
        return System.getProperty("Browser", prop.getProperty("browser"));
    }

}
