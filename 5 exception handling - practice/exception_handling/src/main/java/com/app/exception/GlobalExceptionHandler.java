package com.app.exception;

import com.app.dto.error.ErrorDTO;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.http.converter.HttpMessageNotWritableException;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestControllerAdvice;
import org.springframework.web.servlet.NoHandlerFoundException;

import java.util.Date;
import java.util.HashMap;
import java.util.Map;

@RestControllerAdvice
public class GlobalExceptionHandler {

    /*cunado se lanza esta exepcion se dispara este metodp
    y para pasar mas de una excepcion de pone entre {} y seguidp de ","
    {ArithmeticException.class, etc, etc, ect}*/
    @ExceptionHandler({ArithmeticException.class})
    public ResponseEntity<ErrorDTO> divisionByZero(ArithmeticException ex) {
        ErrorDTO errorDTO = new ErrorDTO();
        errorDTO.setDate(new Date());
        errorDTO.setError("Error division por cero");
        errorDTO.setMessage(ex.getMessage());
        errorDTO.setStatus(HttpStatus.INTERNAL_SERVER_ERROR.value());
//        return ResponseEntity.internalServerError().body(errorDTO);
        return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR.value()).body(errorDTO);
    }

    //Otra forma de tratar las excepciones
    @ExceptionHandler(NumberFormatException.class)
    @ResponseStatus(HttpStatus.INTERNAL_SERVER_ERROR) //-> importante
    public Map<String, String> numberFoundEx(NumberFormatException ex) {
        Map<String, String> error = new HashMap<>();
        error.put("date", new Date().toString());
        error.put("error", "solo debes pasar numeros");
        error.put("message", ex.getMessage());
        error.put("status", HttpStatus.INTERNAL_SERVER_ERROR.toString());
        return error;
    }

    @ExceptionHandler(NoHandlerFoundException.class)
    public ResponseEntity<ErrorDTO> notFoundEx(NoHandlerFoundException ex) {
        ErrorDTO errorDTO = new ErrorDTO();
        errorDTO.setDate(new Date());
        errorDTO.setError("Ruta api no encontrada");
        errorDTO.setMessage(ex.getMessage());
        errorDTO.setStatus(HttpStatus.INTERNAL_SERVER_ERROR.value());
        return ResponseEntity.status(HttpStatus.NOT_FOUND.value()).body(errorDTO);
    }

//    @ExceptionHandler({NullPointerException.class, HttpMessageNotWritableException.class, UserNotFoundException.class})
@ExceptionHandler(UserNotFoundException.class)
@ResponseStatus(HttpStatus.INTERNAL_SERVER_ERROR) //-> importante
    public Map<String, String> userNotFoundEx(Exception ex) {
        Map<String, String> error = new HashMap<>();
        error.put("date", new Date().toString());
        error.put("error", "el usuario o el role no existe");
        error.put("message", ex.getMessage());
        error.put("status", HttpStatus.INTERNAL_SERVER_ERROR.toString());
        return error;
    }

    @ExceptionHandler({NullPointerException.class, HttpMessageNotWritableException.class})
    public ResponseEntity<ErrorDTO> nullPointer(Exception ex) {
        ErrorDTO errorDTO = new ErrorDTO();
        errorDTO.setDate(new Date());
        errorDTO.setError("el usuario o el role no existe");
        errorDTO.setMessage(ex.getMessage());
        errorDTO.setStatus(HttpStatus.INTERNAL_SERVER_ERROR.value());
        return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).body(errorDTO);
    }
}
