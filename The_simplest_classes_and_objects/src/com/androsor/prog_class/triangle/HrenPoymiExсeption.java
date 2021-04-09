package com.androsor.prog_class.triangle;

public class HrenPoymiExсeption extends Exception{

    public HrenPoymiExсeption() {
    }

    public HrenPoymiExсeption(String message) {
        super(message);
    }

    public HrenPoymiExсeption(String message, Throwable cause) {
        super(message, cause);
    }

    public HrenPoymiExсeption(Throwable cause) {
        super(cause);
    }

    public HrenPoymiExсeption(String message, Throwable cause, boolean enableSuppression, boolean writableStackTrace) {
        super(message, cause, enableSuppression, writableStackTrace);
    }
}
