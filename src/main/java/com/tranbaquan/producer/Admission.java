package com.tranbaquan.producer;

import com.tranbaquan.model.Student;
import com.tranbaquan.serializer.StudentSerializer;
import org.apache.kafka.clients.producer.KafkaProducer;
import org.apache.kafka.clients.producer.ProducerConfig;
import org.apache.kafka.clients.producer.ProducerRecord;
import org.apache.kafka.common.serialization.StringSerializer;

import java.util.Properties;

public class Admission {

    private Properties properties;
    KafkaProducer<String, Student> producer;

    public Admission() {
        this.properties = new Properties();
        this.properties.put(ProducerConfig.BOOTSTRAP_SERVERS_CONFIG, "localhost:9092");
        this.properties.put(ProducerConfig.CLIENT_ID_CONFIG, "quantb");
        this.properties.put(ProducerConfig.KEY_SERIALIZER_CLASS_CONFIG, StringSerializer.class.getName());
        this.properties.put(ProducerConfig.VALUE_SERIALIZER_CLASS_CONFIG, StudentSerializer.class.getName());
        this.producer = new KafkaProducer<>(properties);
    }

    public void admitStudent(Student student) {
        ProducerRecord<String, Student> record = new ProducerRecord<>("student-admission", student);
        producer.send(record);
    }

    public void stopAdmit() {
        producer.close();
    }
}
