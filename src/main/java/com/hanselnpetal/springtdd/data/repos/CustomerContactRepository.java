package com.hanselnpetal.springtdd.data.repos;

import org.springframework.data.repository.CrudRepository;

import com.hanselnpetal.springtdd.domain.CustomerContact;

public interface CustomerContactRepository extends CrudRepository<CustomerContact, Long> {

	CustomerContact findByEmail(String email);
}

