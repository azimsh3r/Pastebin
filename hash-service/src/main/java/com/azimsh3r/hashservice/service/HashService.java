package com.azimsh3r.hashservice.service;

import org.springframework.stereotype.Service;

import java.security.MessageDigest;
import java.util.Base64;

@Service
public class HashService {
    //TODO: add more functionality if needed

    public String generateHash(String text) {
        try {
            MessageDigest digest = MessageDigest.getInstance("SHA-256");
            byte[] hashBytes = digest.digest(text.getBytes());

            String base64Hash = Base64.getUrlEncoder()
                    .withoutPadding()
                    .encodeToString(hashBytes);

            return base64Hash.substring(0, 8);
        } catch (Exception e) {
            throw new RuntimeException("Error generating Base64 hash", e);
        }
    }
}
