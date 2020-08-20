package com.tranbaquan.deserializer;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.tranbaquan.model.Student;
import org.apache.kafka.common.errors.SerializationException;
import org.apache.kafka.common.serialization.Deserializer;

import java.io.IOException;

public class StudentDeserializer implements Deserializer<Student> {

    @Override
    public Student deserialize(String topic, byte[] data) {
        if (data == null) {
            return null;
        }

        ObjectMapper mapper = new ObjectMapper();

        try {
            return mapper.readValue(data, Student.class);
        } catch (IOException e) {
            throw new SerializationException(e);
        }
    }

}
