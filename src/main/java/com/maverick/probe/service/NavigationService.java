package com.maverick.probe.service;

import com.maverick.probe.model.Coordiante;

public interface NavigationService {

    //Return new Cooridates of the probe after move.
    Coordiante move(boolean forward);

    //Return new Coordinates for move operation
    Coordiante getNextCoordinate(boolean forward);

    Coordiante getCurrentPosition();
}
