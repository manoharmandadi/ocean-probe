package com.maverick.probe.controller;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/navigate")
public class ProbeController {

    private static final Logger logger = LoggerFactory.getLogger(ProbeController.class);

    @PostMapping("/move")
    @ResponseStatus(HttpStatus.CREATED)
    public void move(@RequestParam(value = "forward", defaultValue = "true") boolean forward){
        logger.debug("Invoked move command, Forward: "+forward);

    }

}
