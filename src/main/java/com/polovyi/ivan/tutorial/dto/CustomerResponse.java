package com.polovyi.ivan.tutorial.dto;

import com.polovyi.ivan.tutorial.entity.CustomerEntity;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.time.LocalDate;

@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class CustomerResponse {

    private String id;

    private String fullName;

    private String phoneNumber;

    private String address;

    private String job;

    private LocalDate createdAt;

    public static CustomerResponse valueOf(CustomerEntity customer) {
        return builder()
                .id(customer.getId())
                .fullName(customer.getFullName())
                .phoneNumber(customer.getPhoneNumber())
                .address(customer.getAddress())
                .job(customer.getJob())
                .createdAt(customer.getCreatedAt())
                .build();
    }
}
