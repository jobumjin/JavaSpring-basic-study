package dev.bank.bankstatement;

import java.io.IOException;

import dev.bank.bankstatement.data.BankStatementCSVParser;
import dev.bank.bankstatement.data.BankStatementParser;

public class MainApplication {
    
    public static void main(String[] args) throws IOException {
        
        BankStatementFactory bankStatementFactory = new BankStatementFactory();
        
				// 이 두 줄을,
        // BankStatementParser bankStatementParser = new BankStatementCSVParser(); 
        // BankStatementAnalyzer bankStatementAnalyzer = new BankStatementAnalyzer(bankStatementParser);
				
				// 이게 된다고?
        BankStatementAnalyzer bankStatementAnalyzer = bankStatementFactory.bankStatementAnalyzer();
        
        bankStatementAnalyzer.analyze("bank-data-simple.csv");
    }
}