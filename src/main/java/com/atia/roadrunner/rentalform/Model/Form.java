package com.atia.roadrunner.rentalform.Model;

import java.time.LocalDateTime;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Entity (name = "Forms")
@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor


public class Form {
    
   @Id
    @GeneratedValue(strategy = GenerationType.AUTO)

    private Long id;
    private String name;
    private String address;
    private String number;
    private LocalDateTime pickup;
    private Long productId;
    private LocalDateTime drop;
    private String driverLicense;
    private double totalPrice;
    private double orderPrice;

}
