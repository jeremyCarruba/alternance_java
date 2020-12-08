package com.campus.campus.dao;


import java.util.List;

public interface CharacterDAO {
    public List<Character> findAll();
    public Character CharacterfindById(int id);
    public Character Charactersave(Character character);
}
