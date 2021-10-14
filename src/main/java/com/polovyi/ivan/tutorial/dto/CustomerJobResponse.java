package com.polovyi.ivan.tutorial.dto;

import com.polovyi.ivan.tutorial.entity.projection.CustomerJobProjection;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class CustomerJobResponse {

    private String fullName;

    private String job;

    public static CustomerJobResponse valueOf(CustomerJobProjection customerJobProjection) {
        return builder()
                .fullName(customerJobProjection.getFullName())
                .job(customerJobProjection.getJob())
                .build();
    }
}