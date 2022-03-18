package dev.bank.bankstatement;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.time.Month;
import java.util.List;

import dev.bank.bankstatement.data.BankStatementCSVParser;
import dev.bank.bankstatement.data.BankStatementParser;
import dev.bank.bankstatement.data.BankStatementTSVParser;
import dev.bank.bankstatement.model.BankTransaction;
import dev.bank.bankstatement.service.BankStatementProcessor;

public class BankStatementAnalyzer {
    private static final String RESOURCES = "src/main/resources/";
    
    public void analyze(String fileName, BankStatementParser bankStatementParser) throws IOException {

        // 파일 입출력
        final Path path = Paths.get(RESOURCES + fileName);
        final List<String> lines = Files.readAllLines(path); // Ctrl + .

        // 데이터 파싱
        List<BankTransaction> bankTransactions = bankStatementParser.parseLinesFrom(lines);

        // 입출금 내역 연산
        BankStatementProcessor bankStatementProcessor = new BankStatementProcessor(bankTransactions);

        // 입출금 내역 결과 출력
        collectSummary(bankStatementProcessor);
    }

    private static void collectSummary(BankStatementProcessor bankStatementProcessor) {
        System.out.println("총 입출금 내역은 " + bankStatementProcessor.calculateTotalAmount() + "입니다.");

        System.out.println("1월의 입출금 내역은 " + bankStatementProcessor.caculateTotalInMonth(Month.JANUARY));

        System.out.println("Salary(급여) 카테고리의 내역은 : " + bankStatementProcessor.calculateTotalForCategory("Salary"));
    }

}
