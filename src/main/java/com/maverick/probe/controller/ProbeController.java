package com.maverick.probe.controller;

import com.maverick.probe.model.Coordiante;
import com.maverick.probe.model.Direction;
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
    public Coordiante move(@RequestParam(value = "forward", defaultValue = "true") boolean forward){
        logger.debug("Invoked move command, Forward: "+forward);
        return navigationService.move(forward);
    }

    @PostMapping("/turn")
    @ResponseStatus(HttpStatus.CREATED)
    public Direction turn(@RequestParam(value = "left") boolean left){
        logger.debug("Invoked turn command, Left: "+left);
        return navigationService.turn(left);
    }

    @GetMapping("/position")
    @ResponseStatus(HttpStatus.OK)
    public Coordiante getPosition(){
        return navigationService.getCurrentPosition();
    }

}
