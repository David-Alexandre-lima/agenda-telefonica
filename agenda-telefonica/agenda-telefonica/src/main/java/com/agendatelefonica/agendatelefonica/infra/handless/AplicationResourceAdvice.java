package com.agendatelefonica.agendatelefonica.infra.handless;


import com.agendatelefonica.agendatelefonica.core.exceptions.BusinessException;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestControllerAdvice;

@RestControllerAdvice
public class AplicationResourceAdvice {


@ExceptionHandler(BusinessException.class)
@ResponseStatus(HttpStatus.PRECONDITION_FAILED)
public ApiError handleBussinessException(BusinessException ex){
    return new ApiError(ex.getMessage());
 }
}

