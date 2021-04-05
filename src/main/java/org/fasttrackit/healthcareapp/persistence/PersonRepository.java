package org.fasttrackit.healthcareapp.persistence;

import org.fasttrackit.healthcareapp.domain.Person;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

public interface PersonRepository extends JpaRepository<Person, Integer> {

    //JPQL
    @Query(value = "SELECT persoana FROM Person persoana " +
            "WHERE (:partialFirstName IS NULL OR persoana.nume LIKE %:partialFirstName%) " +
            "AND (:partialLastName IS NULL OR persoana.prenume LIKE %:partialLastName%)")
    Page<Person> findByOptionalCriteria(String partialFirstName,
                                      String partialLastName, Pageable pageable);

}
