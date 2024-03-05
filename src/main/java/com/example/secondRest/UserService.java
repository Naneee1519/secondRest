package com.example.secondRest;

import org.springframework.beans.factory.annotation.Autowired;

public class UserService {

    UserRepo userRepo;

    UserService(UserRepo userRepo){
        this.userRepo = userRepo;
    }

    public UserEntity convertUserDTO(UserDTO userDTO){
        try {
            UserEntity userEntity = new UserEntity();
            userEntity.setName(userDTO.getName());
            userEntity.setAge(userDTO.getAge());
            userEntity.setAddress(userDTO.getAddress());
            userEntity.setEmail(userDTO.getEmail());
            userEntity.setPhone_number(userDTO.getPhoneNumber());
            userEntity.setPassword(userDTO.getPassword());
            userEntity.setGender(userDTO.getGender());
            userEntity.setUser_name(userDTO.getUserName());
            userEntity.setProfile_image_url(userDTO.getProfileImage());
            return userRepo.save(userEntity);
        }catch(Exception e) {
            throw e;
        }
    }
}
