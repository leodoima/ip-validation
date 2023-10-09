package com.ipvalidation.domain.entities;

import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.*;

import java.util.Date;

@AllArgsConstructor
@NoArgsConstructor
@Getter
@Setter
@ToString
public class InternetAddressLocation {
    @JsonProperty("country_name")
    private String countryName;
    @JsonProperty("region_code")
    private String regionCode;
    private String city;
    private Date createdAt;
}
