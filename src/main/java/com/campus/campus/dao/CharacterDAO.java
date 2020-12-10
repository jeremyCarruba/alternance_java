package com.campus.campus.dao;


import java.util.List;
import java.util.Optional;

import com.campus.campus.model.Character;
import org.springframework.data.jpa.repository.JpaRepository;

public interface CharacterDAO extends JpaRepository<Character, Integer> {
    public List<Character> findAll();
    public Optional<Character> findById(int id);
    public Character save(Character character);
    public Optional<Character> update(Character character);
    public Boolean delete(int id);
}
