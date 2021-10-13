package com.polovyi.ivan.springselectspecificcolumnsfromdbtableusingjpa.dto;

import com.polovyi.ivan.springselectspecificcolumnsfromdbtableusingjpa.entity.projection.CustomerJobProjection;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class CustomerJobResponse {

    private String id;

    private String fullName;

    private String job;

    public static CustomerJobResponse valueOf(CustomerJobProjection customerJobProjection) {
        return builder()
                .id(customerJobProjection.getId())
                .fullName(customerJobProjection.getFullName())
                .job(customerJobProjection.getJob())
                .build();
    }
}