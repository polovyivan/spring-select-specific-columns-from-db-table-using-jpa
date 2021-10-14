package com.polovyi.ivan.tutorial.controller;

import com.polovyi.ivan.tutorial.dto.CustomerJobResponse;
import com.polovyi.ivan.tutorial.dto.CustomerMailingAddressResponse;
import com.polovyi.ivan.tutorial.dto.CustomerResponse;
import com.polovyi.ivan.tutorial.dto.CustomerPhoneNumberResponse;
import com.polovyi.ivan.tutorial.service.CustomerService;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping(path = "/v1/customers")
public record CustomerController(CustomerService customerService) {

    @GetMapping
    @ResponseStatus(HttpStatus.OK)
    public List<CustomerResponse> getAllCustomers() {
        return customerService.getAllCustomers();
    }

    @GetMapping(path = "/phones")
    @ResponseStatus(HttpStatus.OK)
    public List<CustomerPhoneNumberResponse> getAllPhoneNumbers() {
        return customerService.getAllPhoneNumbers();
    }

    @GetMapping(path = "/mailing-address")
    @ResponseStatus(HttpStatus.OK)
    public List<CustomerMailingAddressResponse> getAllMailingAddresses() {
        return customerService.getAllMailingAddresses();
    }

    @GetMapping(path = "/jobs")
    @ResponseStatus(HttpStatus.OK)
    public List<CustomerJobResponse> findAllCustomersAndJobs() {
        return customerService.findAllJobs();
    }

}
