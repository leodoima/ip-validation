package com.ipvalidation.usecases.services;

import com.ipvalidation.domain.dtos.InternetAddress;
import com.ipvalidation.domain.dtos.InternetAddressResponse;
import com.ipvalidation.domain.entities.InternetAddressLocation;
import com.ipvalidation.domain.enums.InternetAddressStatusEnum;
import org.modelmapper.ModelMapper;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
public class InternetAddressService {

    @Autowired
    private ModelMapper modelMapper;

    @Autowired
    private InternetAddressLocationService locationService;

    private static final Logger LOGGER = LoggerFactory.getLogger(InternetAddressService.class);

    public List<InternetAddressResponse> register(List<InternetAddress> internetAddressList) {

        LOGGER.info("Receive internet address list");

        List<InternetAddressResponse> internetAddressResponseList = new ArrayList<>();

        for (InternetAddress internetAddress : internetAddressList) {
            LOGGER.info("Initialized process for internet address {}", internetAddress.getInternetAddress());

            InternetAddressResponse response = modelMapper.map(internetAddress, InternetAddressResponse.class);

            if (!isValidInternetAddress(response.getInternetAddress())) {
                LOGGER.error("Identified a invalid internet address {}", internetAddress.getInternetAddress());

                response.setStatus(InternetAddressStatusEnum.ERROR);
                internetAddressResponseList.add(response);
                break;
            }

            InternetAddressLocation location = locationService.findLocationInternetAddress(response.getInternetAddress());
            modelMapper.map(location, response);

            response.setStatus(InternetAddressStatusEnum.SUCCESS);
            internetAddressResponseList.add(response);

            LOGGER.info("Finalized process for internet address {}", internetAddress.getInternetAddress());
        }
        LOGGER.info("Finalized process for list internet address");

        return internetAddressResponseList;
    }

    public boolean isValidInternetAddress(String internetAddress) {
        return true;
    }
}
