package ru.voroncov.cloudcomputing.config;

import lombok.RequiredArgsConstructor;
import org.apache.kafka.clients.admin.NewTopic;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.kafka.config.TopicBuilder;

@Configuration
@RequiredArgsConstructor
public class KafkaTopicConfig {

    private final AppConfig appConfig;

    @Bean
    public NewTopic productTopic() {
        return TopicBuilder
                .name(appConfig.getProductTopic())
                .partitions(3)
                .build();
    }

    @Bean
    public NewTopic userTopic() {
        return TopicBuilder
                .name(appConfig.getUserTopic())
                .partitions(3)
                .build();
    }

    @Bean
    public NewTopic reviewTopic() {
        return TopicBuilder
                .name(appConfig.getReviewTopic())
                .partitions(3)
                .build();
    }

}
