package com.maverick.probe.model;

import java.util.Objects;

public class Coordiante {

    private int x;

    private int y;

    public Coordiante(int x, int y){
        this.x = x;
        this.y = y;
    }

    public int getX() {
        return x;
    }

    public int getY() {
        return y;
    }

    @Override
    public boolean equals(Object o) {
        if (!(o instanceof Coordiante that)) return false;
        return x == that.x && y == that.y;
    }

    @Override
    public int hashCode() {
        return Objects.hash(x, y);
    }


}
