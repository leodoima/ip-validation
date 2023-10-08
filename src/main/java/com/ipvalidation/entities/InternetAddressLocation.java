package com.ipvalidation.entities;

import com.fasterxml.jackson.annotation.JsonProperty;
import com.google.gson.annotations.SerializedName;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.util.Date;

@AllArgsConstructor
@NoArgsConstructor
@Getter
@Setter
public class InternetAddressLocation {
    @SerializedName("country_name")
    private String countryName;
    @SerializedName("region_code")
    private String regionCode;
    private String city;
    private Date createdAt;
}
