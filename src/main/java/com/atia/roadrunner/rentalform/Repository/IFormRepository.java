package com.atia.roadrunner.rentalform.Repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.atia.roadrunner.rentalform.Model.Form;

public interface IFormRepository extends JpaRepository<Form, Long> {
    
}
