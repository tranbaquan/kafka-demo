package com.tranbaquan.thread;

import com.tranbaquan.consumer.ConsumerDemo;
import org.apache.kafka.clients.consumer.ConsumerConfig;
import org.apache.kafka.common.serialization.StringDeserializer;

import java.util.Properties;

public class ConsumerThread extends Thread {

    @Override
    public void run() {
        Properties properties = new Properties();
        properties.put(ConsumerConfig.BOOTSTRAP_SERVERS_CONFIG, "localhost:9092");
        properties.put(ConsumerConfig.GROUP_ID_CONFIG, "com.tranbaquan");
        properties.put(ConsumerConfig.KEY_DESERIALIZER_CLASS_CONFIG, StringDeserializer.class.getName());
        properties.put(ConsumerConfig.VALUE_DESERIALIZER_CLASS_CONFIG, StringDeserializer.class.getName());

        ConsumerDemo consumer = new ConsumerDemo(properties);
        consumer.subscribe("topic1", "topic2");

        while (true) {
            consumer.pool();
        }
    }
}
