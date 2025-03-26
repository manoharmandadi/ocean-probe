package com.maverick.probe.controller;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/navigate")
public class ProbeController {

    @PostMapping("/move")
    @ResponseStatus(HttpStatus.CREATED)
    public void move(@RequestParam(value = "forward", defaultValue = "true") boolean forward){

    }

}
