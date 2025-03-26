package com.maverick.probe.service;

import com.maverick.probe.model.Coordiante;
import com.maverick.probe.model.Direction;

public interface NavigationService {

    //Return new Cooridates of the probe after move.
    Coordiante move(boolean forward);

    Direction turn(boolean left);

    //Return new Coordinates for move operation
    Coordiante getNextCoordinate(boolean forward);

    Coordiante getCurrentPosition();
}
