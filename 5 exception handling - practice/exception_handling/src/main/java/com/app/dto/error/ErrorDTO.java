package com.app.dto.error;

import lombok.Getter;
import lombok.Setter;

import java.util.Date;

@Getter
@Setter
public class ErrorDTO {
    private String message;
    private String error;
    private int status;
    private Date date;


}
