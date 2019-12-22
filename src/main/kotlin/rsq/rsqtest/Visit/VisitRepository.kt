package rsq.rsqtest.Visit

import org.springframework.data.jpa.repository.JpaRepository


interface VisitRepository:JpaRepository<Visit, Int> {

    fun findAllByPatientPatId(patientId: Int):List<Visit>
}