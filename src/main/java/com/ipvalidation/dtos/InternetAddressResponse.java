package com.ipvalidation.dtos;

import com.ipvalidation.entities.InternetAddressLocation;
import com.ipvalidation.enums.InternetAddressStatusEnum;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@AllArgsConstructor
@NoArgsConstructor
@Getter
@Setter
public class InternetAddressResponse {

    private String internetAddress;
    private String country_name;
    private String region_code;
    private String city;
    private InternetAddressStatusEnum status;
}
