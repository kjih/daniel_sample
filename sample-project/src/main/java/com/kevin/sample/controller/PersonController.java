package com.kevin.sample.controller;

import com.kevin.sample.model.Person;
import com.kevin.sample.service.PersonNotFoundException;
import com.kevin.sample.service.PersonService;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

@Controller
@RequestMapping(path="/person")
public class PersonController {

    @Autowired
    PersonService service;

    @ExceptionHandler(PersonNotFoundException.class)
    @ResponseStatus(value = HttpStatus.NOT_FOUND)
    public void handleNotFoundException() {
        // 404
    }


    @GetMapping(path="")
    @ResponseBody
    public Iterable<Person> getAllPerson() {
        return service.getAll();
    }

    @GetMapping(path="/{id}")
    @ResponseBody
    public Person getPerson(@PathVariable int id) throws PersonNotFoundException {
        return service.getPerson(id);
    }

    @PostMapping(path="")
    @ResponseStatus(value = HttpStatus.CREATED)
    @ResponseBody
    public Person createPerson(@RequestBody Person person) {
        return service.createPerson(person);
    }

    // TODO: Implement create person controller.
    // TODO: Implement edit person controller.
    // TODO: Implement delete person controller.
}
