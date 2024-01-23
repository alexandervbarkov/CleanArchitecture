package com.alexandervbarkov.cleanarchitecture.customerinfrastructure.jpa;

import org.springframework.data.jpa.repository.JpaRepository;

public interface CustomerRepo extends JpaRepository<CustomerEntity, Long> {
}
