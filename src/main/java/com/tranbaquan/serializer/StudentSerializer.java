package com.tranbaquan.serializer;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.tranbaquan.model.Student;
import org.apache.kafka.common.errors.SerializationException;
import org.apache.kafka.common.serialization.Serializer;

public class StudentSerializer implements Serializer<Student> {

    @Override
    public byte[] serialize(String topic, Student data) {
        if (data == null) {
            return null;
        }

        ObjectMapper mapper = new ObjectMapper();

        try {
            return mapper.writeValueAsString(data).getBytes();
        } catch (JsonProcessingException e) {
            throw new SerializationException(e);
        }
    }
}
