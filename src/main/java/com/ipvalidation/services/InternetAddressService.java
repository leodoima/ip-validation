package com.ipvalidation.services;

import com.ipvalidation.dtos.InternetAddress;
import com.ipvalidation.dtos.InternetAddressResponse;
import com.ipvalidation.entities.InternetAddressLocation;
import com.ipvalidation.enums.InternetAddressStatusEnum;
import org.modelmapper.ModelMapper;
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

    public List<InternetAddressResponse> register(List<InternetAddress> internetAddressList) {
        List<InternetAddressResponse> internetAddressResponseList = new ArrayList<>();

        for (InternetAddress internetAddress : internetAddressList) {
            InternetAddressResponse response = modelMapper.map(internetAddress, InternetAddressResponse.class);

            if (!isValidInternetAddress(response.getInternetAddress())) {
                response.setStatus(InternetAddressStatusEnum.ERROR);

                internetAddressResponseList.add(response);
                break;
            }

            InternetAddressLocation location = locationService.findLocationInternetAddress(response.getInternetAddress());
            modelMapper.map(location, response);

            internetAddressResponseList.add(response);
        }

        return internetAddressResponseList;
    }

    public boolean isValidInternetAddress(String internetAddress) {
        return true;
    }
}
