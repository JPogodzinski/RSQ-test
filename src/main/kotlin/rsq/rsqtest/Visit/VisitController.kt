package rsq.rsqtest.Visit

import org.springframework.web.bind.annotation.*
import rsq.rsqtest.Patient.PatientRepository
import java.lang.Exception
import java.time.LocalTime

@RestController
@RequestMapping("/visits")
class VisitController(val repository: VisitRepository, val patientRepository: PatientRepository) {

    @GetMapping
    fun getAll():List<Visit>{
        return repository.findAll()
    }

    @GetMapping("/{id}")
    fun getVisit(@PathVariable id:Int):Visit{
        return repository.getOne(id)
    }

    @PostMapping("/add")
    fun addVisit(@RequestBody newVisit:Visit){
        repository.save(newVisit)
    }

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