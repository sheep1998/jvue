package com.jvue.backend.service;

public interface UserService {
    String getNameById(int userId);
    void changeNameByName(String pre,String aft);
    void save(String name);
}
