package com.springexercise.eazyschool.repository;

import com.springexercise.eazyschool.model.Address;
import org.springframework.data.jpa.repository.JpaRepository;

public interface AddressRepository extends JpaRepository<Address, Integer> {
}
