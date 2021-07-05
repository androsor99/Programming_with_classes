package com.androsor.task4.utils;

import com.androsor.task4.logic.ClientHandler;

public class IOHelper {

    public static void createBankAccount(ClientHandler clientHandler) throws InterruptedException {
        for (int i = 0; i <= 5; i++) {
            long num = i + 1000;
            clientHandler.openNewBankAccount(num);
            Thread.sleep(2000);
        }
    }
}
