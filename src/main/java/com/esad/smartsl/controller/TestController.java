package com.esad.smartsl.controller;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/smartsl")
public class TestController {

    private static final Logger logger = LoggerFactory.getLogger(TestController.class);


    @GetMapping("/test")
    public void test() {
        logger.info("Inside TestController.......");
    }

}
