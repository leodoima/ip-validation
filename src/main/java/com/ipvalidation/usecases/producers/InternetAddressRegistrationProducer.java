package com.ipvalidation.usecases.producers;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.kafka.core.KafkaTemplate;
import org.springframework.stereotype.Service;


@Service
public class InternetAddressRegistrationProducer {

    @Value("${kafka.topic.internet-address-registration}")
    private String topic_registration;

    private KafkaTemplate<String, String> kafkaTemplate;

    public InternetAddressRegistrationProducer(KafkaTemplate<String, String> kafkaTemplate) {
        this.kafkaTemplate = kafkaTemplate;
    }

    public void sendMessage(String internetAddress) {
        kafkaTemplate.send(topic_registration, internetAddress);
    }
}
