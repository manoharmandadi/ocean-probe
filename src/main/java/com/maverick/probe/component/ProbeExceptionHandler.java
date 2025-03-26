package com.maverick.probe.component;

import com.maverick.probe.exception.OutsideGridFloorException;
import com.maverick.probe.exception.UnNavigablePositionException;
import com.maverick.probe.model.ErrorResponse;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.ResponseStatus;

@ControllerAdvice
public class ProbeExceptionHandler {

    @ExceptionHandler(value = OutsideGridFloorException.class)
    @ResponseStatus(HttpStatus.BAD_REQUEST)
    public ResponseEntity<ErrorResponse> handleOutsideRange(OutsideGridFloorException ex){
        return ResponseEntity.status(HttpStatus.BAD_REQUEST).body(
                new ErrorResponse(OutsideGridFloorException.class.getName(), ex.getMessage()));
    }

    @ExceptionHandler(value = UnNavigablePositionException.class)
    @ResponseStatus(HttpStatus.BAD_REQUEST)
    public ResponseEntity<ErrorResponse> handleUnNavigablePosition(UnNavigablePositionException ex){
        return ResponseEntity.status(HttpStatus.BAD_REQUEST)
                .body(new ErrorResponse(UnNavigablePositionException.class.getName(), ex.getMessage()));
    }
}
