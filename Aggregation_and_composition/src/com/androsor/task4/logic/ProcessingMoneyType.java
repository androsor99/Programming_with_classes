package com.androsor.task4.logic;

import com.androsor.task4.entity.BankAccount;

import java.math.BigDecimal;
import java.util.function.BiConsumer;

public enum ProcessingMoneyType {

    ADD_MONEY(BankAccount::add),
    WITHDRAW_MONEY(BankAccount::subtract);

    private final BiConsumer<BankAccount, BigDecimal> processingMoney ;

    ProcessingMoneyType(BiConsumer<BankAccount, BigDecimal> processingMoney) {
        this.processingMoney = processingMoney;
    }

    public BiConsumer<BankAccount, BigDecimal> getProcessingMoney() {
        return processingMoney;
    }
}
