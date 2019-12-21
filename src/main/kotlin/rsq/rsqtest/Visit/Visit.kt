package rsq.rsqtest.Visit

import java.time.*
import javax.persistence.*
import rsq.rsqtest.Doctor.Doctor
import rsq.rsqtest.Patient.Patient

@Entity
data class Visit(var date:LocalDate, var time: LocalTime, var place:String,
                 @OneToOne
                 @JoinColumn
                 var doctor: Doctor,
                 @OneToOne
                 @JoinColumn
                 var patient: Patient)
{
    @Id
    @GeneratedValue
    var id: Int = 0
}