package com.atia.roadrunner.rentalform.Controller;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.atia.roadrunner.rentalform.Model.Form;
import com.atia.roadrunner.rentalform.Repository.IFormRepository;

@RestController
@RequestMapping("/forms")
@CrossOrigin("*")
public class FormController {
     @Autowired
    private IFormRepository formRepo;

    //http://localhost:8082/forms/post
    // http://localhost:8082/forms/get
    // http://localhost:8082/forms/get/{id}

    @PostMapping(value="/post")
    public ResponseEntity<?> postForms(@RequestBody Form form) {
        formRepo.save(form);
        
        return  ResponseEntity.ok("Form info Added!") ;
    }
    

    @GetMapping("/get")
    public List<Form> getForm(){
      return  formRepo.findAll();
        
    }


    @GetMapping("/get/{id}")
    public Optional<Form> getById(@PathVariable Long id){
        return formRepo.findById(id);
    }
}
