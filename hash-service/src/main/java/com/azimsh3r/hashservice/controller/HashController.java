package com.azimsh3r.hashservice.controller;

import com.azimsh3r.hashservice.service.HashService;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.Map;

@RestController
@RequestMapping("/hash")
public class HashController {
    private final HashService hashService;

    public HashController(HashService hashService) {
        this.hashService = hashService;
    }

    @PostMapping
    public ResponseEntity<String> generateHash(@RequestBody Map<String, String> requestBody) {
        String text = requestBody.get("text");
        if (text == null || text.trim().isEmpty()) {
            return ResponseEntity.badRequest().body("The value for key \"text\" should not be null or empty");
        }
        String hash = hashService.generateHash(text);
        return ResponseEntity.ok(hash);
    }
}
