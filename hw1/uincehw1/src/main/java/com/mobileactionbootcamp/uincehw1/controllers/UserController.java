package com.mobileactionbootcamp.uincehw1.controllers;

//import io.swagger.v3.oas.annotations.parameters.RequestBody;
import com.mobileactionbootcamp.uincehw1.User;
import com.mobileactionbootcamp.uincehw1.UserDao;
//import io.swagger.v3.oas.annotations.parameters.RequestBody;
import org.springframework.web.bind.annotation.RequestBody;
import lombok.AllArgsConstructor;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/v1/user")
@AllArgsConstructor
public class UserController {
    private UserDao userDao;

    @PostMapping
    public ResponseEntity<User> saveUser(@RequestBody User user){
        user = userDao.save(user);

        return new ResponseEntity<>(user, HttpStatus.CREATED);
    }

    @GetMapping
    public ResponseEntity<List<User>> getAllUsers(){

        List<User> userList = userDao.findAll();

        return new ResponseEntity<>(userList, HttpStatus.ACCEPTED);
    }

    @GetMapping("/{id}")
    public ResponseEntity<User> getUserById(@RequestParam long id){
        User user = userDao.findById(id).orElseThrow();
        return new ResponseEntity<>(user, HttpStatus.ACCEPTED);
    }

    @PostMapping("/update")
    public ResponseEntity<User> updateUser(@RequestBody User user){

        boolean isExists = userDao.existsById(user.getId());

        if (!isExists){
            return new ResponseEntity<>(null, HttpStatus.BAD_REQUEST);
        }
        user = userDao.save(user);

        return new ResponseEntity<>(user, HttpStatus.ACCEPTED);
    }

    @PatchMapping("passive/{id}")
    public ResponseEntity makeUserPassive(@RequestParam long id){
        User user = userDao.findById(id).orElseThrow();
        user.setActive(false);
        user = userDao.save(user);
        return new ResponseEntity(user, HttpStatus.ACCEPTED);
    }
}
