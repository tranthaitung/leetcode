package com.demo.leetcode.controller;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/leetcode")
public class HealthCheckController {
    @GetMapping("/healthcheck")
    public String healthCheck(){
        return "Service is healthy";
    }
}
