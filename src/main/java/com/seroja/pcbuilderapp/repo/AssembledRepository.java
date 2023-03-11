package com.seroja.pcbuilderapp.repo;

import com.seroja.pcbuilderapp.entities.Assembled;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

public interface AssembledRepository extends JpaRepository<Assembled, Integer> {

    @Query(value = """
            select sum(cases.price + cpu.price + gpu.price + motherboards.price + power_units.price + (assembled.ram_amount * ram.price) + (assembled.drives_amount * drives.price) ) complete_price
            from assembled
                     left join cases on cases.id = assembled.case_id
                     left join cpu on cpu.id = assembled.cpu_id
                    left join gpu on assembled.gpu_id = gpu.id
                    left join motherboards on assembled.motherboard_id = motherboards.id
                    left join power_units on assembled.power_unit_id = power_units.id
                    left join ram on assembled.ram_id = ram.id
                    left join drives on assembled.drive_id = drives.id where assembled.id = ?1\s""", nativeQuery = true)
    int calculateTotalPrice(int id);
}
