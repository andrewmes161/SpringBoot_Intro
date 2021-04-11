package com.example.AMessier_Project01.Patients;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping(path = "api/v1/patients")
public class PatientsController {

    private final PatientsService patientsService;

    @Autowired
    public PatientsController(PatientsService patientsService) {
        this.patientsService = patientsService;
    }

    // Gets from Database //
    @GetMapping
    public List<Patients> getPatients() {
        return patientsService.getPatients();
    }


    // Posts to Database //
    @PostMapping
    public void registerNewPatients(@RequestBody Patients patients) {
        patientsService.addNewPatients(patients);
    }

    // Deletes patients by ID from Database //
    @DeleteMapping(path = "{patientId}")
    public void deletePatients(@PathVariable("patientsId") Long patientsId) {
        patientsService.deletePatients(patientsId);

    }

    @PutMapping (path = "{patientsId}")
    public void updatePatients(
            @PathVariable("studentId") Long patientId,
            @RequestParam(required = false) String firstName,
            @RequestParam(required = false) String lastName,
            @RequestParam(required = false) String phoneNumber,
            @RequestParam(required = false) String email) {
        patientsService.updatePatients(patientId, firstName, lastName, phoneNumber, email);
    }
}