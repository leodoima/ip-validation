package com.ipvalidation.usecases.consumers;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.ipvalidation.domain.entities.InternetAddress;
import com.ipvalidation.usecases.services.InternetAddressLocationService;
import com.ipvalidation.usecases.services.InternetAddressService;
import org.apache.kafka.clients.consumer.ConsumerRecord;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.kafka.annotation.KafkaListener;
import org.springframework.stereotype.Service;

@Service
public class InternetAddressRegistrationConsumer {

    @Autowired
    private ObjectMapper objectMapper;

    @Autowired
    private InternetAddressLocationService internetAddressLocationService;

    @Autowired
    private InternetAddressService internetAddressService;

    private static final Logger LOGGER = LoggerFactory.getLogger(InternetAddressRegistrationConsumer.class);

    @KafkaListener(topics = "${kafka.topic.internet-address-registration}", groupId = "microservice-process-internet-address")
    public void receiveMessage(ConsumerRecord<String, String> record) {
        InternetAddress internetAddress = null;

        try {
            internetAddress = objectMapper.readValue(record.value(), InternetAddress.class);
        } catch (JsonProcessingException e) {
            LOGGER.error("Error in readValue for record microservice-process-internet-address", e);
            return;
        }

        if (internetAddress == null) {
            return;
        }

        internetAddressService.process(internetAddress);
    }
}
