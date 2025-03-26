package com.maverick.probe.service;

import com.maverick.probe.model.Coordiante;
import com.maverick.probe.model.Direction;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Service;

@Service
public class NavigationServiceImpl implements NavigationService{

    private static final Logger logger = LoggerFactory.getLogger(NavigationServiceImpl.class);

    @Value("${probe.initial.x}")
    private int x;

    @Value("${probe.initial.y}")
    private int y;

    @Value("${probe.initial.direction}")
    private Direction direction;

    @Override
    public Coordiante move(boolean forward) {
        logger.debug("Moving "+(forward? "forward": "backward")+ ". Facing :"+direction);

        return new Coordiante(0, 0);
    }

    public Coordiante getNextCoordinate(boolean forward){
        int newX = x;
        int newY = y;
        int move =  (forward)? 1: -1;
        switch (direction){
            case SOUTH -> newY = y - move;
            case WEST -> newX = x - move;
            case NORTH -> newY = y + move;
            case EAST -> newX = x + move;
        }
        return new Coordiante(newX, newY);
    }
}
