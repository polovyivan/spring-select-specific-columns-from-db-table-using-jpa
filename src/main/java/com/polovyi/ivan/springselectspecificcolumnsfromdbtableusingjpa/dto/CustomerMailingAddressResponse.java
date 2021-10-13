package com.polovyi.ivan.springselectspecificcolumnsfromdbtableusingjpa.dto;

import com.polovyi.ivan.springselectspecificcolumnsfromdbtableusingjpa.entity.dto.MailingAddressDTO;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class CustomerMailingAddressResponse {

    private String fullName;

    private String address;

    public static CustomerMailingAddressResponse valueOf(MailingAddressDTO mailingAddress) {
        return builder()
                .fullName(mailingAddress.getFullName())
                .address(mailingAddress.getAddress())
                .build();
    }
}
