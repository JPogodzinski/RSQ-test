package rsq.rsqtest.Patient

import javax.persistence.*

@Entity
data class Patient(var firstName:String, var surname:String, var address:String) {
    @Id
    var id: Int = TODO("initialize me")
}