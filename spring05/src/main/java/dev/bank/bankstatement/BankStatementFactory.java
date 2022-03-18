package dev.bank.bankstatement;

import org.springframework.cache.annotation.CacheConfig;
import org.springframework.context.annotation.Bean;

import dev.bank.bankstatement.data.BankStatementCSVParser;
import dev.bank.bankstatement.data.BankStatementParser;

@CacheConfig // 이 클래스가 빈 구성정보로 활용될 수 있도록 지정
public class BankStatementFactory {

    @Bean
    public BankStatementCSVParser bankStatementCSVParser() {
        return new BankStatementCSVParser();
    }

    //  빈 구성 정보 내 등록되어 있는 빈
    @Bean
    public BankStatementAnalyzer bankStatementAnalyzer() {
        BankStatementAnalyzer bankStatementAnalyzer = new BankStatementAnalyzer(bankStatementCSVParser());

        return bankStatementAnalyzer;
    }
}