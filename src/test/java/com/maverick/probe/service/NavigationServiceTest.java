package com.maverick.probe.service;

import com.maverick.probe.model.Coordiante;
import com.maverick.probe.model.Direction;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.springframework.test.util.ReflectionTestUtils;

public class NavigationServiceTest {

    private NavigationService navigationService = new NavigationServiceImpl();

    @BeforeEach
    public void initNavigationService(){
        ReflectionTestUtils.setField(navigationService, "x", 5);
        ReflectionTestUtils.setField(navigationService, "y", 5);
        ReflectionTestUtils.setField(navigationService, "direction", Direction.NORTH);
    }

    @Test
    public void testMoveForward(){
        Assertions.assertNotNull(navigationService.move(true));

    }

    @Test
    public void getNextCoordinate(){
        Assertions.assertEquals(new Coordiante(5, 6), navigationService.getNextCoordinate(true));
        Assertions.assertEquals(new Coordiante(5, 4), navigationService.getNextCoordinate(false));
    }

    @Test
    public void getNextCoordinateEast(){
        ReflectionTestUtils.setField(navigationService, "direction", Direction.EAST);
        Assertions.assertEquals(new Coordiante(6, 5), navigationService.getNextCoordinate(true));
        Assertions.assertEquals(new Coordiante(4, 5), navigationService.getNextCoordinate(false));

    }
    @Test
    public void getNextCoordinateSouth(){
        ReflectionTestUtils.setField(navigationService, "direction", Direction.SOUTH);
        Assertions.assertEquals(new Coordiante(5, 4), navigationService.getNextCoordinate(true));
        Assertions.assertEquals(new Coordiante(5, 6), navigationService.getNextCoordinate(false));

    }
    @Test
    public void getNextCoordinateWest(){
        ReflectionTestUtils.setField(navigationService, "direction", Direction.WEST);
        Assertions.assertEquals(new Coordiante(4, 5), navigationService.getNextCoordinate(true));
        Assertions.assertEquals(new Coordiante(6, 5), navigationService.getNextCoordinate(false));

    }


}
