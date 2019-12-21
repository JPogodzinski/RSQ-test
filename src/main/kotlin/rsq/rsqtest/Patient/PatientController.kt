package rsq.rsqtest.Patient

import org.springframework.web.bind.annotation.GetMapping
import org.springframework.web.bind.annotation.RestController

@RestController
class PatientController {
    @GetMapping("/hello")
    fun sayHello():String{
        return "hello"
    }
}