package com.ipvalidation.adapters.apis;

import com.ipvalidation.domain.entities.InternetAddressLocation;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;

@FeignClient(name = "ip-stack", url = "http://api.ipstack.com/")
public interface IpStack {

    @GetMapping(value = "/{internetAddress}?access_key=${api.ipstack.key}")
    InternetAddressLocation getIpStack(@PathVariable String internetAddress);
}
