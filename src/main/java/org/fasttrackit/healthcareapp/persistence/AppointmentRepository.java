package org.fasttrackit.healthcareapp.persistence;

import org.fasttrackit.healthcareapp.domain.Appointment;
import org.springframework.data.jpa.repository.JpaRepository;

public interface AppointmentRepository extends JpaRepository<Appointment, Long> {



}
