package com.kevin.sample.service;

import com.kevin.sample.model.Person;
import org.springframework.stereotype.Service;

@Service
public interface PersonService {
    /**
     * Get a single {@link Person}.
     * @param id
     * @return {@link Person}.
     */
    Person getPerson(int id) throws PersonNotFoundException;

    /**
     * Get a list of all {@link Person} objects.
     * @return {@link Person} array.
     */
    Iterable<Person> getAll();

    /**
     * Create a {@link Person}.
     * @param person
     */
    Person createPerson(Person person);

    /**
     * Edit a {@link Person}.
     * @param id
     * @param person
     */
    void editPerson(int id, Person person);

    /**
     * Delete a {@link Person}
     * @param id
     */
    void deletePerson(int id) throws PersonNotFoundException;
}
