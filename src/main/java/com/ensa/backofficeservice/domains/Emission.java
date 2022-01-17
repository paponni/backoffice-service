package com.ensa.backofficeservice.domains;

import com.ensa.backofficeservice.enums.EmissionType;

import java.time.LocalDateTime;

public class Emission {

    private Long id;
    private Transfer transfer;
    private Long agent;
    private  Long agence;
    private EmissionType emissionType; //By Agent - By Gab
    private LocalDateTime emissionDate;
}
