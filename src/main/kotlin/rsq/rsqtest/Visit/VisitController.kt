package rsq.rsqtest.Visit

import org.springframework.web.bind.annotation.*
import rsq.rsqtest.Doctor.DoctorRepository
import rsq.rsqtest.Patient.PatientRepository
import java.time.LocalDate
import java.time.LocalTime
import javax.persistence.*


@RestController
@RequestMapping("/visits")
class VisitController(val repository: VisitRepository, val patientRepository: PatientRepository, val  doctorRepository: DoctorRepository)
{

    @GetMapping
    fun getAll():List<Visit>{
        return repository.findAll()
    }

    @GetMapping("/{id}")
    fun getVisit(@PathVariable id:Int):Visit{
        return repository.getOne(id)
    }
/*
    @PostMapping("/add")
    fun addVisit(@RequestBody getJson:Visit){
        var newVisit:Visit

        var date:LocalDate = LocalDate.parse(getJson.date.toString())
        var time:LocalTime= LocalTime.parse(getJson.time.toString())
        var place=getJson.place
        var doctor=doctorRepository.findById(getJson.doctor.toString().toInt())
        var patient=patientRepository.findById(getJson.patient.toString().toInt())
        repository.save(newVisit(date,time, place, doctor,patient))
    }
*/
    @GetMapping("/patients/{id}")
    fun getVisitsbyPatient(@PathVariable id:Int): List<Visit> {
        if(patientRepository.existsById(id))
            return repository.findAll()
        else
            return repository.findAll()
    }

    /*@PutMapping("/{id}")
    fun changeTime(@PathVariable id: Int, @RequestBody time: LocalTime){
        val visit:Visit=repository.findById(id)
        visit.time=time
        repository.save(visit)
    }*/

    @DeleteMapping("/delete/{id}")
    fun deleteVisit(@RequestBody id:Int) {
        repository.deleteById(id)
    }

}