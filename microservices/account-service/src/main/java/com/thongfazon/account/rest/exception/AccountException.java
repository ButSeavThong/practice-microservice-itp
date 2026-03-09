package com.thongfazon.account.rest.exception;


import com.thong.common.domain.application.exception.ErrorResponse;
import com.thong.common.domain.exception.DomainException;
import com.thongfazon.account.domain.exception.AccountDomainException;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestControllerAdvice;

import java.time.ZonedDateTime;

@RestControllerAdvice
public class AccountException {

    @ExceptionHandler(DomainException.class)
    public ResponseEntity<?> handleDomainException(DomainException ex) {
        return new ResponseEntity<>(
                ErrorResponse.builder()
                        .stats(HttpStatus.INTERNAL_SERVER_ERROR.getReasonPhrase())
                        .code(HttpStatus.INTERNAL_SERVER_ERROR.value())
                        .message(ex.getMessage())
                        .timestamp(ZonedDateTime.now())
                        .build(),
                HttpStatus.INTERNAL_SERVER_ERROR
        );
    }
}
