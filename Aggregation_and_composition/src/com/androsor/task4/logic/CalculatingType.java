package com.androsor.task4.logic;

import com.androsor.task4.entity.BankAccount;

import java.math.BigDecimal;
import java.util.List;
import java.util.function.Function;
import java.util.stream.Stream;

public enum CalculatingType {

    CALCULATE_TOTAL(accounts -> getBalance(accounts).reduce(BigDecimal::add).orElse(BigDecimal.ZERO)),
    CALCULATE_TOTAL_POSITIVE(accounts -> getBalance(accounts).filter(balance -> balance.compareTo(BigDecimal.ZERO) > 0).
                    reduce(BigDecimal::add).orElse(BigDecimal.ZERO)),
    CALCULATE_TOTAL_NEGATIVE(accounts -> getBalance(accounts).filter(balance -> balance.compareTo(BigDecimal.ZERO) < 0).
                    reduce(BigDecimal::add).orElse(BigDecimal.ZERO));

    private final Function<List<BankAccount>, BigDecimal> calculatingBalance;

    CalculatingType(Function<List<BankAccount>, BigDecimal> calculatingBalance) {
        this.calculatingBalance = calculatingBalance;
    }

    public Function<List<BankAccount>, BigDecimal> getCalculatingBalance() {
        return calculatingBalance;
    }
    public static Stream<BigDecimal> getBalance(List<BankAccount> accounts) {
        return accounts.stream()
        .map(BankAccount::getBalance);
    }
}
