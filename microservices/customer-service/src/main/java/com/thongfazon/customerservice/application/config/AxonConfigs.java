//package com.thongfazon.customerservice.application.config;
//
//import org.axonframework.config.ConfigurerModule;
//import org.axonframework.eventsourcing.EventCountSnapshotTriggerDefinition;
//import org.axonframework.eventsourcing.SnapshotTriggerDefinition;
//import org.axonframework.eventsourcing.Snapshotter;
//import org.springframework.context.annotation.Bean;
//import org.springframework.context.annotation.Configuration;
//
//@Configuration
//public class AxonConfigs {
//
//    // Trigger a snapshot every N events
//    private static final int SNAPSHOT_THRESHOLD = 50;
//
//    @Bean
//    public SnapshotTriggerDefinition customerSnapshotTrigger(Snapshotter snapshotter) {
//        return new EventCountSnapshotTriggerDefinition(snapshotter, SNAPSHOT_THRESHOLD);
//    }
//
//    @Bean
//    public ConfigurerModule snapshotFilterConfigurer() {
//        return configurer -> configurer
//                .configureEmbeddedEventStore(c ->
//                        (org.axonframework.eventsourcing.eventstore.EventStorageEngine) org.axonframework.eventsourcing.eventstore.EmbeddedEventStore
//                                .builder()
//                                .storageEngine(c.getComponent(
//                                        org.axonframework.eventsourcing.eventstore.EventStorageEngine.class))
//                                .build()
//                );
//    }
//
//    // Dead letter Queue
//
//}