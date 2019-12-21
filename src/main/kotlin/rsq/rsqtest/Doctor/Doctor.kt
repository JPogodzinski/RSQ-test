package rsq.rsqtest.Doctor

import javax.persistence.*


@Entity
data class Doctor(var firstName:String, var surname:String, var spec:String) {
    @Id
    @GeneratedValue
    var id: Int = 0
}