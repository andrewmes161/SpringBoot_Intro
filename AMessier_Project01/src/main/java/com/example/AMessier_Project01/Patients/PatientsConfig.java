package com.example.AMessier_Project01.Patients;


import org.springframework.boot.CommandLineRunner;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import java.time.LocalDate;
import java.time.Month;
import java.util.List;

@Configuration
public class PatientsConfig {

    @Bean // Enters/Logs new patients into the database
    CommandLineRunner commandLineRunner(PatientsRepository repository) {
        return args -> {
            Patients andrew = new Patients(
                    "Andrew",
                    "Messier",
                    "andrew.messier@snhu.edu",
                    "5088839561",
                    "MALE",
                    LocalDate.of(1995, Month.FEBRUARY, 23)
            );

            Patients matthew = new Patients(
                    "Matthew",
                    "Messier",
                    "matthew.messier@snhu.edu",
                    "5088839561",
                    "MALE",
                    LocalDate.of(1999, Month.OCTOBER, 14)
            );

            // SAVES to database in psql
            repository.saveAll(
                    List.of(andrew, matthew)
            );
        };
    }

}
