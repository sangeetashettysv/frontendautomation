package com.cgm.frontend.utils;

import java.io.IOException;
import java.io.InputStream;
import java.util.Properties;

public class ConfigReader {

    private static Properties properties = new Properties();

    static {
        try (InputStream input = ConfigReader.class.getClassLoader()
                .getResourceAsStream("config.properties")) {
            if (input == null) {
                throw new RuntimeException("config.properties not found in resources folder!");
            }
            properties.load(input);
        } catch (IOException e) {
            throw new RuntimeException("Failed to load config.properties", e);
        }
    }

    // Get the current environment (default to QA)
    public static String getEnvironment() {
        return properties.getProperty("env", "qa").toLowerCase();
    }

    // Get URL for current environment
    public static String getEnvironmentUrl() {
        String env = getEnvironment();
        String urlKey = env + ".url"; // matches qa.url, staging.url, prod.url
        String url = properties.getProperty(urlKey);
        if (url == null || url.isEmpty()) {
            throw new RuntimeException("Base URL not specified for environment: " + env);
        }
        return url;
    }

    // Get browser (default to Chrome)
    public static String getBrowser() {
        return properties.getProperty("browser", "chrome");
    }
}