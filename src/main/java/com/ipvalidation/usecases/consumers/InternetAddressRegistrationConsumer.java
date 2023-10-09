package com.ipvalidation.usecases.consumers;

import com.ipvalidation.usecases.services.InternetAddressLocationService;
import com.ipvalidation.usecases.services.InternetAddressService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.kafka.annotation.KafkaListener;
import org.springframework.stereotype.Service;

@Service
public class InternetAddressRegistrationConsumer {

    @Autowired
    private InternetAddressLocationService internetAddressLocationService;

    @Autowired
    private InternetAddressService internetAddressService;

    @KafkaListener(topics = "${kafka.topic.internet-address-registration}", groupId = "group-1")
    public void receiveMessage(String internetAddress) {
        internetAddressService.process(internetAddress);
    }
}
