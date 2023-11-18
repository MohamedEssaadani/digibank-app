package com.ess.ebankgraphql;

import com.ess.ebankgraphql.utils.Utilities;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.client.discovery.EnableDiscoveryClient;

import java.util.stream.Stream;

@SpringBootApplication
@EnableDiscoveryClient
@RequiredArgsConstructor
@Slf4j
public class EBankGraphqlApplication implements CommandLineRunner {
    private final Utilities utilities;

    public static void main(String[] args) {
        SpringApplication.run(EBankGraphqlApplication.class, args);
    }

    @Override
    public void run(String... args) throws Exception {
        log.info("********** START FILL CUSTOMERS  **********");
        utilities.fillCustomers();
        log.info("********** END FILL CUSTOMERS  **********");

        log.info("********** START FILL CONTRACTS  **********");
        utilities.fillContracts();
        log.info("********** END FILL CONTRACTS  **********");
    }
}
