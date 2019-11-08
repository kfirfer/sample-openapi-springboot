package com.kfirfer.userservice.controller;

import com.kfirfer.userservice.api.PetApi;
import com.kfirfer.userservice.model.ModelApiResponse;
import com.kfirfer.userservice.model.Pet;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.multipart.MultipartFile;

import javax.validation.Valid;
import java.util.List;

@RestController
public class PetApiController implements PetApi {
    @Override
    public ResponseEntity<Void> addPet(@Valid @RequestBody Pet body) {
        return null;
    }

    @Override
    public ResponseEntity<Void> deletePet(Long petId, String apiKey) {
        return null;
    }

    @Override
    public ResponseEntity<List<Pet>> findPetsByStatus(@Valid List<String> status) {
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
    public ResponseEntity<Void> updatePet(@Valid Pet body) {
        return null;
    }

    @Override
    public ResponseEntity<Void> updatePetWithForm(String petId, String name, String status) {
        return null;
    }

    @Override
    public ResponseEntity<ModelApiResponse> uploadFile(Long petId, String additionalMetadata, @Valid MultipartFile file) {
        return null;
    }
}
