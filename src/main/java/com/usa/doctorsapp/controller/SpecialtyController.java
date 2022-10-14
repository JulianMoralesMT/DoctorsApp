package com.usa.doctorsapp.controller;

import com.usa.doctorsapp.model.Client;
import com.usa.doctorsapp.model.Specialty;
import com.usa.doctorsapp.service.ClientService;
import com.usa.doctorsapp.service.SpecialtyService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/api/Specialty")
@CrossOrigin(origins = "*",methods ={RequestMethod.GET, RequestMethod.POST, RequestMethod.PUT, RequestMethod.DELETE})
public class SpecialtyController {

    @Autowired
    private SpecialtyService specialtyService;

    @GetMapping("/all")
    public List<Specialty> getSpecialty(){
        return specialtyService.getAll();
    }

    @GetMapping("/{id}")
    public Optional<Specialty> getSpecialty(@PathVariable("id") Integer idSpecialty){
        return  specialtyService.getById(idSpecialty);
    }

    @PostMapping("/save")
    @ResponseStatus(HttpStatus.CREATED)
    public Specialty save(@RequestBody Specialty specialty){
        return specialtyService.save(specialty);
    }

    @PutMapping("/update")
    @ResponseStatus(HttpStatus.CREATED)
    public Specialty update(@RequestBody Specialty specialty){
        return specialtyService.update(specialty);
    }

    @DeleteMapping("/{idSpecialty}")
    @ResponseStatus(HttpStatus.NO_CONTENT)
    public boolean delete(@PathVariable("idSpecialty")Integer idSpecialty){
        return specialtyService.delete(idSpecialty);
    }
}
