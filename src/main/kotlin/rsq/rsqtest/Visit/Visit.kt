package rsq.rsqtest.Visit

import java.time.*
import javax.persistence.*
import rsq.rsqtest.Doctor.Doctor
import rsq.rsqtest.Patient.Patient

@Entity
data class Visit(var date:LocalDate, var time: LocalTime, var place:String,
                 @ManyToOne (fetch = FetchType.EAGER)
                 @JoinColumn (name = "docId")
                 var doctor: Doctor,
                 @ManyToOne (fetch = FetchType.EAGER)
                 @JoinColumn (name = "patJd")
                 var patient: Patient)
{
    fun setNewTime(newTime: LocalTime) {
        time=newTime
    }

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    var id: Int = 0

}

