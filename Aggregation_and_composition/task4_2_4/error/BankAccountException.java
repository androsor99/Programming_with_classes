package com.androsor.task4_2_4.error;

public class BankAccountException extends Exception {

    public BankAccountException() {
    }

    public BankAccountException(String message) {
        super(message);
    }

    public BankAccountException(String message, Throwable cause) {
        super(message, cause);
    }

    public BankAccountException(Throwable cause) {
        super(cause);
    }

    public BankAccountException(String message, Throwable cause, boolean enableSuppression, boolean writableStackTrace) {
        super(message, cause, enableSuppression, writableStackTrace);
    }
}
