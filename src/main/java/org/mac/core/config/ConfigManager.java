package org.mac.core.config;

import java.io.IOException;
import java.io.InputStream;
import java.util.Properties;

public class ConfigManager {

    private static final Properties properties = new Properties();

    static {
        try (InputStream input = ConfigManager.class
                .getClassLoader()
                .getResourceAsStream("config.properties")) {

            if (input == null) {
                throw new RuntimeException("config.properties file not found in resources folder");
            }

            properties.load(input);

        } catch (IOException e) {
            throw new RuntimeException("Failed to load config.properties", e);
        }
        System.out.println("CONFIG LOADED");
        System.out.println("Browser from config = " + getBrowser());
    }

    // 🌍 Common
    public static String getBaseUrl() {
        return properties.getProperty("base.url");
    }

    public static String getBrowser() {
        return properties.getProperty("browser", "chrome");
    }

    public static boolean isHeadless() {
        return Boolean.parseBoolean(properties.getProperty("headless", "false"));
    }

    public static int getTimeout() {
        return Integer.parseInt(properties.getProperty("timeout", "10"));
    }

    // ☁️ BrowserStack Specific
    public static String getBsBrowser() {
        return properties.getProperty("bs.browser", "Chrome");
    }

    public static String getBsBrowserVersion() {
        return properties.getProperty("bs.browser.version", "latest");
    }

    public static String getBsOS() {
        return properties.getProperty("bs.os", "Windows");
    }

    public static String getBsOSVersion() {
        return properties.getProperty("bs.os.version", "11");
    }
}