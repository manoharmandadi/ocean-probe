package com.maverick.probe.model;

import lombok.Data;

@Data
public class GridElement {

    private boolean isNavigable;

    //Incase Floor is used by multiple probes
    //private boolean isOccupied;

    public GridElement(boolean isNavigable){
        this.isNavigable = isNavigable;
    }
}
