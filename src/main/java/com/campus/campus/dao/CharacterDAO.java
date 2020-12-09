package com.campus.campus.dao;


import java.util.List;
import java.util.Optional;

import com.campus.campus.model.Character;
public interface CharacterDAO {
    public List<Character> findAll();
    public Optional<Character> findById(int id);
    public Character save(Character character);
    public Optional<Character> update(Character character);
    public Boolean delete(int id);
}
