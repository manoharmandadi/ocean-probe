package com.maverick.probe.model;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

public class DirectionTest {

    @Test
    public void testGetLeft(){
        Assertions.assertEquals(Direction.SOUTH, Direction.WEST.getLeft());
        Assertions.assertEquals(Direction.WEST, Direction.NORTH.getLeft());
        Assertions.assertEquals(Direction.NORTH, Direction.EAST.getLeft());
        Assertions.assertEquals(Direction.EAST, Direction.SOUTH.getLeft());

    }
}
