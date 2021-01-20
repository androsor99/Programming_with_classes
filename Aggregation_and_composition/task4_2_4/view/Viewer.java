package com.androsor.task4_2_4.view;

import com.androsor.task4_2_4.entity.BankAccount;
import com.androsor.task4_2_4.entity.Client;
import com.androsor.task4_2_4.error.BankAccountException;

import static com.androsor.task4_2_4.main.TypeCommand.*;

public class Viewer {

    public void showMessageCreateNewClient() {
        System.out.println("Занести нового клиента в базу:\n");
    }

    public void showTypeCommand() {
        System.out.printf("\n---------------------------------------\n" +
                        "%d ->  Открыть счет\n%d ->  Закрыть счет\n" +
                        "%d ->  Блокировать/разблокировать счет\n%d ->  Пополнить/снять средства со счета\n%d ->  Перевести средства со счета на счет\n" +
                        "%d ->  Показать баланс средств по параметрам:\n%d ->  Сортировать счета по параметрам:\n%d ->  Показать все счета клиента\n" +
                        "%d ->  Выйти из программы\n"
                        + "---------------------------------------\n",
                OPEN_BANK_ACCOUNT.getCode(), CLOSE_BANK_ACCOUNT.getCode(),BLOCK_BANK_ACCOUNT.getCode(),
                CHANGING_BANK_ACCOUNT_BALANCE.getCode(), TRANSFER_OF_FUNDS_TO_THE_BANK_ACCOUNT.getCode(), INFO_BANK_ACCOUNT_BALANCE.getCode(),
                SORTING_BANK_ACCOUNT.getCode(), SHOWING_ALL_BANK_ACCOUNT.getCode(), EXIT_PROGRAM.getCode());
    }

    public void showTypeCommandForBlockBankAccount(long number) {
        System.out.printf(
                "Что Вы хотите сделать со счётом номер \"%d\":\n\t%d -> Блокировать\n\t%d -> Разблокировать\n\t другое значение -> Веруться в предыдущее меню\n",
                number, CASE_BLOCK_BANK_ACCOUNT_BLOCKED.getCode(), CASE_BLOCK_BANK_ACCOUNT_UNBLOCKED.getCode());
    }

    public void showTypeCommandForChangBankAccountBalance(long sum, BankAccount bankAccount) {
        System.out.printf(
                "Выберете действие:\n\t%d -> Снять %d со счёта номер \"%d\"\n\t%d -> Пополнить на %2$d счёт номер \"%3$d\"\n\t другое значение ->  Веруться в предыдущее меню\n",
                CASE_CHANGING_BANK_ACCOUNT_BALANCE_TAKE.getCode(), sum, bankAccount.getNumber(), CASE_CHANGING_BANK_ACCOUNT_BALANCE_PUT.getCode());
    }

    public void showTypeCommandForShowingBankAccountBalance() {
        System.out.printf("Показать баланс:\n\t%d -> по всем счетам\n\t%d -> по счетам с положительным остатком\n\t"
                + "%d -> по счетам с отрицательным остатком\n\tдругое значение -> Веруться в предыдущее меню\n", CASE_INFO_BANK_ACCOUNT_BALANCE_ALL.getCode(),
                CASE_INFO_BANK_ACCOUNT_BALANCE_POSITIVE.getCode(), CASE_INFO_BANK_ACCOUNT_BALANCE_NEGATIVE.getCode());
    }

    public void showTypeCommandForSortingBankAccount() {

        System.out.printf("Сортировать счета:\n\t%d -> по величине баланса\n\t%d -> по номерам\n\t"
                + "%d -> по времени открытия\n\tдругое значение -> Веруться в предыдущее меню\n", CASE_SORTING_BANK_ACCOUNT_BALANCE.getCode(),
                CASE_SORTING_BANK_ACCOUNT_BY_NUMBER.getCode(), CASE_SORTING_BANK_ACCOUNT_DATE_CREATE.getCode());
    }

    public void showAllClientsBankAccounts(Client client) {

        System.out.printf("Список всех счетов клиента \"%s %s\", id = \"%s\":\n",client.getSecondName(), client.getFirstName(), client.getPassportID());

        for (BankAccount bankAccount : client.getBankAccounts()) {
            showInConsoleBankAccounts(bankAccount);
        }
    }

    @SuppressWarnings("deprecation")
    public void showInConsoleBankAccounts(BankAccount bankAccount) {
        System.out.printf("Номер счёта: #%s; баланс: %d; статус: %s, открыт: %s\n", bankAccount.getNumber(), bankAccount.getBalance(),
                (bankAccount.isActive() ? "активен" : "заблокирован"), bankAccount.getDateCreation().toLocaleString());
    }

    public void showMessageAddMoneyBankAccount(BankAccount bankAccount, long amountsRecharged) {
        System.out.printf("Баланс счёта \"%d\" увеличен на %d. Актуальный баланс: %d\n", bankAccount.getNumber(), amountsRecharged, bankAccount.getBalance());
    }

    public void showMessageRemoveMoneyBankAccount(BankAccount bankAccount, long amountsRecharged) {
        System.out.printf("Со счёта \"%s\" снято %d. Актуальный баланс: %d\n", bankAccount.getNumber(), amountsRecharged, bankAccount.getBalance());
    }

    public void showMessageAddingNewClient(Client client) {
        System.out.printf("Клиент \"%s %s\" добавлен в базу. id клиента = %s:\n", client.getFirstName(), client.getSecondName(), client.getPassportID());
    }

    public void showMessageOpenNewBankAccount(long number) {
        System.out.printf("Счёт номер \"%s\" открыт!\n", number);
    }

    public void showMessageCloseBankAccount(long number) {
        System.out.printf("Счёт номер \"%s\" успешно закрыт!\n", number);
    }

    public void showMessageStateBlockBankAccount(long number) {
        System.out.printf("Счёт \"%s\" заблокирован!\n", number);
    }

    public void showMessageStateUnBlockBankAccount(long number) {
        System.out.printf("Счёт \"%s\" разблокирован!\n", number);
    }

    public void showMessageTransferBankAccount() {
        System.out.print("Перевод средств выполнен!");
    }

    public void showTotalBalanceBankAccount(long balance) {
        System.out.printf("Баланс по всем счетам: %d\n", balance);
    }

    public void showPositiveBalanceBankAccount(long balance) {
        System.out.printf("Баланс по всем счетам с положительным остатком: %d\n", balance);
    }
    public void showNegativeBalanceBankAccount(long balance) {
        System.out.printf("Баланс по всем счетам с отрицательным остатком: %d\n", balance);
    }

    public void showMessageSortBankAccountsByBalance() {
        System.out.print("Счёта отсортированы по возростанию баланса средств.\n");
    }

    public void showMessageSortBankAccountsByNumber() {
        System.out.print("Счёта отсортированы по возростанию номера.\n");
    }

    public void showMessageSortBankAccountsByDate() {
        System.out.print("Счёта отсортированы по возростанию даты открытия.\n");
    }

    public void showMessageAboutInvalidCommand() {
        System.err.println("Неверная команда!");
    }

//    public String showMessageAboutTheExistenceOfBankAccountWithTheGivenNumber(long number){
//        return String.format("Счёт с номером \"%s\" уже существует!\n", number);
//    }

}
