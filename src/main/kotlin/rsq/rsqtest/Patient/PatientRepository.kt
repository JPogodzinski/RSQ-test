package rsq.rsqtest.Patient

import org.springframework.data.jpa.repository.JpaRepository

interface PatientRepository:JpaRepository<Patient,Int>