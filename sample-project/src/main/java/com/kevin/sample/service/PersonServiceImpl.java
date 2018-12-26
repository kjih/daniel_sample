package com.kevin.sample.service;

import com.kevin.sample.model.Person;
import com.kevin.sample.repository.PersonRepository;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
public class PersonServiceImpl implements PersonService {

    @Autowired
    private PersonRepository personRepository;

    /**
     * {@inheritDoc}
     */
    @Override
    public Person getPerson(int id) throws PersonNotFoundException {
        Optional<Person> person = personRepository.findById(id);

        if (!person.isPresent()) {
            throw new PersonNotFoundException();
        }

        return person.get();
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public Iterable<Person> getAll() {
        return personRepository.findAll();
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public Person createPerson(Person person) {
        // TODO: Validation. Check fields are valid.
        personRepository.save(person);
        return person;
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public void editPerson(int id, Person person) {
        // TODO: Validation. Check id matches person.id, check person exists, etc.
        // TODO: Implement
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public void deletePerson(int id) throws PersonNotFoundException {
        Optional<Person> person = personRepository.findById(id);

        if (!person.isPresent()) {
            throw new PersonNotFoundException();
        }

        personRepository.deleteById(id);
    }
}
