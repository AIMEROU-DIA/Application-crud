package sn.aimerou.crid_springboot.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import sn.aimerou.crid_springboot.entity.Personne;
import sn.aimerou.crid_springboot.repository.PersonneRepository;
import org.springframework.web.bind.annotation.GetMapping;


@RestController
@RequestMapping("/api/persons")
@Data
@NoArgsConstructor
@AllArgsConstructor
public class PersonneController {

    @Autowired
    PersonneRepository personneRepository ;

    @GetMapping
    public ResponseEntity<List<Personne>>  getAllPersons() {
        return new ResponseEntity<>(personneRepository.findAll(), HttpStatus.OK) ;
    }
    

}
