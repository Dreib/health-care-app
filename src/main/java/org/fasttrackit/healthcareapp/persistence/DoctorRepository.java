package org.fasttrackit.healthcareapp.persistence;

import org.fasttrackit.healthcareapp.domain.Doctor;
import org.springframework.data.jpa.repository.JpaRepository;

public interface DoctorRepository extends JpaRepository <Doctor, Long> {
}
