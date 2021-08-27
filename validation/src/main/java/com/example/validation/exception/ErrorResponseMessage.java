package com.example.validation.exception;

public class ErrorResponseMessage {

    private String method;
    private String message;
    private long timestamp;

    public ErrorResponseMessage() {}

    public ErrorResponseMessage(String method, String message, long timestamp) {
        this.method = method;
        this.message = message;
        this.timestamp = timestamp;
    }

    public ErrorResponseMessage(String method, long timestamp) {
        this.method = method;
        this.timestamp = timestamp;
    }

    public String getMethod() {
        return method;
    }

    public void setMethod(String method) {
        this.method = method;
    }

    public String getMessage() {
        return message;
    }

    public void setMessage(String message) {
        this.message = message;
    }

    public long getTimestamp() {
        return timestamp;
    }

    public void setTimestamp(long timestamp) {
        this.timestamp = timestamp;
    }

    @Override
    public String toString() {
        return "ErrorResponseMessage{" +
                "method='" + method + '\'' +
                ", message='" + message + '\'' +
                ", timestamp=" + timestamp +
                '}';
    }
}
