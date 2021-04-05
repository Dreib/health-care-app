package org.fasttrackit.healthcareapp.service;

import org.apache.velocity.exception.ResourceNotFoundException;
import org.fasttrackit.healthcareapp.domain.Person;
import org.fasttrackit.healthcareapp.persistence.PersonRepository;
import org.fasttrackit.healthcareapp.transfer.person.SavePersonRequest;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class PersonService {

    private static final Logger LOGGER = LoggerFactory.getLogger(PersonService.class);

    private final PersonRepository personRepository;

    @Autowired
    public PersonService(PersonRepository personRepository) {
        this.personRepository = personRepository;
    }

    public Person addPerson(SavePersonRequest request) {
        LOGGER.info("Adding person {}", request);

        Person person = new Person();
        person.setCnp(request.getCnp());
        person.setNume(request.getNume());
        person.setPrenume(request.getPrenume());

        return personRepository.save(person);
    }

    public Person getPerson(int cnp) {
        LOGGER.info("Retrieving person {}", cnp);

        return personRepository.findById(cnp)
                .orElseThrow(() -> new ResourceNotFoundException("Person " + cnp + " does not exist"));
    }

    public Person updatePerson(int cnp, SavePersonRequest request) {
        LOGGER.info("Updating person {}: {}", cnp, request);

        Person existingPerson = getPerson(cnp);

        BeanUtils.copyProperties(request, existingPerson);

        return personRepository.save(existingPerson);
    }

    public void deletePerson(int cnp) {
        LOGGER.info("Removing person {}", cnp);
        personRepository.deleteById(cnp);
    }

}
