package org.fasttrackit.healthcareapp.persistence;

import org.fasttrackit.healthcareapp.domain.Person;
import org.springframework.data.jpa.repository.JpaRepository;

public interface PersonRepository extends JpaRepository<Person, Long> {

    Person findPersonByCnp(long cnp);
    Person findPersonByNume(String nume);

}
