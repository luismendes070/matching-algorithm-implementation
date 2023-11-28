package com.example.testingweb;

import org.springframework.stereotype.Service;

import java.util.List;

// MatchingService.java
@Service
public class MatchingService {
    public int calculateMatchingScore(User user1, User user2) {
        List<String> interests1 = user1.getInterests();
        List<String> interests2 = user2.getInterests();

        // Calculate the number of common interests
        int commonInterests = (int) interests1.stream()
                .filter(interests2::contains)
                .count();

        // You can customize the matching algorithm further based on your requirements

        return commonInterests;
    }
}

