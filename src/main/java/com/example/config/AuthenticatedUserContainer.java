package com.example.config;

import org.springframework.stereotype.Component;

import java.util.HashMap;
import java.util.Map;

@Component
public class AuthenticatedUserContainer {
    private static final MapThreadLocal<String> authenticatedUser = new MapThreadLocal<>();

    public static void setAuthenticatedUser(String token, String num) {
        Map<String, String> map = authenticatedUser.get();
        map.put(token, num);
        authenticatedUser.set(map);
    }

    public static String getAuthenticatedUser(String token) {
        Map<String, String> map = authenticatedUser.get();
        if (map != null) {
            return map.get(token);
        }
        return null;
    }

    public static void removeAuthenticatedUser(String token) {
        authenticatedUser.removeValue(token);
    }

    public static void clearAuthenticatedUser() {
        authenticatedUser.remove();
    }
}