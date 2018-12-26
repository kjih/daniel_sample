package com.kevin.sample.repository;

import com.kevin.sample.model.Person;

import org.springframework.data.repository.CrudRepository;

public interface PersonRepository extends CrudRepository<Person, Integer> {
}
