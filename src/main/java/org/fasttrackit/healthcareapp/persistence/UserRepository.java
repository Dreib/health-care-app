package org.fasttrackit.healthcareapp.persistence;

import org.fasttrackit.healthcareapp.domain.User;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

public interface UserRepository extends JpaRepository <User, Long> {

    //JPQL
    @Query(value = "SELECT user FROM User user " +
            "WHERE (:partialFirstName IS NULL OR user.firstName LIKE %:partialFirstName%) " +
            "AND (:partialLastName IS NULL OR user.lastName LIKE %:partialLastName%)")
    Page<User> findByOptionalCriteria(String partialFirstName,
                                      String partialLastName, Pageable pageable);

}
