package com.example.AMessier_Project01.Patients;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.transaction.Transactional;
import java.time.LocalDate;
import java.time.Month;
import java.util.List;
import java.util.Objects;
import java.util.Optional;

@Service
public class PatientsService {

    private final PatientsRepository patientsRepository;

    @Autowired
    public PatientsService(PatientsRepository patientsRepository) {
        this.patientsRepository = patientsRepository;
    }

    public List<Patients> getPatients() {
        return patientsRepository.findAll();
   }

    public void addNewPatients(Patients patients) {
        Optional<Patients> patientsOptional = patientsRepository
                .findPatientsByEmail(patients.getEmailAddress());

        if(patientsOptional.isPresent()) {
            throw new IllegalStateException("email has been taken...");
        }
        patientsRepository.save(patients);
    }

    public void deletePatients(Long patientId) {
        boolean exists = patientsRepository.existsById(patientId);
        if(!exists) {
            throw new IllegalStateException("patient with id" + patientId + "does not exist");
        }
        patientsRepository.deleteById(patientId);
    }

    @Transactional
    public void updatePatients(Long patientsId, String firstName, String lastName,
                               String phoneNumber, String email) {
        Patients patients = patientsRepository.findById(patientsId)
                .orElseThrow(() -> new IllegalStateException(
                        "patient with id " + patientsId + " does not exist"));


        // Changes First Name //
        if (firstName != null &&
                firstName.length() > 0 &&
                !Objects.equals(patients.getFirstName(), firstName)) {
            patients.setFirstName(firstName);
        }

        // Changes Last Name //
        if (lastName != null &&
                lastName.length() > 0 &&
                !Objects.equals(patients.getLastName(), lastName)) {
            patients.setLastName(lastName);
        }
        // Changes Phone Number //
        if (phoneNumber != null &&
        phoneNumber.length() > 0 &&
        !Objects.equals(patients.getPhoneNumber(), phoneNumber)) {
            patients.setPhoneNumber(phoneNumber);
        }

        // Changes Email //
        if (email != null &&
                email.length() > 0 &&
                !Objects.equals(patients.getEmailAddress(), email)) {
            Optional<Patients> patientsOptional = patientsRepository.findPatientsByEmail(email);
            if(patientsOptional.isPresent()) { // Flag error if email is already taken
                throw new IllegalStateException("email is already taken...");
            }
            patients.setEmailAddress(email);

        }

    }
}
