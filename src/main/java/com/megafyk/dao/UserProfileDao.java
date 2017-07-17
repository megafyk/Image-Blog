package com.megafyk.dao;

import com.megafyk.model.UserProfile;

import java.util.List;

public interface UserProfileDao {

    List<UserProfile> findAll();

    UserProfile findById(int id);

    UserProfile findByType(String type);

}
