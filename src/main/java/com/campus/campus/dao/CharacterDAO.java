package com.campus.campus.dao;


import java.util.List;
import com.campus.campus.model.Character;
public interface CharacterDAO {
    public List<Character> findAll();
    public Character findById(int id);
    public Character save(Character character);
    public Character update(Character character);
    public Boolean delete(int id);
}
