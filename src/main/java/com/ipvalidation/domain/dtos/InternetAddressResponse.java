package com.ipvalidation.domain.dtos;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.util.Date;

@AllArgsConstructor
@NoArgsConstructor
@Getter
@Setter
public class InternetAddressResponse {

    private String internetAddress;
    private String countryName;
    private String regionCode;
    private String city;
    private Date createdAt;

    public InternetAddressResponse(String internetAddress) {
        this.internetAddress = internetAddress;
    }
}
