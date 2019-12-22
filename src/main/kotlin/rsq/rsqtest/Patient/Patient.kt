package rsq.rsqtest.Patient

import rsq.rsqtest.Visit.Visit
import javax.persistence.*

@Entity
data class Patient(var firstName:String, var surname:String, var address:String)
{
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    var patId: Int = 0

}