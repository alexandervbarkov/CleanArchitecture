package com.alexandervbarkov.cleanarchitecture.customer.infrastructure.jpa;

import org.springframework.data.jpa.repository.JpaRepository;

public interface CustomerRepo extends JpaRepository<CustomerEntity, Long> {
}
