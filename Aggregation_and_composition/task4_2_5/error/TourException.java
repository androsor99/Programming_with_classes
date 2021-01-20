package com.androsor.task4_2_5.error;

public class TourException extends Exception{

    public TourException() {
    }

    public TourException(String message) {
        super(message);
    }

    public TourException(String message, Throwable cause) {
        super(message, cause);
    }

    public TourException(Throwable cause) {
        super(cause);
    }

    public TourException(String message, Throwable cause, boolean enableSuppression, boolean writableStackTrace) {
        super(message, cause, enableSuppression, writableStackTrace);
    }
}
