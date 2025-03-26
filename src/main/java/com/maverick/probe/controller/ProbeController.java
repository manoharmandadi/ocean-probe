package com.maverick.probe.controller;

import com.maverick.probe.model.Coordiante;
import com.maverick.probe.service.NavigationService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/navigate")
public class ProbeController {

    private static final Logger logger = LoggerFactory.getLogger(ProbeController.class);

    @Autowired
    private NavigationService navigationService;

    @PostMapping("/move")
    @ResponseStatus(HttpStatus.CREATED)
    public void move(@RequestParam(value = "forward", defaultValue = "true") boolean forward){
        logger.debug("Invoked move command, Forward: "+forward);

    }

    @GetMapping("/position")
    @ResponseStatus(HttpStatus.OK)
    public Coordiante getPosition(){
        return navigationService.getCurrentPosition();
    }

}
