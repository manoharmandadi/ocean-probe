package com.maverick.probe.component;

import com.maverick.probe.model.Coordiante;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.junit.jupiter.MockitoExtension;
import org.springframework.test.util.ReflectionTestUtils;

import java.util.stream.IntStream;

@ExtendWith(MockitoExtension.class)
public class FloorGridTest {

    static FloorGrid grid = new FloorGrid();

    @BeforeAll
    public static void initGrid(){
        ReflectionTestUtils.setField(grid, "x", 10);
        ReflectionTestUtils.setField(grid, "y", 10);
        grid.initGrid();

    }

    @Test
    public void testGridInitialization(){
        IntStream.range(0,10).forEach(x -> {
            IntStream.range(0, 10).forEach(y -> {
                Assertions.assertNotNull(grid.getElement(new Coordiante(x, y)));
            });
        });
    }

    @Test
    public void getElement(){
        Assertions.assertNotNull(grid.getElement(new Coordiante(0, 0)));
    }
}
