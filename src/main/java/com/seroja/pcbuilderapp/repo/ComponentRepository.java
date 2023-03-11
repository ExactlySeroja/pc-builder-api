package com.seroja.pcbuilderapp.repo;

import com.seroja.pcbuilderapp.entities.Component;
import org.springframework.data.jpa.repository.JpaRepository;

public interface ComponentRepository extends JpaRepository<Component, Integer> {
}
