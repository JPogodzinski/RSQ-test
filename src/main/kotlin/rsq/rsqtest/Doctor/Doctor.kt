package rsq.rsqtest.Doctor

import rsq.rsqtest.Visit.Visit
import javax.persistence.*

@Entity
data class Doctor(var firstName:String, var surname:String, var spec:String)
{
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    var docId: Int = 0

}