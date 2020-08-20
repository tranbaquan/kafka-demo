package com.tranbaquan.consumer;

import org.apache.kafka.clients.consumer.ConsumerRecord;
import org.apache.kafka.clients.consumer.ConsumerRecords;
import org.apache.kafka.clients.consumer.KafkaConsumer;

import java.time.Duration;
import java.util.Arrays;
import java.util.Properties;

public class ConsumerDemo {
    private Properties properties;
    private KafkaConsumer<String, String> consumer;

    public ConsumerDemo(Properties properties) {
        this.properties = properties;
        this.consumer = new KafkaConsumer<>(properties);
    }

    public Properties getProperties() {
        return properties;
    }

    public void setProperties(Properties properties) {
        this.properties = properties;
    }

    public void subscribe(String... topics) {
        consumer.subscribe(Arrays.asList("topic1", "topic2", "topic3"));
    }

    public void pool() {
        ConsumerRecords<String, String> records = consumer.poll(Duration.ofMillis(1000));
        for (ConsumerRecord<String, String> record: records) {
            System.out.println(record.topic() + ": " + record.value());
        }
    }
}
