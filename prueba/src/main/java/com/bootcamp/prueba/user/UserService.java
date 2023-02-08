package com.bootcamp.prueba.user;

import io.micrometer.core.instrument.config.validate.ValidationException;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class UserService {

    private final UserRepository userRepository;

    public UserService(UserRepository userRepository) {
        this.userRepository = userRepository;
    }


    public Optional<User> findById(Long id) {
        return userRepository.findById(id);}

    public List<User> findAll() {
        return userRepository.findAll();}
    public User save(User user) throws ValidationException {
        if(user.getName() == null && user.getBirthDate() == null){
            throw new IllegalArgumentException("Se deben introducir el nombre y la fecha de nacimiento");
        } else if(user.getName() == null || user.getName().isEmpty()){
            throw new IllegalArgumentException("Se deben introducir el nombre");
        } else if (user.getBirthDate() == null){
            throw new IllegalArgumentException("Se deben introducir la fecha de nacimiento");
        }
        return userRepository.save(user);
    }
    public void deleteById(Long id) {
        userRepository.deleteById(id);}

}
