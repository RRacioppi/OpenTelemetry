package com.example.cookbook.restapicodegen.controller;

import org.openapitools.api.PetApi;
import org.openapitools.model.Pet;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class PetController implements PetApi {
    @Override
    public ResponseEntity<Pet> getPetById(Long petId) {
        return ResponseEntity.ok(new Pet().id(petId).name("dog"));
    }
}
