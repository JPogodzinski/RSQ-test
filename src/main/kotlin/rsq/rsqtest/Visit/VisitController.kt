package rsq.rsqtest.Visit

import org.springframework.web.bind.annotation.*
import rsq.rsqtest.Doctor.Doctor
import rsq.rsqtest.Doctor.DoctorRepository
import rsq.rsqtest.Patient.Patient
import rsq.rsqtest.Patient.PatientRepository
import java.time.LocalDate
import java.time.LocalTime
import java.util.*
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

    @GetMapping("/patients/{id}")
    fun getVisitsbyPatient(@PathVariable id:Int): List<Visit> {
        var patient:Patient=patientRepository.findById(id)?: return repository.findAll()

        return repository.findAll(patient)
    }

    @DeleteMapping("/delete/{id}")
    fun deleteVisit(@RequestBody id:Int) {
        repository.deleteById(id)
    }

    @PostMapping("/add")
    fun addVisit(@RequestBody newVisit: Map<String,String>){
        var date:LocalDate= LocalDate.parse(newVisit.getValue("date"))
        var time: LocalTime= LocalTime.parse(newVisit.getValue("time"))
        var place:String=newVisit.getValue("place")
        var idDoc:Int=newVisit.getValue("doctor").toInt()
        var doctor: Doctor =doctorRepository.findById(idDoc) ?: TODO()
        var idPat:Int =newVisit.getValue("patient").toInt()
        var patient: Patient=doctorRepository.findById(idPat)?: TODO()
        repository.save(Visit(date,time,place,doctor,patient))
    }

    @PatchMapping("/{id}")
    fun changeTime(@PathVariable id: Int, @RequestBody time: LocalTime){
        val editVisit = repository.find<Visit>(id)
    }
}