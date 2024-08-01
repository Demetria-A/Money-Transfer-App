package com.techelevator.tenmo.services;

import com.techelevator.tenmo.model.User;
import com.techelevator.util.BasicLogger;
import org.springframework.http.ResponseEntity;
import org.springframework.web.client.ResourceAccessException;
import org.springframework.web.client.RestClientResponseException;
import org.springframework.web.client.RestTemplate;


public class UserService {
    public static String API_BASE_URL = "http://localhost:8080/tenmo_user";
    private final RestTemplate restTemplate = new RestTemplate();

    public User[] getUsers() {
        User[] user = null;
        try {
            user = restTemplate.getForObject(API_BASE_URL, User[].class);
        } catch (RestClientResponseException e) {
            BasicLogger.log(e.getRawStatusCode() + " : " + e.getStatusText());
        } catch (ResourceAccessException e) {
            BasicLogger.log(e.getMessage());
        }
        return user;
    }
}