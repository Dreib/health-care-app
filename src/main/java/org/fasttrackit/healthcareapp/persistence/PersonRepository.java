package org.fasttrackit.healthcareapp.persistence;

import org.fasttrackit.healthcareapp.domain.Person;
import org.springframework.data.jpa.repository.JpaRepository;

public interface PersonRepository extends JpaRepository<Person, Long> {

    /*
    //JPQL
    @Query(value = "SELECT Person FROM Person person " +
            "WHERE (:nume IS NULL OR person.nume LIKE %:nume%)" +
            "OR (:prenume IS NULL OR person.prenume LIKE %:prenume%)" +
            "OR (:judet IS NULL OR person.judet LIKE %:judet%)" +
            "OR (:localitate IS NULL OR person.localitate LIKE %:localitate%)" +
            "OR (:strada IS NULL OR person.strada LIKE %:strada%)" +
            "OR (:tip IS NULL OR person.tip LIKE %:tip%)")
    Page<Person> findByOptionalCriteria(String nume, String prenume, String judet,
                                        String localitate, String strada, String tip, Pageable pageable);
     */

    Person findPersonByCnp(long cnp);
    Person deletePersonByCnp(long cnp);

}
