package com.etrade.analytic.core.config.kafka;


import com.etrade.analytic.core.config.kafka.events.AnalyticEvent;
import org.apache.kafka.clients.consumer.ConsumerConfig;
import org.apache.kafka.common.serialization.StringDeserializer;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.kafka.annotation.EnableKafka;
import org.springframework.kafka.config.ConcurrentKafkaListenerContainerFactory;
import org.springframework.kafka.core.ConsumerFactory;
import org.springframework.kafka.core.DefaultKafkaConsumerFactory;
import org.springframework.kafka.support.serializer.JsonDeserializer;

import java.util.HashMap;
import java.util.Map;

@EnableKafka
@Configuration
public class KafkaConsumerConfig {

    @Value(value = "${kafka.bootstrap-server}")
    private String bootstrapServer;

    @Value(value = "${kafka.group-id}")
    private String group;

    @Bean
    public ConsumerFactory<String, AnalyticEvent> consumerFactory(){
        JsonDeserializer<AnalyticEvent> deserializer = new JsonDeserializer<>(AnalyticEvent.class);
        deserializer.setRemoveTypeHeaders(false);
        deserializer.addTrustedPackages("*");
        deserializer.setUseTypeMapperForKey(true);

        Map<String, Object> configs = new HashMap<>();
        configs.put(ConsumerConfig.BOOTSTRAP_SERVERS_CONFIG, bootstrapServer);
        configs.put(ConsumerConfig.GROUP_ID_CONFIG, group);
        return new DefaultKafkaConsumerFactory<>(configs, new StringDeserializer(), deserializer);
    }

    @Bean
    public ConcurrentKafkaListenerContainerFactory<String,AnalyticEvent> kafkaListenerContainerFactory(){
        ConcurrentKafkaListenerContainerFactory<String,AnalyticEvent> factory =
                new ConcurrentKafkaListenerContainerFactory<>();
        factory.setConsumerFactory(consumerFactory());
        return factory;
    }
}
