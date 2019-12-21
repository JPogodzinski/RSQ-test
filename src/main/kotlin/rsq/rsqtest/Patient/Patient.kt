package rsq.rsqtest.Patient

import javax.persistence.*

@Entity
data class Patient(var firstName:String, var surname:String, var address:String)
{
    @Id @GeneratedValue(strategy = GenerationType.IDENTITY)
    var id: Int = 0
}