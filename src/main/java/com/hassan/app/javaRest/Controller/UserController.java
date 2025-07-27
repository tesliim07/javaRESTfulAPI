package com.hassan.app.javaRest.Controller;
import com.hassan.app.javaRest.Models.User;
import com.hassan.app.javaRest.Service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
public class UserController {
    @Autowired
    private final UserService userService;

    public UserController(UserService userService) {
        this.userService = userService;
    }


    @GetMapping(value="/")
    public String getName(){
        return "HassanT";
    }
    @GetMapping(value="/getUsers")
    public List<User> getUsers(){
        return userService.getUsers();
    }
    @PostMapping(value="/saveUsers")
    public String saveUsers(@RequestBody User user){
        Boolean successful = userService.saveUsers(user);
        if(successful){
            return "User was successfully stored to the database";
        }
        return "Was unable to store user to the database";
    }
    @PatchMapping(value="/updateUserEmail/{id}/{oldEmailAddress}")
    public String updateUserEmail(@PathVariable String oldEmailAddress, @PathVariable long id, @RequestBody String newEmailAddress){
        Boolean successful = userService.updateUserEmail(oldEmailAddress, id, newEmailAddress);
        if(successful){
            return "User Email was successfully updated";
        }
        return "Was unable to update user email";

    }
    @DeleteMapping(value="/deleteUser/{id}")
    public ResponseEntity<String> deleteUser(@PathVariable long id){
        Boolean deleteMessage = userService.deleteUser(id);
        if(deleteMessage){
            return ResponseEntity.ok("Delete Successful");
        }else{
            return ResponseEntity.status(HttpStatus.NOT_FOUND).body("User does not exist");
        }
    }
}

