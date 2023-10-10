package com.ipvalidation.usecases.producers;

import com.ipvalidation.domain.dtos.InternetAddressRequest;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.kafka.core.KafkaTemplate;
import org.springframework.stereotype.Service;


@Service
public class InternetAddressRegistrationProducer {

    @Value("${kafka.topic.internet-address-registration}")
    private String topic_registration;

    private KafkaTemplate<Object, Object> kafkaTemplate;

    public InternetAddressRegistrationProducer(KafkaTemplate<Object, Object> kafkaTemplate) {
        this.kafkaTemplate = kafkaTemplate;
    }

    public void sendMessage(InternetAddressRequest internetAddressRequest) {
        kafkaTemplate.send(topic_registration, internetAddressRequest);
    }
}
