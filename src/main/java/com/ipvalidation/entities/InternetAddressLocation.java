package com.ipvalidation.entities;

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
    private String country_name;
    private String region_code;
    private String city;
    private Date created_at;
}
