package com.thong.account_query.message.config;

import lombok.extern.slf4j.Slf4j;
import org.axonframework.config.EventProcessingConfigurer;
import org.axonframework.extensions.kafka.eventhandling.consumer.streamable.StreamableKafkaMessageSource;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Configuration;

@Configuration
@Slf4j
public class AxonKafkaConfig {

    public static final String PROCESSOR_NAME = "account-group";
    @Value("${axon.kafka.default-topic}")
    private String topic;

    @Autowired
    public void configureStreamableKafkaSource(
            EventProcessingConfigurer eventProcessingConfigurer,
            StreamableKafkaMessageSource<String, byte[]> streamableKafkaMessageSource) {
        log.info("Registering TrackingEventProcessor '{}' consuming from topic '{}'",
                PROCESSOR_NAME, topic);

        // BUG FIX #1: Must use registerTrackingEventProcessor, NOT registerPooledStreamingEventProcessor.
        // StreamableKafkaMessageSource is only compatible with TrackingEventProcessor.
        // PooledStreamingEventProcessor uses a different internal source interface and
        // will either silently skip Kafka messages or throw a runtime incompatibility error.
        eventProcessingConfigurer.registerTrackingEventProcessor(
                PROCESSOR_NAME,
                configuration -> streamableKafkaMessageSource
        );
    }
}