package com.maverick.probe.model;

public enum Direction {
    NORTH,
    EAST,
    SOUTH,
    WEST;

    public Direction getLeft(){
        return getLeftOrRight(true);
    }

    public Direction getRight(){
        return getLeftOrRight(false);
    }

    private Direction getLeftOrRight(boolean left){
        int correction;
        if(left){
            correction = -1;
        } else {
            correction = 1;
        }
        int newDirection = (this.ordinal() + correction + Direction.values().length)% Direction.values().length;
        return Direction.values()[newDirection];

    }
}
