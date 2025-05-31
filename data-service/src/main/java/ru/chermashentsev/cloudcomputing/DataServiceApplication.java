package ru.voroncov.cloudcomputing;

import io.github.cdimascio.dotenv.Dotenv;
import lombok.extern.slf4j.Slf4j;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@Slf4j
@SpringBootApplication
public class DataServiceApplication {
    public static void main(String[] args) {
        Dotenv dotenv = Dotenv.configure().ignoreIfMissing().load();
        dotenv.entries().forEach(
                dotenvEntry ->  System.setProperty(dotenvEntry.getKey(), dotenvEntry.getValue())
        );

        log.info("DATABASE_URL = {}", dotenv.get("SPRING_DATASOURCE_URL"));
        log.info("DATABASE_USERNAME = {}", dotenv.get("SPRING_DATASOURCE_USERNAME"));
        log.info("DATABASE_PASSWORD = {}", dotenv.get("SPRING_DATASOURCE_PASSWORD"));

        SpringApplication.run(DataServiceApplication.class, args);
    }
}