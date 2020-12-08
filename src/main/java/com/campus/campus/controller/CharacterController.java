package com.campus.campus.controller;
import com.campus.campus.model.Character;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
import java.util.List;

@RestController
public class CharacterController {
    @RequestMapping(value="/characters", method= RequestMethod.GET)
    public List<Character> charactersList(){
        List<Character> charList = new ArrayList<Character>();
        charList.add(new Character(1, new String("Kaaris"), new String("Guerrier")));
        charList.add(new Character(2, new String("Booba"), new String("Guerrier")));
        charList.add(new Character(3, new String("La fouine"), new String("Sorcier")));

        return charList;
    }

    @GetMapping(value = "/characters/{id}")
    public Character characterDisplay(@PathVariable int id){
        Character character = new Character(id, new String("Booba"), new String("Guerrier"));
        return character;
    }
}
