package org.fasttrackit.healthcareapp.persistence;

import org.fasttrackit.healthcareapp.domain.Appointment;
import org.fasttrackit.healthcareapp.domain.Person;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;

import java.sql.Date;
import java.sql.Time;

public interface AppointmentRepository extends JpaRepository<Appointment, Integer> {

    Appointment findAppointmentByPersoncnp(long personcnp);
    Appointment deleteAppointmentByPersoncnp(long personcnp);

}
