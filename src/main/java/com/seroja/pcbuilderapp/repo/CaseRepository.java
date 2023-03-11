package com.seroja.pcbuilderapp.repo;

import com.seroja.pcbuilderapp.entities.Case;
import org.springframework.data.jpa.repository.JpaRepository;

public interface CaseRepository extends JpaRepository<Case, Integer> {
}
