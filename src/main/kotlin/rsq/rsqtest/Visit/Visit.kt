package rsq.rsqtest.Visit

import java.time.*
import javax.persistence.*

@Entity
data class Visit(var date:LocalDate, var time: LocalTime, var place:String) {
    @Id
    @GeneratedValue
    var id: Int = 0
}