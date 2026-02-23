package com.hirehub.hirehub.ai;

import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;
import org.springframework.http.*;
import java.util.HashMap;
import java.util.Map;

@Service
public class AIMatchingService {

    private final String FLASK_URL = "http://localhost:5001/match";

    public double getMatchScore(String candidateSkills, String jobSkills) {
        RestTemplate restTemplate = new RestTemplate();

        Map<String, String> request = new HashMap<>();
        request.put("candidateSkills", candidateSkills);
        request.put("jobSkills", jobSkills);

        HttpHeaders headers = new HttpHeaders();
        headers.setContentType(MediaType.APPLICATION_JSON);

        HttpEntity<Map<String, String>> entity = new HttpEntity<>(request, headers);

        ResponseEntity<Map> response = restTemplate.postForEntity(FLASK_URL, entity, Map.class);

        Map body = response.getBody();
        return ((Number) body.get("matchScore")).doubleValue();
    }
}
