package com.example.secondRest;

public class UserService {

    UserRepo userRepo;

    UserService(UserRepo userRepo){
        this.userRepo = userRepo;
    }

    public UserEntity convertUserDTO(UserDTO userDTO){
        try {
            UserEntity userEntity = new UserEntity();
            userEntity.setId(userDTO.getId());
            userEntity.setName(userDTO.getName());
            userEntity.setAddress(userDTO.getAddress());
            userEntity.setPhone_number(userDTO.getPhone_number());
            userEntity.setEmail(userDTO.getEmail());
            userEntity.setPassword(userDTO.getPassword());
            userEntity.setGender(userDTO.getGender());
            userEntity.setAge(userDTO.getAge());
            userEntity.setUser_name(userDTO.getUser_name());
            userEntity.setProfile_image_url(userDTO.getProfile_image_url());
            return userRepo.save(userEntity);
        }catch (Exception e){
            throw e;
        }
    }
}
