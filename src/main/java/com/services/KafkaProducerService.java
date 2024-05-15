package com.services;

import com.models.Data;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.kafka.core.KafkaTemplate;
import org.springframework.stereotype.Service;

@Service
public class KafkaProducerService {
    private static final String TOPIC = "data";

    @Autowired
    private KafkaTemplate<String, Data> kafkaTemplate;

    public void sendMessage(Data data) {
        kafkaTemplate.send(TOPIC, data);
    }
}
