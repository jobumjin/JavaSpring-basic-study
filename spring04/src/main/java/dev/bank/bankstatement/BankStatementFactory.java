package dev.bank.bankstatement;

import dev.bank.bankstatement.data.BankStatementCSVParser;
import dev.bank.bankstatement.data.BankStatementParser;

public class BankStatementFactory {
    public BankStatementAnalyzer bankStatementAnalyzer() {

				// ..이거 MainApplication.java에 있는 코드 아닌가?.. ¯\_(ツ)_/¯(에라 모르겠다~)
        BankStatementParser bankStatementParser = new BankStatementCSVParser();

        BankStatementAnalyzer bankStatementAnalyzer = new BankStatementAnalyzer(bankStatementParser);

        return bankStatementAnalyzer;
    }
}