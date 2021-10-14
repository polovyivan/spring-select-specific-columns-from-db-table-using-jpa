package com.polovyi.ivan.tutorial.entity.dto;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class MailingAddressDTO {

    private String fullName;

    private String address;
}
