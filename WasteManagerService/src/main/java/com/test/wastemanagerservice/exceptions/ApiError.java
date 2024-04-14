package com.test.wastemanagerservice.exceptions;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.Setter;

import java.util.Date;

@AllArgsConstructor
@Getter
@Setter
public class ApiError {

    private Integer errorCode;
    private String errorDesc;
    private Date date;

}
