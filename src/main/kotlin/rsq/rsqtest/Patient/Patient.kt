package rsq.rsqtest.Patient

import rsq.rsqtest.Visit.Visit
import javax.persistence.*

@Entity
data class Patient(var firstName:String, var surname:String, var address:String)
{
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    var id: Int = 0

    /*@OneToMany(mappedBy = "id")
    lateinit var visits:List<Visit>

     */
}