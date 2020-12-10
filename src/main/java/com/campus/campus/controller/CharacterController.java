package com.campus.campus.controller;


import com.campus.campus.dao.CharacterDAOImpl;
import com.campus.campus.model.Character;
import io.swagger.annotations.*;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@Api( description="API pour es opérations CRUD sur les personnages.")
@RestController
public class CharacterController {

    @Autowired
    private CharacterDAOImpl characterDAO;

    @ApiOperation(value = "Récupère tous les personnages")
    @RequestMapping(value="/characters", method= RequestMethod.GET)
    public ResponseEntity<List<Character>> charactersList(){
        return new ResponseEntity<>(characterDAO.findAll(), HttpStatus.OK);
    }

    @ApiOperation(value = "Récupère un perso grâce à son ID à condition que celui-ci existe!")
    @GetMapping(value = "/characters/{id}")
    public ResponseEntity<Optional<Character>> characterDisplay(@PathVariable int id){
        ResponseEntity res;
        Optional<Character> character = characterDAO.findById(id);
        if(character.isEmpty()){
            res = new ResponseEntity(HttpStatus.NOT_FOUND);
        } else {
            res = new ResponseEntity<>(character, HttpStatus.OK);
        }
        return res;
    }

    @ApiOperation(value = "Mise à jour d'un perso")
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

    @ApiOperation(value = "Ajout d'un perso")
    @PostMapping(value = "/characters")
    public ResponseEntity<Character> addCharacter(@RequestBody Character character) {
        return new ResponseEntity<>(characterDAO.save(character), HttpStatus.CREATED);
    }

    /**
     * Suppression d'un perso
     *
     * @param id;
     * @return une ResponseEntity
     */
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
