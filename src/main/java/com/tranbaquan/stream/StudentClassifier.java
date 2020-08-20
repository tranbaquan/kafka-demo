package com.tranbaquan.stream;

import com.tranbaquan.deserializer.StudentDeserializer;
import com.tranbaquan.model.Student;
import com.tranbaquan.serde.StudentSerde;
import com.tranbaquan.serializer.StudentSerializer;
import org.apache.kafka.common.serialization.Serdes;
import org.apache.kafka.streams.KafkaStreams;
import org.apache.kafka.streams.StreamsBuilder;
import org.apache.kafka.streams.StreamsConfig;
import org.apache.kafka.streams.kstream.KStream;
import org.apache.kafka.streams.kstream.Produced;

import java.util.Properties;

public class StudentClassifier {
    private final Properties properties;

    public StudentClassifier() {
        this.properties = new Properties();
        this.properties.put(StreamsConfig.APPLICATION_ID_CONFIG, "student-classifier");
        this.properties.put(StreamsConfig.BOOTSTRAP_SERVERS_CONFIG, "localhost:9092");
        this.properties.put(StreamsConfig.DEFAULT_KEY_SERDE_CLASS_CONFIG, Serdes.String().getClass());
        this.properties.put(StreamsConfig.DEFAULT_VALUE_SERDE_CLASS_CONFIG, StudentSerde.class);
    }

    public void classify() {
        StreamsBuilder builder = new StreamsBuilder();
        KStream<String, Student> source = builder.stream("student-admission");
        source.mapValues(student -> new StringBuilder().append("Student: ").append(student.getName())
                .append("\nAge: ").append(student.getAge())
                .append("\nClass: ").append(student.getAge() - 6))
                .mapValues(StringBuilder::toString)
                .to("student-class", Produced.with(Serdes.String(), Serdes.String()));

        new KafkaStreams(builder.build(), properties).start();
    }
}
