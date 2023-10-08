package com.ipvalidation.services;

import com.fasterxml.jackson.databind.util.JSONPObject;
import com.google.gson.Gson;
import com.google.gson.JsonObject;
import com.ipvalidation.entities.InternetAddressLocation;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.cache.annotation.Cacheable;
import org.springframework.stereotype.Service;

import java.util.Date;

@Service
public class InternetAddressLocationService {

    @Autowired
    private ModelMapper modelMapper;

    @Cacheable(value = "locationInternetAddress")
    public InternetAddressLocation findLocationInternetAddress(String internetAddress) {
        System.out.println("Find location");

        String jsonString = "{\n" +
                "  \"ip\": \"134.201.250.155\",\n" +
                "  \"hostname\": \"134.201.250.155\",\n" +
                "  \"type\": \"ipv4\",\n" +
                "  \"continent_code\": \"NA\",\n" +
                "  \"continent_name\": \"North America\",\n" +
                "  \"country_code\": \"US\",\n" +
                "  \"country_name\": \"United States\",\n" +
                "  \"region_code\": \"CA\",\n" +
                "  \"region_name\": \"California\",\n" +
                "  \"city\": \"Los Angeles\",\n" +
                "  \"zip\": \"90013\"}";
        JsonObject jsonObject = new Gson().fromJson(jsonString, JsonObject.class);

        InternetAddressLocation location = new Gson().fromJson(jsonObject, InternetAddressLocation.class);
        location.setCreatedAt(new Date());

        return location;
    }
}
