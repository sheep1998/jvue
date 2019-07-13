package com.jvue.backend.service.serviceImpl;

import com.jvue.backend.dao.UserRepository;
import com.jvue.backend.model.UserEntity;
import com.jvue.backend.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class UserServiceImpl implements UserService{
    @Autowired
    private UserRepository userRepository;

    @Override
    public String getNameById(int userId) {
        return userRepository.findById(userId).get().getName();
    }

    @Override
    public void changeNameByName(String pre, String aft) {
        try{
            UserEntity user = userRepository.findByName(pre);
            user.setName(aft);
            userRepository.save(user);
        }
        catch (Exception e){
            System.out.println(pre+"不存在");
        }
    }

    @Override
    public void save(String name) {
        UserEntity userEntity = new UserEntity();
        userEntity.setName(name);
        userRepository.save(userEntity);
    }
}
