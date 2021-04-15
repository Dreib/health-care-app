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

    @GetMapping
    public ResponseEntity<Person> getPerson(Long cnp) {
        Person person = personService.getPerson(cnp);
        return ResponseEntity.ok(person);
    }

    @PutMapping
    public ResponseEntity<Person> updatePerson(@RequestBody @Valid SavePersonRequest request) {
        Person person = personService.updatePerson(request);
        return ResponseEntity.ok(person);
    }

    @DeleteMapping
    public ResponseEntity<Void> deletePerson(Long cnp) {
        personService.deletePerson(cnp);
        return new ResponseEntity<>(HttpStatus.NO_CONTENT);
    }
}
