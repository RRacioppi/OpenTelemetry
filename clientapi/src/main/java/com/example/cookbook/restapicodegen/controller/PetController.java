package com.example.cookbook.restapicodegen.controller;

import com.example.cookbook.restapicodegen.client.api.PetApiClient;
import com.example.cookbook.restapicodegen.server.api.PetApi;
import com.example.cookbook.restapicodegen.server.model.Pet;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.RestController;

@RestController
@Slf4j
public class PetController implements PetApi {
    @Autowired
    PetApiClient petApiClient;

    @Override
    public ResponseEntity<Pet> getPetById(Long petId) {
        log.info("calling backing service");
        ResponseEntity<com.example.cookbook.restapicodegen.client.model.Pet> response = petApiClient.getPetById(petId);
        log.info("got response from backing service: {}", response.getStatusCode());
        return ResponseEntity.ok(new Pet().id(response.getBody().getId()).name(response.getBody().getName()));
    }
}
