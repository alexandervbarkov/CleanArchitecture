package com.alexandervbarkov.cleanarchitecture;

import com.alexandervbarkov.cleanarchitecture.commoncore.customer.usecase.create.CreateCustomer;
import com.alexandervbarkov.cleanarchitecture.commoncore.customer.usecase.search.SearchCustomers;
import com.alexandervbarkov.cleanarchitecture.customercore.usecase.create.CreateCustomerFacade;
import com.alexandervbarkov.cleanarchitecture.customercore.usecase.search.SearchCustomerFacade;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Primary;

@Configuration
public class BeanConfig {
    @Primary
    @Bean
    public CreateCustomer createCustomer(CreateCustomerFacade facade) {
        return facade;
    }

    @Primary
    @Bean
    public SearchCustomers searchCustomers(SearchCustomerFacade facade) {
        return facade;
    }
}
