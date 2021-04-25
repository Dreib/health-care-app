package org.fasttrackit.healthcareapp.service;

import org.apache.velocity.exception.ResourceNotFoundException;
import org.fasttrackit.healthcareapp.domain.Person;
import org.fasttrackit.healthcareapp.persistence.PersonRepository;
import org.fasttrackit.healthcareapp.transfer.person.GetPersonsRequest;
import org.fasttrackit.healthcareapp.transfer.person.SavePersonRequest;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

import java.util.List;


@Service
public class PersonService {

    private static final Logger LOGGER = LoggerFactory.getLogger(PersonService.class);

    private final PersonRepository personRepository;

    @Autowired
    public PersonService(PersonRepository personRepository) {
        this.personRepository = personRepository;
    }

    public Person addPerson(SavePersonRequest request) {
        LOGGER.info("Adding person: {}", request);

        Person person = new Person();
        person.setCnp(request.getCnp());
        person.setNume(request.getNume());
        person.setPrenume(request.getPrenume());
        person.setJudet(request.getJudet());
        person.setLocalitate(request.getLocalitate());
        person.setStrada(request.getStrada());
        person.setNumar(request.getNumar());
        person.setBloc(request.getBloc());
        person.setEtaj(request.getEtaj());
        person.setApartament(request.getApartament());
        person.setTip(request.getTip());

        return personRepository.save(person);
    }

    public Person getPerson(long cnp) {
        LOGGER.info("Retrieving person {}", cnp);

        Person personFound = new Person();

        try {
            personFound = personRepository.findPersonByCnp(cnp);
        } catch (Exception e) {
            new ResourceNotFoundException("Person " + cnp + " does not exist.");
        }

        return personFound;
    }

    public List<Person> getPersons(GetPersonsRequest request) {
        LOGGER.info("Retrieving persons {}", request);
        return personRepository.findAll();
    }

    public Person updatePerson(SavePersonRequest request) {
        LOGGER.info("Updating person {}: {}", request.getCnp(), request);

        Person existingPerson = getPerson(request.getCnp());

        BeanUtils.copyProperties(request, existingPerson);

        return personRepository.save(existingPerson);
    }

    public void deletePerson(long cnp) {
        LOGGER.info("Removing person {}", cnp);
        personRepository.deleteById(cnp);
    }

}
