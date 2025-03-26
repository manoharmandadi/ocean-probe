package com.maverick.probe.component;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.junit.jupiter.MockitoExtension;

@ExtendWith(MockitoExtension.class)
public class FloorGridTest {

    FloorGrid grid;

    @Test
    public void testGridInitialization(){
        Assertions.assertNotNull(grid.getElement(0,0));
    }
}
