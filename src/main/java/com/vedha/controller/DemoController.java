package com.vedha.controller;

import lombok.extern.slf4j.Slf4j;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import java.util.Map;

@Slf4j // Lombok annotation to generate SLF4J logger
@RestController
@RequestMapping("/app")
public class DemoController {

    // Spring Boot Internally uses SLF4J and Logback for logging
    // SLF4J is like interface, and Logback, Log4j is a like implementation
    private static final Logger logger = LoggerFactory.getLogger(DemoController.class);

    @GetMapping(value = "/log", produces = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity<Map<String, String>> log(@RequestParam("name") String name) {

        logger.trace("Hello, {}", name);
        logger.trace("This is a TRACE message.");
        logger.debug("This is a DEBUG message.");
        logger.info("This is an INFO message.");
        logger.warn("This is a WARN message.");
        logger.error("This is an ERROR message.");


        return ResponseEntity.status(HttpStatus.OK).body(Map.of("message", "Logged successfully"));
    }

    @GetMapping(value = "/lombok", produces = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity<Map<String, String>> lombok(@RequestParam("name") String name) {

        log.warn("Hello, {}", name);
        log.trace("This is a TRACE message.");
        log.debug("This is a DEBUG message.");
        log.info("This is an INFO message.");
        log.warn("This is a WARN message.");
        log.error("This is an ERROR message.");

        return ResponseEntity.status(HttpStatus.OK).body(Map.of("message", "Logged successfully")) ;
    }

}
