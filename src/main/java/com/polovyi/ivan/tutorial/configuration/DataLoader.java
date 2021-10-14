package com.polovyi.ivan.tutorial.configuration;


import com.github.javafaker.Faker;
import com.polovyi.ivan.tutorial.entity.CustomerEntity;
import com.polovyi.ivan.tutorial.repository.CustomerRepository;
import org.springframework.beans.factory.InitializingBean;
import org.springframework.context.annotation.Bean;
import org.springframework.stereotype.Component;

import java.time.LocalDate;
import java.time.Period;
import java.util.List;
import java.util.Random;
import java.util.stream.IntStream;

import static java.util.stream.Collectors.toList;

@Component
public record DataLoader(CustomerRepository customerRepository) {

    @Bean
    private InitializingBean sendDatabase() {
        return () -> {
            customerRepository.saveAll(generateCustomerList());
        };
    }

    private List<CustomerEntity> generateCustomerList() {
        Faker faker = new Faker();
        return IntStream.range(0, 5)
                .mapToObj(i -> CustomerEntity.builder().createdAt(
                        LocalDate.now().minus(Period.ofDays((new Random().nextInt(365 * 10)))))
                        .fullName(faker.name().fullName())
                        .phoneNumber(faker.phoneNumber().cellPhone())
                        .address(faker.address().fullAddress())
                        .job(faker.job().title())
                        .build())
                .collect(toList());
    }

}
