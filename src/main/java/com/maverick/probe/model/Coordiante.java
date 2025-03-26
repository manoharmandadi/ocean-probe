package com.maverick.probe.model;

import lombok.Data;

@Data
public class Coordiante {

    private int x;

    private int y;

    public Coordiante(int x, int y){
        this.x = x;
        this.y = y;
    }
}
