package com.ipvalidation.usecases.services;

import com.ipvalidation.domain.dtos.InternetAddressRequest;
import com.ipvalidation.domain.dtos.InternetAddressResponse;
import com.ipvalidation.domain.entities.InternetAddress;
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
    private List<InternetAddress> addressList = new ArrayList<>();

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

            registrationProducer.sendMessage(internetAddressRequest);

            LOGGER.info("Validation process and topic insertion finalized for internet address {}", internetAddressRequest.getInternetAddress());
        }
        LOGGER.info("Finalized process for list internet address");
    }

    public void process(InternetAddress internetAddress) {
        LOGGER.info("Init process of location for internet address {}", internetAddress);

        var location = internetAddressLocationService.findLocation(internetAddress.getInternetAddress());
        LOGGER.info("Location for {}: {}", internetAddress.getInternetAddress(), location.toString());

        modelMapper.map(location, internetAddress);
        addressList.add(internetAddress);

        LOGGER.info("Added location in list");
    }

    public List<InternetAddressResponse> listAll() {
        LOGGER.info("Initialized convert list for internetAddress.listAll()");

        return addressList.stream().map(internetAddress -> {
            return new InternetAddressResponse(
                    internetAddress.getInternetAddress(),
                    internetAddress.getLocation().getCountryName(),
                    internetAddress.getLocation().getRegionCode(),
                    internetAddress.getLocation().getCity(),
                    internetAddress.getLocation().getCreatedAt());
        }).toList();
    }

    public boolean isValidInternetAddress(String internetAddress) {
        return true;
    }
}
