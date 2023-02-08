package com.bootcamp.prueba.user;

import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/usuarios")
@Api
public class UserController {

    private UserService us;

    @Autowired
    public UserController(UserService us) {
        this.us = us;
    }


    //No funciona
    @GetMapping("/{id}")
    public Optional<User> getUserById(@PathVariable Long id){
        Optional<User> u = us.findById(id);
        return u;
    }
    @GetMapping("id/{id}")public Optional<Optional<User>> findById(@PathVariable long id) {
        return Optional.ofNullable(us.findById(id));}
    @GetMapping
    public List<User> findAll() {
        return us.findAll();}

    @PutMapping("/{id}")
    public void updateUser(@PathVariable Long id, User upuser){
        User u = us.findById(id).orElseThrow();
        u.setName(upuser.getName());
        u.setBirthDate(upuser.getBirthDate());
        us.save(u);
    }

    //La columna la pide como "BirthDate" en postman
    @ApiOperation(value = "Guarda un usuario",
            response = User.class,
            notes = "la columna en Postman se BirthDate")
    @PostMapping
    public ResponseEntity<User> saveUser(@RequestBody User user){
               us.save(user);
               return ResponseEntity.ok(user);

    }

    @DeleteMapping("/{id}")
    public void deleteUserById(@PathVariable("id") Long id){
        us.deleteById(id);
    }






}
