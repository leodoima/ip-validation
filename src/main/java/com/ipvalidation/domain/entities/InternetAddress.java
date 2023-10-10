package com.ipvalidation.domain.entities;

import lombok.*;

@AllArgsConstructor
@NoArgsConstructor
@Getter
@Setter
@ToString
public class InternetAddress {
    private String internetAddress;
    private InternetAddressLocation location;

    public InternetAddress(String internetAddress) {
        this.internetAddress = internetAddress;
    }
}
