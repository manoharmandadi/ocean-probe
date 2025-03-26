package com.maverick.probe.service;

import com.maverick.probe.component.FloorGrid;
import com.maverick.probe.model.Coordiante;
import com.maverick.probe.model.Direction;
import com.maverick.probe.model.GridElement;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.mockito.junit.jupiter.MockitoExtension;
import org.springframework.test.util.ReflectionTestUtils;

@ExtendWith(MockitoExtension.class)
public class NavigationServiceTest {

    @InjectMocks
    NavigationService navigationService = new NavigationServiceImpl();

    @Mock
    FloorGrid grid;

    @BeforeEach
    public void initNavigationService(){
        ReflectionTestUtils.setField(navigationService, "x", 5);
        ReflectionTestUtils.setField(navigationService, "y", 5);
        ReflectionTestUtils.setField(navigationService, "direction", Direction.NORTH);
    }

    @Test
    public void testMoveForward(){
        Mockito.when(grid.getElement(Mockito.any(Coordiante.class))).thenReturn(new GridElement(true));
        Assertions.assertEquals(new Coordiante(5, 6), navigationService.move(true));
    }

    @Test
    public void testMoveBackward(){
        Mockito.when(grid.getElement(Mockito.any(Coordiante.class))).thenReturn(new GridElement(true));
        Assertions.assertEquals(new Coordiante(5, 4), navigationService.move(false));
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

    @Test
    public void testGetCurrentPosition(){
        Assertions.assertEquals(new Coordiante(5,5), navigationService.getCurrentPosition());
    }

    @Test
    public void testTurnLeft(){
        Assertions.assertEquals(Direction.WEST, navigationService.turn(true));
    }

    @Test
    public void testTurnRight(){
        Assertions.assertEquals(Direction.EAST, navigationService.turn(false));
    }

}
