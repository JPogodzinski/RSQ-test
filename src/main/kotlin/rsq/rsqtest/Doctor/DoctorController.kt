package rsq.rsqtest.Doctor

import org.springframework.web.bind.annotation.*

@RestController
@RequestMapping("/doctors")
class DoctorController(val repository: DoctorRepository)
{
    @GetMapping
    fun getAll():List<Doctor>{
        return repository.findAll()
    }

    @GetMapping("/{id}")
    fun getDoctor(@PathVariable id:Int): Doctor {
        return repository.getOne(id)
    }

    @PostMapping("/add")
    fun addDoctor(@RequestBody newDoctor: Doctor){
        repository.save(newDoctor)
    }

    @DeleteMapping("/delete/{id}")
    fun deleteDoctor(@PathVariable id:Int){
        repository.deleteById(id)
    }
}