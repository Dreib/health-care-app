package org.fasttrackit.healthcareapp.persistence;

import org.fasttrackit.healthcareapp.domain.Appointment;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;

public interface AppointmentRepository extends JpaRepository<Appointment, Long> {

    Page<Appointment> findByPerson_cnp(int person_cnp, Pageable pageable);

}
