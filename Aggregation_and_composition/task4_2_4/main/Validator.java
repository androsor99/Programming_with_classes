package com.androsor.task4_2_4.main;

import com.androsor.task4_2_4.entity.Client;
import com.androsor.task4_2_4.error.BankAccountException;
import com.androsor.task4_2_4.logic.ClientLogic;

public class Validator {

    public static void checkTheClientIsBankAccounts(Client client) throws BankAccountException {
        if (client.getBankAccounts().size() == 0) {
            throw new BankAccountException("У клиента нет ни одного счета!\n");
        }
    }

    public static void checkTheExistenceOfABankAccountWithTheGivenNumber(long number, ClientLogic clientLogic) throws BankAccountException {
        if (clientLogic.findBankAccountByNumber(number) == null) {
            throw new BankAccountException(String.format("Счёт номер \"%s\" - не найден!\n", number));
        }
    }
}
