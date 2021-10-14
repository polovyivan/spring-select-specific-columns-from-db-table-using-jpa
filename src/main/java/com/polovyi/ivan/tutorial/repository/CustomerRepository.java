package com.polovyi.ivan.tutorial.repository;

import com.polovyi.ivan.tutorial.entity.CustomerEntity;
import com.polovyi.ivan.tutorial.entity.dto.MailingAddressDTO;
import com.polovyi.ivan.tutorial.entity.projection.CustomerJobProjection;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import java.util.List;

public interface CustomerRepository extends JpaRepository<CustomerEntity, String> {

    @Query("SELECT phoneNumber FROM CustomerEntity customer")
    List<String> findPhoneNumbers();

    @Query("SELECT new com.polovyi.ivan.tutorial.entity.dto.MailingAddressDTO (fullName, address) FROM  CustomerEntity customer")
    List<MailingAddressDTO> findMailingAddresses();

    // use of aliases is required
    @Query("SELECT fullName AS fullName, customer.job AS job FROM  CustomerEntity customer ")
    List<CustomerJobProjection> findAllJobs();
}
