package com.example.testingweb;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

// MatchingController.java
@RestController
@RequestMapping("/matching")
public class MatchingController {
    @Autowired
    private MatchingService matchingService;

    @PostMapping("/match")
    public ResponseEntity<String> matchUsers(@RequestBody List<User> users) {
        if (users.size() != 2) {
            return ResponseEntity.badRequest().body("Exactly two users are required for matching.");
        }

        User user1 = users.get(0);
        User user2 = users.get(1);

        int matchingScore = matchingService.calculateMatchingScore(user1, user2);

        return ResponseEntity.ok("Matching score: " + matchingScore);
    }
}

