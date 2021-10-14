package com.polovyi.ivan.tutorial.service;

import com.polovyi.ivan.tutorial.dto.CustomerJobResponse;
import com.polovyi.ivan.tutorial.dto.CustomerMailingAddressResponse;
import com.polovyi.ivan.tutorial.dto.CustomerResponse;
import com.polovyi.ivan.tutorial.dto.CustomerPhoneNumberResponse;
import com.polovyi.ivan.tutorial.repository.CustomerRepository;
import lombok.extern.slf4j.Slf4j;

import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

@Slf4j
@Service
public record CustomerService(CustomerRepository customerRepository) {

    public List<CustomerResponse> getAllCustomers() {
        log.info("Getting all customers...");
        return customerRepository.findAll().stream().map(CustomerResponse::valueOf).collect(Collectors.toList());
    }

    public List<CustomerPhoneNumberResponse> getAllPhoneNumbers() {
        log.info("Getting all phone numbers...");
        return customerRepository.findPhoneNumbers().stream().map(CustomerPhoneNumberResponse::new)
                .collect(Collectors.toList());
    }

    public List<CustomerMailingAddressResponse> getAllMailingAddresses() {
        log.info("Getting all mailing addresses...");
        return customerRepository.findMailingAddresses().stream().map(CustomerMailingAddressResponse::valueOf)
                .collect(Collectors.toList());
    }

    public List<CustomerJobResponse> findAllJobs() {
        log.info("Getting all jobs...");
        return customerRepository.findAllJobs().stream().map(CustomerJobResponse::valueOf).collect(Collectors.toList());
    }
}

