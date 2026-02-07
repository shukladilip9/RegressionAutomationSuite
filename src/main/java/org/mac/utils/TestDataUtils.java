package org.mac.utils;

import com.fasterxml.jackson.databind.JsonNode;
import com.fasterxml.jackson.databind.ObjectMapper;

import java.io.InputStream;

public final class TestDataUtils {

    private static JsonNode testData;

    static {
        try {
            ObjectMapper mapper = new ObjectMapper();
            InputStream is = TestDataUtils.class
                    .getClassLoader()
                    .getResourceAsStream("testdata/users.json");

            if (is == null) {
                throw new RuntimeException("Test data file not found: testdata/users.json");
            }

            testData = mapper.readTree(is);

        } catch (Exception e) {
            throw new RuntimeException("Failed to load test data", e);
        }
    }

    private TestDataUtils() {} // Prevent object creation

    public static String getUsername(String role) {
        return testData.get(role).get("username").asText();
    }

    public static String getPassword(String role) {
        return testData.get(role).get("password").asText();
    }

    public static JsonNode getUser(String role) {
        return testData.get(role);
    }
}