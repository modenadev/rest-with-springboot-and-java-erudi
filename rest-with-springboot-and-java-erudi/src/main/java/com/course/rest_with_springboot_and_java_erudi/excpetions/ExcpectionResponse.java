package com.course.rest_with_springboot_and_java_erudi.excpetions;

import java.io.Serializable;
import java.util.Date;

public class ExcpectionResponse implements Serializable {
    private static final long serialVersionUID = 1L;

    private Date timestamp;
    private String message;
    private String details;

    public ExcpectionResponse(Date timestamp, String message, String details) {
        this.timestamp = timestamp;
        this.message = message;
        this.details = details;
    }

    public Date getTimestamp() {
        return timestamp;
    }

    public String getMessage() {
        return message;
    }

    public String getDetails() {
        return details;
    }
}
