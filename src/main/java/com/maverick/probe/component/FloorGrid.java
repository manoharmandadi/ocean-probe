package com.maverick.probe.component;

import com.maverick.probe.exception.OutsideGridFloorException;
import com.maverick.probe.model.Coordiante;
import com.maverick.probe.model.GridElement;
import jakarta.annotation.PostConstruct;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Component;

import java.util.stream.IntStream;

@Component
public class FloorGrid {

    @Value("${ocean.floor.dimension.x}")
    private int x;

    @Value("${ocean.floor.dimension.y}")
    private int y;

    private GridElement[][] grid;

    @PostConstruct
    public void initGrid(){
        grid = new GridElement[x][y];
        IntStream.range(0,x).forEach(x -> {
                    IntStream.range(0, y).forEach(y -> {
                        grid[x][y] = new GridElement(true);
                    });
                }
        );
    }

    public GridElement getElement(Coordiante coordiante){
        if( coordiante.getX() >=0 && x > coordiante.getX() && coordiante.getY() >=0 && y > coordiante.getY()){
            return grid[coordiante.getX()][coordiante.getY()];
        } else {
            throw new OutsideGridFloorException("Given coordinate x:"+coordiante.getX()+" ,y:"+coordiante.getY()+" is outside grid.");
        }
    }


}
