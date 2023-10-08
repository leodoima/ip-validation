package com.ipvalidation.services;

import com.ipvalidation.apis.IpStack;
import com.ipvalidation.entities.InternetAddressLocation;
import org.modelmapper.ModelMapper;
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

    @Cacheable(value = "locationInternetAddress")
    public InternetAddressLocation findLocationInternetAddress(String internetAddress) {
        InternetAddressLocation location = ipStack.getIpStack(internetAddress);
        location.setCreatedAt(new Date());

        return location;
    }
}
