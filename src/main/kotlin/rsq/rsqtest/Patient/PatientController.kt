package rsq.rsqtest.Patient

import org.springframework.web.bind.annotation.*

@RestController
@RequestMapping("/patients")
class PatientController (val repository: PatientRepository)
{

    @GetMapping
    fun getAll():List<Patient>{
        return repository.findAll()
    }

    @GetMapping("/{id}")
    fun getPatient(@PathVariable id:Int):Patient{
        return repository.getOne(id)
    }

    @PostMapping("/add")
    fun addPatient(@RequestBody newPatient: Patient){
        repository.save(newPatient)
    }

    @DeleteMapping("/delete/{id}")
    fun deletePatient(@PathVariable id:Int){
        repository.deleteById(id)
    }
}