package com.maverick.probe.service;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

public class NavigationServiceTest {

    private NavigationService navigationService;

    @Test
    public void testMoveForward(){
        Assertions.assertNotNull(navigationService.move(true));

    }
}
