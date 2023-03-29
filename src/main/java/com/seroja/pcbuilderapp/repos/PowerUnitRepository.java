package com.seroja.pcbuilderapp.repos;

import com.seroja.pcbuilderapp.entities.PowerUnit;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

public interface PowerUnitRepository extends JpaRepository<PowerUnit, Integer> {

    @Query(value = "select * from power_units where (select max(price <= ?))ORDER BY price LIMIT 1", nativeQuery = true)
    PowerUnit getBudgetPowerUnit(int budgetPart);

}
