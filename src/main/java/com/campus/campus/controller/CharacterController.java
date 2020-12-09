package com.campus.campus.controller;


import com.campus.campus.dao.CharacterDAOImpl;
import com.campus.campus.model.Character;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
public class CharacterController {

    @Autowired
    private CharacterDAOImpl characterDAO;

    @RequestMapping(value="/characters", method= RequestMethod.GET)
    public ResponseEntity<List<Character>> charactersList(){
        return new ResponseEntity<>(characterDAO.findAll(), HttpStatus.OK);
    }

    @GetMapping(value = "/characters/{id}")
    public ResponseEntity<Optional<Character>> characterDisplay(@PathVariable int id){
        ResponseEntity res;
        Optional<Character> character = characterDAO.findById(id);
        if(character == null){
            res = new ResponseEntity(HttpStatus.NOT_FOUND);
        } else {
            res = new ResponseEntity<>(characterDAO.findById(id), HttpStatus.OK);
        }
        return res;
    }

    @PutMapping(value = "/characters")
    public ResponseEntity characterUpdate(@RequestBody Character character){
        Optional<Character> updatedCharacter = characterDAO.update(character);
        ResponseEntity res;
        if(updatedCharacter == null){
            res = new ResponseEntity(HttpStatus.NOT_FOUND);
        }else{
            res = new ResponseEntity(HttpStatus.ACCEPTED);
        }
        return res;
    }

    @PostMapping(value = "/characters")
    public ResponseEntity<Character> addCharacter(@RequestBody Character character) {
        return new ResponseEntity<>(characterDAO.save(character), HttpStatus.CREATED);
    }

    @DeleteMapping(value = "/characters/{id}")
    public ResponseEntity deleteCharacter(@PathVariable int id) {
        Boolean found = characterDAO.delete(id);
        ResponseEntity res;
        if(found){
            res = new ResponseEntity(HttpStatus.OK);
        }else{
            res = new ResponseEntity(HttpStatus.NO_CONTENT);
        }
        return res;
    }
}
