package org.fasttrackit.healthcareapp.web;

import org.fasttrackit.healthcareapp.domain.Person;
import org.fasttrackit.healthcareapp.service.PersonService;
import org.fasttrackit.healthcareapp.transfer.person.SavePersonRequest;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;

@CrossOrigin
@RestController
@RequestMapping("/persoana")
public class PersonController {

    private final PersonService personService;

    @Autowired
    public PersonController(PersonService personService) {
        this.personService = personService;
    }

    @PostMapping
    public ResponseEntity<Person> addPerson(@RequestBody @Valid SavePersonRequest request) {
        Person person = personService.addPerson(request);
        return new ResponseEntity<>(person, HttpStatus.CREATED);
    }

    @GetMapping("/{cnp}")
    public ResponseEntity<Person> getPerson(@PathVariable int cnp) {
        Person person = personService.getPerson(cnp);
        return ResponseEntity.ok(person);
    }

    @PutMapping("/{cnp}")
    public ResponseEntity<Person> updatePerson(@PathVariable int cnp, @RequestBody @Valid SavePersonRequest request) {
        Person person = personService.updatePerson(cnp, request);
        return ResponseEntity.ok(person);
    }

    @DeleteMapping("/{cnp}")
    public ResponseEntity<Void> deletePerson(@PathVariable int cnp) {
        personService.deletePerson(cnp);
        return new ResponseEntity<>(HttpStatus.NO_CONTENT);
    }
}




