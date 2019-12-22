# RSQ test

## List of all endpoints:
Works on localhost:8080
### Patient endpoints:
⋅⋅⋅localhost:8080/patients - get list of all patients
⋅⋅⋅localhost:8080/patients/{id} - get patient by id
⋅⋅⋅localhost:8080/patients/add - add new patient in  JSON format {name, surname, address}
⋅⋅⋅localhost:8080/patients/delete/{id} - remove patient

### Doctor endpoints
⋅⋅⋅localhost:8080/doctors - get list of all doctors
⋅⋅⋅localhost:8080/doctors/{id} - get doctor by id
⋅⋅⋅localhost:8080/doctors/add - add new doctor in  JSON format {name, surname, specialization}
⋅⋅⋅localhost:8080/doctors/delete/{id} - remove doctor

### Visit endpoints
⋅⋅⋅localhost:8080/visits - get list of all visits
⋅⋅⋅localhost:8080/visits/{id} - get visit by id
⋅⋅⋅localhost:8080/visits/patients/{id} - get all patient visits by patient id
⋅⋅⋅localhost:8080/visits/add - add new visit in  JSON format {date, time, place, doctorId, patientId}
⋅⋅⋅localhost:8080/visits/delete/{id} - remove visit
⋅⋅⋅localhost:8080/visits/{id} - change time of visit if in JSON there is {time}
