package com.tranbaquan.serde;

import com.tranbaquan.deserializer.StudentDeserializer;
import com.tranbaquan.model.Student;
import com.tranbaquan.serializer.StudentSerializer;
import org.apache.kafka.common.serialization.Serdes;

public class StudentSerde extends Serdes.WrapperSerde<Student> {
    public StudentSerde() {
        super(new StudentSerializer(), new StudentDeserializer());
    }
}
