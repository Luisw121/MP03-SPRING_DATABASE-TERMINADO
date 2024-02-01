package com.example.demo;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.JsonNode;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.github.fge.jsonpatch.JsonPatch;
import com.github.fge.jsonpatch.JsonPatchException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Service;
import org.springframework.web.server.ResponseStatusException;

import java.nio.channels.UnresolvedAddressException;
import java.util.List;
import java.util.Optional;

@Service
public class UserService {
    @Autowired
    UserDAO repository;
    public List<User> findAll() {
        return repository.findAll();
    }

    public User getUserById(Integer id){
        Optional<User> optionalUser;
        optionalUser = repository.findById(id);
        return optionalUser.orElse(null);
    }

    public User saveUser(User user) {
        return repository.save(user);
    }


    public void deleteUserById(Integer id){
        repository.deleteById(id);
    }
}