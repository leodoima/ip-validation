package com.ipvalidation.adapters.controllers;

import com.ipvalidation.domain.dtos.InternetAddress;
import com.ipvalidation.domain.dtos.InternetAddressResponse;
import com.ipvalidation.usecases.services.InternetAddressService;
import jakarta.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/internet-address")
public class InternetAddressController {

    @Autowired
    private InternetAddressService internetAddressService;

    @PostMapping("/register")
    public List<InternetAddressResponse> register(@RequestBody @Valid List<InternetAddress> internetAddressList) {
        return internetAddressService.register(internetAddressList);
    }
}
