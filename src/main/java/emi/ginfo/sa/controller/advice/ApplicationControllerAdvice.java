package emi.ginfo.sa.controller.advice;

import emi.ginfo.sa.dto.ErroEntity;
import jakarta.persistence.EntityNotFoundException;
import org.springframework.web.bind.annotation.*;

import static org.springframework.http.HttpStatus.BAD_REQUEST;

@ControllerAdvice
public class ApplicationControllerAdvice {

    @ResponseStatus(BAD_REQUEST)
    @ExceptionHandler(EntityNotFoundException.class)
    public @ResponseBody ErroEntity handleEception(EntityNotFoundException exception){
        return  new ErroEntity(null, exception.getMessage());
    }
}
