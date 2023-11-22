package com.example.interviewskeleton.service;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Service;

import java.time.LocalTime;

@Service
public class ThirdProblemService {

    @Value("${greeting.morning.en}")
    private String morningEnMessage;
    @Value("${greeting.morning.es}")
    private String morningEsMessage;
    @Value("${greeting.afternoon.en}")
    private String afternoonEnMessage;
    @Value("${greeting.afternoon.es}")
    private String afternoonEsMessage;
    @Value("${greeting.evening.en}")
    private String eveningEnMessage;
    @Value("${greeting.evening.es}")
    private String eveningEsMessage;
    public String sendMessage(String locale) {
        String s;
        LocalTime now = LocalTime.now();

        if (!locale.equals("en") && !locale.equals("es"))
            return "Wrong locale param. Supported values: en/es";
        if (now.isAfter(LocalTime.MIDNIGHT) && now.isBefore(LocalTime.NOON))
            s = locale.equals("en") ? morningEnMessage : morningEsMessage;
        else if (now.isAfter(LocalTime.NOON) && now.isBefore(LocalTime.of(18, 0)))
            s = locale.equals("en") ? afternoonEnMessage : afternoonEsMessage;
        else s = locale.equals("en") ? eveningEnMessage : eveningEsMessage;

        return s;
    }
}
