package com.seroja.pcbuilderapp.repo;

import com.seroja.pcbuilderapp.entities.Case;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

public interface CaseRepository extends JpaRepository<Case, Integer> {

    @Query(value = "select * from cases where (select max(price <= ?)) ORDER BY price LIMIT 1", nativeQuery = true)
    Case getBudgetCase(int budgetPart);

}
