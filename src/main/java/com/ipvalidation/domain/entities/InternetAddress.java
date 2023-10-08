package com.ipvalidation.domain.entities;

import com.ipvalidation.domain.enums.InternetAddressStatusEnum;
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
    private InternetAddressStatusEnum internetAddressStatusEnum;
}
