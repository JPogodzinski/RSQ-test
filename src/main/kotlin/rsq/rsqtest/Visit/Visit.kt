package rsq.rsqtest.Visit

import java.time.*
import javax.persistence.*
import rsq.rsqtest.Doctor.Doctor
import rsq.rsqtest.Patient.Patient

@Entity
data class Visit(var date:LocalDate, var time: LocalTime, var place:String,
                 @ManyToOne @JoinColumn
                 var doctor: Doctor,
                 @ManyToOne @JoinColumn
                 var patient: Patient)
{
    @Id @GeneratedValue(strategy = GenerationType.IDENTITY)
    var id: Int = 0
}