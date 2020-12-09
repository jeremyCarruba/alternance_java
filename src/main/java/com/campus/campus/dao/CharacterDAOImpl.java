package com.campus.campus.dao;

import com.campus.campus.model.Character;
import org.springframework.stereotype.Repository;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

@Repository
public class CharacterDAOImpl implements CharacterDAO {

    public static List<Character>characters=new ArrayList<>();
    static {
        characters.add(new Character(1, new String("Kaaris"), new String("Guerrier")));
        characters.add(new Character(2, new String("Booba"), new String("Guerrier")));
        characters.add(new Character(3, new String("La fouine"), new String("Sorcier")));
    }

    @Override
    public List<Character> findAll() {
        return characters;
    }

    @Override
    public Character findById(int id) {
        for (Character character : characters) {
            if(character.getId() ==id){
                return character;
            }
        }
        return null;
    }

    @Override
    public Character save(Character character) {
        Character newChar = new Character(characters.size() + 1, character.getName(), character.getType());
        characters.add(newChar);
        return newChar;
    }

    @Override
    public Character update(Character character) {
        for(Character charac : characters){
            if(charac.getId() == character.getId()){
                int index = characters.indexOf(charac);
                if(index == -1) {
                    character = null;
                } else {
                    characters.set(index, character);
                }
            }
        }
        return character;
    }

    @Override
    public Boolean delete(int id) {
        Boolean found = false;
        Iterator<Character> iter = characters.iterator();
        while(iter.hasNext()){
            if(iter.next().getId() == id) {
                found = true;
                iter.remove();
                break;
            }
        }
        return found;
    }
}
