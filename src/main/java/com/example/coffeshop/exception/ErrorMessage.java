package com.example.coffeshop.exception;

import java.util.Date;

public class ErrorMessage {
    private int status;
    private String message;
    private Date createDate;
    private String description;

    public ErrorMessage(int status, String message, Date createDate, String description) {
        this.status = status;
        this.message = message;
        this.createDate = createDate;
        this.description = description;
    }

    public int getStatus() {
        return status;
    }

    public String getMessage() {
        return message;
    }

    public Date getCreateDate() {
        return createDate;
    }

    public String getDescription() {
        return description;
    }

    @Override
    public String toString() {
        return "ErrorMessage{" +
                "status=" + status +
                ", message='" + message + '\'' +
                ", createDate=" + createDate +
                ", description='" + description + '\'' +
                '}';
    }
}
