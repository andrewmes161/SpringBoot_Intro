package com.example.AMessier_Project01.Patients;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
public interface PatientsRepository
        extends JpaRepository<Patients, Long> {

    // SELECT * FROM patients WHERE email = ?
    @Query("SELECT s FROM Patients s WHERE s.emailAddress = ?1" )
    Optional<Patients> findPatientsByEmail(String emailAddress);
}
