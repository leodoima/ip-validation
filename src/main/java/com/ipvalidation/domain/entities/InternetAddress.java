package com.ipvalidation.domain.entities;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@AllArgsConstructor
@NoArgsConstructor
@Getter
@Setter
public class InternetAddress {
    private String internetAddress;
    private InternetAddressLocation internetAddressLocation;

    public InternetAddress(String internetAddress) {
        this.internetAddress = internetAddress;
    }
}
