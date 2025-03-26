package com.maverick.probe.service;

import com.maverick.probe.component.FloorGrid;
import com.maverick.probe.exception.UnNavigablePositionException;
import com.maverick.probe.model.Coordiante;
import com.maverick.probe.model.Direction;
import com.maverick.probe.model.GridElement;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
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

    @Autowired
    private FloorGrid grid;

    @Override
    public Coordiante move(boolean forward) {
        logger.debug("Moving "+(forward? "forward": "backward")+ ". Facing :"+direction);
        Coordiante newPosition = getNextCoordinate(forward);
        GridElement nextElement = grid.getElement(newPosition);
        if(nextElement.isNavigable()){
            this.x = newPosition.getX();
            this.y = newPosition.getY();
            logger.info("Moved to position. X:"+x+" ,Y:"+y);
        } else {
            throw new UnNavigablePositionException("Give Coordinate are not navigable. X:"+newPosition.getX()+" ,Y:"+newPosition.getY());
        }
        return newPosition;
    }

    @Override
    public Direction turn(boolean left) {
        if(left){
            direction = direction.getLeft();
        } else {
            direction = direction.getRight();
        }
        logger.info("Turning left:"+ left+". New Direction: "+direction);
        return direction;
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

    @Override
    public Coordiante getCurrentPosition() {
        return new Coordiante(x, y);
    }
}
