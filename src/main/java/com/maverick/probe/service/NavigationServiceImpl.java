package com.maverick.probe.service;

import com.maverick.probe.model.Coordiante;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Service;

@Service
public class NavigationServiceImpl implements NavigationService{

    private static final Logger logger = LoggerFactory.getLogger(NavigationServiceImpl.class);

    @Value("${probe.initial.x}")
    private int x;

    @Value("${probe.initial.y}")
    private int y;

    @Override
    public Coordiante move(boolean forward) {
        logger.debug("Moving from "+x+" ,"+y);

        return new Coordiante(0, 0);
    }
}
