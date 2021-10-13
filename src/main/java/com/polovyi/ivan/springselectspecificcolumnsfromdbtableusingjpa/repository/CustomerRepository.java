package com.polovyi.ivan.springselectspecificcolumnsfromdbtableusingjpa.repository;

import com.polovyi.ivan.springselectspecificcolumnsfromdbtableusingjpa.entity.CustomerEntity;
import com.polovyi.ivan.springselectspecificcolumnsfromdbtableusingjpa.entity.dto.MailingAddressDTO;
import com.polovyi.ivan.springselectspecificcolumnsfromdbtableusingjpa.entity.projection.CustomerJobProjection;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import java.util.List;

public interface CustomerRepository extends JpaRepository<CustomerEntity, String> {

    @Query("SELECT phoneNumber FROM  CustomerEntity customer")
    List<String> findPhoneNumbers();

    @Query("SELECT new com.polovyi.ivan.springselectspecificcolumnsfromdbtableusingjpa.entity.dto.MailingAddressDTO (fullName, address) FROM  CustomerEntity customer")
    List<MailingAddressDTO> findMailingAddresses();

    @Query("SELECT customer FROM  CustomerEntity customer")
    List<CustomerJobProjection> findAllJobs();
}
