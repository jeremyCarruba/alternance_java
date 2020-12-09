package com.campus.campus.dao;

import com.campus.campus.model.Character;
import org.springframework.stereotype.Repository;

import javax.swing.text.html.Option;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import java.util.Optional;

@Repository
public class CharacterDAOImpl implements CharacterDAO {

    public static List<Character>characters=new ArrayList<>();
    static {
        characters.add(new Character(1, new String("Kaaris"), new String("Guerrier")));
        characters.add(new Character(2, new String("Booba"), new String("Guerrier")));
        characters.add(new Character(3, new String("La fouine"), new String("Sorcier")));
    }

    private int counter = 4;

    @Override
    public List<Character> findAll() {
        return characters;
    }

    @Override
    public Optional<Character> findById(int id) {
        Optional<Character> opt = Optional.empty();
        for (Character character : characters) {
            if(character.getId() == id){
                opt = Optional.of(character);
            }
        }
        return opt;
    }

    @Override
    public Character save(Character character) {
        Character newChar = new Character(counter, character.getName(), character.getType());
        characters.add(newChar);
        counter++;
        return newChar;
    }

    @Override
    public Optional<Character> update(Character character) {
        Optional<Character> opt = Optional.empty();
        for(Character characterToUpdate : characters){
            if(characterToUpdate.getId() == character.getId()){
                int index = characters.indexOf(characterToUpdate);
                    characters.set(index, character);
                    opt = Optional.of(character);
            }
        }
        return opt;
    }

    @Override
    public Boolean delete(int id) {
        Boolean deleted = false;
        Iterator<Character> iter = characters.iterator();
        while(iter.hasNext()){
            if(iter.next().getId() == id) {
                iter.remove();
                deleted = true;
                break;
            }
        }
        return deleted;
    }
}
