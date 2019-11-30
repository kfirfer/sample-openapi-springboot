package com.kfirfer.userservice.controller;

import com.kfirfer.userservice.api.PetApi;
import com.kfirfer.userservice.model.ModelApiResponse;
import com.kfirfer.userservice.model.Pet;
import org.springframework.core.io.Resource;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.RestController;

import javax.validation.Valid;
import java.util.List;

@RestController
public class PetApiController implements PetApi {


    @Override
    public ResponseEntity<Pet> addPet(@Valid Pet pet) {
        return null;
    }

    @Override
    public ResponseEntity<Void> deletePet(Long petId, String apiKey) {
        return null;
    }

    @Override
    public ResponseEntity<List<Pet>> findPetsByStatus(@Valid String status) {
        return null;
    }

    @Override
    public ResponseEntity<List<Pet>> findPetsByTags(@Valid List<String> tags) {
        return null;
    }

    @Override
    public ResponseEntity<Pet> getPetById(Long petId) {
        return null;
    }

    @Override
    public ResponseEntity<Pet> updatePet(@Valid Pet pet) {
        return null;
    }

    @Override
    public ResponseEntity<Void> updatePetWithForm(Long petId, String name, String status) {
        return null;
    }

    @Override
    public ResponseEntity<ModelApiResponse> uploadFile(Long petId, String additionalMetadata, Resource file) {
        return null;
    }
}
