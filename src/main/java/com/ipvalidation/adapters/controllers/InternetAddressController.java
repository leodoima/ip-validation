package com.ipvalidation.adapters.controllers;

import com.ipvalidation.domain.dtos.InternetAddressRequest;
import com.ipvalidation.domain.dtos.InternetAddressResponse;
import com.ipvalidation.usecases.services.InternetAddressService;
import jakarta.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/internet-address")
public class InternetAddressController {

    @Autowired
    private InternetAddressService internetAddressService;

    @PostMapping("/register")
    public ResponseEntity<String> register(@RequestBody @Valid List<InternetAddressRequest> internetAddressRequestList) {
        internetAddressService.register(internetAddressRequestList);
        return ResponseEntity.ok().build();
    }

    @GetMapping("/list")
    public ResponseEntity<List<InternetAddressResponse>> list() {
        return ResponseEntity.ok().body(internetAddressService.getAddressResponseList());
    }
}
