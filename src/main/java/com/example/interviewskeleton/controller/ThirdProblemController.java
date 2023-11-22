package com.example.interviewskeleton.controller;

import com.example.interviewskeleton.service.ThirdProblemService;
import lombok.AllArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;


@RestController
@AllArgsConstructor
public class ThirdProblemController {

    private ThirdProblemService service;

    @GetMapping("/greet/{name}")
    public ResponseEntity<String> message(@PathVariable("name") String name, @RequestParam("locale") String locale) {
        String message = service.sendMessage(locale);

        if (!message.contains("{name}"))
            return ResponseEntity.badRequest().body(message);

        return ResponseEntity.ok(message.replace("{name}", name));
    }
}
