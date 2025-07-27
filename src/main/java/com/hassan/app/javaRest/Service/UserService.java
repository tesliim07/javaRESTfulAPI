package com.hassan.app.javaRest.Service;

import com.hassan.app.javaRest.Models.User;
import com.hassan.app.javaRest.Repo.UserRepo;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;

import java.util.List;
import java.util.Optional;

@Service
public class UserService {
    private final UserRepo userRepo;
    public UserService(UserRepo userRepo){
        this.userRepo = userRepo;
    }

    public List<User> getUsers(){
        return userRepo.findAll();
    }
    public Boolean saveUsers(@RequestBody User user){
        try {
            userRepo.save(user);
            return true;
        }catch(Exception e){
            return false;
        }
    }
    public Boolean updateUserEmail(@PathVariable String oldEmailAddress, @PathVariable long id, @RequestBody String newEmailAddress){
        Optional<User> userByEmailAddress = userRepo.findByEmailAddress(oldEmailAddress);
        User userById = userRepo.findById(id).get();
        if (userByEmailAddress.isPresent()&&(userByEmailAddress.get().getId() == userById.getId())){
            userById.setEmailAddress(newEmailAddress);
            userRepo.save(userById);
            return true;
        }
        else{
            return false;
        }
    }
    public Boolean deleteUser(@PathVariable long id){
        if(!userRepo.existsById(id)){
            return false;
        }
        userRepo.deleteById(id);
        return true;
    }
}
