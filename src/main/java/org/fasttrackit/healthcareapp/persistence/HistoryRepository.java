package org.fasttrackit.healthcareapp.persistence;

import org.fasttrackit.healthcareapp.domain.History;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

public interface HistoryRepository extends JpaRepository<History, Integer> {



}
