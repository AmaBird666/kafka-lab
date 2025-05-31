package ru.voroncov.cloudcomputing.config;

import lombok.Getter;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.client.RestTemplate;

@Getter
@Configuration
public class AppConfig {

    @Value("${app.kafka.review-topic}")
    private String reviewTopic;

    @Value("${app.kafka.product-topic}")
    private String productTopic;

    @Value("${app.kafka.user-topic}")
    private String userTopic;

    @Value("${app.url.data-service}")
    private String dataServiceUrl;


    @Bean
    public RestTemplate restTemplate() {
        return new RestTemplate();
    }

}
