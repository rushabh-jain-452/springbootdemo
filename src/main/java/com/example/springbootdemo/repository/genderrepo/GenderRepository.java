package com.example.springbootdemo.repository.genderrepo;

import com.example.springbootdemo.model.Gender;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository(value = "genderRepo")
public interface GenderRepository {

    List<Gender> findAllGender();

    Gender findGenderById(int genderId) throws Exception;

    int addGender(Gender gender) throws Exception;

    boolean updateGender(int genderId, Gender gender) throws Exception;

    boolean deleteGender(int genderId) throws Exception;
}
