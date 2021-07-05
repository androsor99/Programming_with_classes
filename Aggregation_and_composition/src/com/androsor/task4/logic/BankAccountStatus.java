package com.androsor.task4.logic;

public enum BankAccountStatus {

    BLOCK(false),
    UNBLOCK(true);

    private final boolean status;

    BankAccountStatus(boolean status) {
        this.status = status;
    }

    public boolean isStatus() {
        return status;
    }
}
