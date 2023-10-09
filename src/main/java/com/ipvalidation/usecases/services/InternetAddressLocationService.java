package com.ipvalidation.usecases.services;

import com.ipvalidation.adapters.apis.IpStack;
import com.ipvalidation.domain.entities.InternetAddressLocation;
import org.modelmapper.ModelMapper;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.cache.annotation.Cacheable;
import org.springframework.stereotype.Service;

import java.util.Date;

@Service
public class InternetAddressLocationService {

    @Autowired
    private ModelMapper modelMapper;

    @Autowired
    private IpStack ipStack;

    private static final Logger LOGGER = LoggerFactory.getLogger(InternetAddressLocationService.class);

    @Cacheable(value = "locationInternetAddress")
    public InternetAddressLocation findLocation(String internetAddress) {
        LOGGER.info("Initialized find location for internet address {}", internetAddress);

        var location = ipStack.getIpStack(internetAddress);
        LOGGER.info("Return of IpStack {}", location);

        location.setCreatedAt(new Date());
        LOGGER.info("Finalized find location");

        return location;
    }
}
