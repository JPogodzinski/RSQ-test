package rsq.rsqtest.Visit

import org.springframework.web.bind.annotation.*
import rsq.rsqtest.Doctor.Doctor
import rsq.rsqtest.Doctor.DoctorRepository
import rsq.rsqtest.Patient.Patient
import rsq.rsqtest.Patient.PatientRepository
import java.lang.IllegalArgumentException
import java.time.LocalDate
import java.time.LocalTime
import java.util.*
import javax.persistence.*


@RestController
@RequestMapping("/visits")
class VisitController(val repository: VisitRepository, val patientRepository: PatientRepository,
                      val  doctorRepository: DoctorRepository)
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
    fun getVisitsByPatient(@PathVariable id:Int): List<Visit> {
        val pat:Patient=patientRepository.findById(id).orElseThrow()
        var listVisits:MutableList<Visit> = repository.findAll()
        listVisits.forEach{
            it.patient!=pat
            listVisits.remove(it)
        }

        if(listVisits!=null)
            return listVisits
        else
            return repository.findAll()
    }

    @DeleteMapping("/delete/{id}")
    fun deleteVisit(@RequestBody id:Int) {
        repository.deleteById(id)
    }

    @PostMapping("/add")
    fun addVisit(@RequestBody newVisit: Map<String,String>){
        val date:LocalDate= LocalDate.parse(newVisit.getValue("date"))
        val time: LocalTime= LocalTime.parse(newVisit.getValue("time"))
        val place:String=newVisit.getValue("place")
        val idDoc:Int=newVisit.getValue("doctor").toInt()
        val doctor: Doctor =doctorRepository.findById(idDoc).orElseThrow()
        val idPat:Int =newVisit.getValue("patient").toInt()
        val patient: Patient=patientRepository.findById(idPat).orElseThrow()
        repository.save(Visit(date,time,place,doctor,patient))
    }

    @PatchMapping("/{id}")
    fun changeTime(@PathVariable id: Int, @RequestBody text: Map<String,String>){
        val time:LocalTime= LocalTime.parse(text.getValue("time"))
        var oldVisit : Visit = repository.findById(id).orElseThrow()
        oldVisit.setNewTime(time)
        repository.save(oldVisit)
    }
}