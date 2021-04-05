package org.fasttrackit.healthcareapp.persistence;

import org.fasttrackit.healthcareapp.domain.Appointment;
import org.fasttrackit.healthcareapp.domain.Person;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;

import java.sql.Date;

public interface AppointmentRepository extends JpaRepository<Appointment, Long> {

    Page<Appointment> findByPerson_cnp(Person person_cnp, Pageable pageable);
    Page<Appointment> findByDate(Date data, Pageable pageable);

}
