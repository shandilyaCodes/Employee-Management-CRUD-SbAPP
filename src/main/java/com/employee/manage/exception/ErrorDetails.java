package com.employee.manage.exception;


import lombok.Getter;
import lombok.RequiredArgsConstructor;

import java.util.Date;

@Getter
@RequiredArgsConstructor
public class ErrorDetails {
    private final Date date;
    private final String message;
    private final String details;
}