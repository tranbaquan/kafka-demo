package com.tranbaquan.stream;

import org.apache.kafka.common.serialization.Serdes;
import org.apache.kafka.streams.KafkaStreams;
import org.apache.kafka.streams.StreamsBuilder;
import org.apache.kafka.streams.StreamsConfig;
import org.apache.kafka.streams.kstream.KStream;

import java.util.Properties;

public class StudentNotifier {
    private Properties properties;

    public StudentNotifier() {
        properties = new Properties();
        properties.put(StreamsConfig.APPLICATION_ID_CONFIG, "student-notifier");
        properties.put(StreamsConfig.BOOTSTRAP_SERVERS_CONFIG, "localhost:9092");
        properties.put(StreamsConfig.DEFAULT_KEY_SERDE_CLASS_CONFIG, Serdes.String().getClass());
        properties.put(StreamsConfig.DEFAULT_VALUE_SERDE_CLASS_CONFIG, Serdes.String().getClass());
    }

    public void writeLog() {
        StreamsBuilder builder = new StreamsBuilder();
        KStream<String, String> source = builder.stream("student-class");
        source.mapValues(value -> new StringBuilder("Info:\n").append(value).append("\n--------------------------------------"))
                .mapValues(StringBuilder::toString).to("log");

        new KafkaStreams(builder.build(), properties).start();
    }
}
