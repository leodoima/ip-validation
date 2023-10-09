package com.ipvalidation.usecases.services;

import com.ipvalidation.domain.dtos.InternetAddressRequest;
import com.ipvalidation.domain.dtos.InternetAddressResponse;
import com.ipvalidation.usecases.producers.InternetAddressRegistrationProducer;
import lombok.Getter;
import org.modelmapper.ModelMapper;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.scheduling.annotation.Async;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
public class InternetAddressService {

    @Autowired
    private ModelMapper modelMapper;

    @Autowired
    private InternetAddressRegistrationProducer registrationProducer;

    @Autowired
    private InternetAddressLocationService locationService;

    @Autowired
    private InternetAddressLocationService internetAddressLocationService;

    @Getter
    private List<InternetAddressResponse> addressResponseList = new ArrayList<>();

    private static final Logger LOGGER = LoggerFactory.getLogger(InternetAddressService.class);

    @Async
    public void register(List<InternetAddressRequest> internetAddressRequestList) {
        LOGGER.info("Receive internet address list");

        for (InternetAddressRequest internetAddressRequest : internetAddressRequestList) {
            LOGGER.info("Initialized process validation internet address {}", internetAddressRequest.getInternetAddress());

            if (!isValidInternetAddress(internetAddressRequest.getInternetAddress())) {
                LOGGER.error("Identified a invalid internet address {}. This address will not include in registration topic", internetAddressRequest.getInternetAddress());
                break;
            }

            registrationProducer.sendMessage(internetAddressRequest.getInternetAddress());

            LOGGER.info("Validation process and topic insertion finalized for internet address {}", internetAddressRequest.getInternetAddress());
        }
        LOGGER.info("Finalized process for list internet address");
    }

    public void process(String internetAddress) {
        LOGGER.info("Init process of location for internet address {}", internetAddress);
        var addressResponse = new InternetAddressResponse(internetAddress);

        var location = internetAddressLocationService.findLocation(internetAddress);
        LOGGER.info("Location for {}: {}", internetAddress, location.toString());

        modelMapper.map(location, addressResponse);
        addressResponseList.add(addressResponse);

        LOGGER.info("Added location in list");
    }

    public boolean isValidInternetAddress(String internetAddress) {
        return true;
    }
}
