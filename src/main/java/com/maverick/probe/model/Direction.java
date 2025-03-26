package com.maverick.probe.model;

public enum Direction {
    NORTH,
    EAST,
    SOUTH,
    WEST;

    public Direction getLeft(){
        int newDirection = (this.ordinal()-1 + Direction.values().length)% Direction.values().length;
        return Direction.values()[newDirection];
    }
}
