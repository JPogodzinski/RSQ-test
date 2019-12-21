package rsq.rsqtest.Patient

import javax.persistence.*

@Entity
class Patient(var firstName:String, var surname:String, var address:String) {
}