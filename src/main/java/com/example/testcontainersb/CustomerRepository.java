package com.example.testcontainersb;

import org.springframework.data.repository.ListCrudRepository;
import org.springframework.data.rest.core.annotation.RepositoryRestResource;

@RepositoryRestResource
public interface CustomerRepository extends ListCrudRepository<Customer, Long> { }
