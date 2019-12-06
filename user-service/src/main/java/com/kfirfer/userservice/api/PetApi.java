/**
 * NOTE: This class is auto generated by OpenAPI Generator (https://openapi-generator.tech) (3.0.0).
 * https://openapi-generator.tech
 * Do not edit the class manually.
 */
package com.kfirfer.userservice.api;

import com.kfirfer.userservice.model.ModelApiResponse;
import com.kfirfer.userservice.model.Pet;
import io.swagger.v3.oas.annotations.ExternalDocumentation;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.Parameter;
import io.swagger.v3.oas.annotations.enums.Explode;
import io.swagger.v3.oas.annotations.enums.ParameterIn;
import io.swagger.v3.oas.annotations.enums.ParameterStyle;
import io.swagger.v3.oas.annotations.enums.SecuritySchemeType;
import io.swagger.v3.oas.annotations.media.Content;
import io.swagger.v3.oas.annotations.media.Schema;
import io.swagger.v3.oas.annotations.responses.ApiResponse;
import io.swagger.v3.oas.annotations.responses.ApiResponses;
import io.swagger.v3.oas.annotations.security.*;
import io.swagger.v3.oas.annotations.tags.Tag;
import org.springframework.core.io.Resource;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.util.List;

@SecurityScheme(name = "petstore_auth", type = SecuritySchemeType.OAUTH2, flows = @OAuthFlows(implicit = @OAuthFlow(authorizationUrl = "https://petstore3.swagger.io/oauth/authorize", scopes = {
        @OAuthScope(name = "write:pets", description = "modify pets in your account"),
        @OAuthScope(name = "read:pets", description = "read your pets")})))
@Tag(name = "pet", description = "Everything about your Pets", externalDocs = @ExternalDocumentation(description = "Find out more", url = "http://swagger.io"))
public interface PetApi {

    @Operation(summary = "Add a new pet to the store", description = "Add a new pet to the store", security = {
            @SecurityRequirement(name = "petstore_auth", scopes = {"write:pets", "read:pets"})}, tags = {"pet"})
    @ApiResponses(value = {
            @ApiResponse(responseCode = "200", description = "Successful operation"),
            @ApiResponse(responseCode = "405", description = "Invalid input", content = @Content)
    })
    @PostMapping(value = "/pet",
            consumes = {"application/json", "application/xml", "application/x-www-form-urlencoded"},
            produces = {"application/xml", "application/json"}
    )
    ResponseEntity<Pet> addPet(
            @Parameter(description = "Create a new pet in the store", required = true) @Valid @RequestBody Pet pet);

    @Operation(summary = "Deletes a pet", description = "", security = {
            @SecurityRequirement(name = "petstore_auth", scopes = {"write:pets", "read:pets"})}, tags = {"pet"})
    @ApiResponses(value = {@ApiResponse(responseCode = "400", description = "Invalid pet value")})
    @DeleteMapping(value = "/pet/{petId}")
    ResponseEntity<Void> deletePet(
            @Parameter(description = "Pet id to delete", required = true) @PathVariable("petId") Long petId,
            @Parameter(description = "") @RequestHeader(value = "api_key", required = false) String apiKey);

    @Operation(summary = "Finds Pets by status", description = "Multiple status values can be provided with comma separated strings", security = {
            @SecurityRequirement(name = "petstore_auth", scopes = {"write:pets", "read:pets"})}, tags = {"pet"})
    @ApiResponses(value = {
            @ApiResponse(responseCode = "200", description = "successful operation"),
            @ApiResponse(responseCode = "400", description = "Invalid status value", content = @Content)})
    @GetMapping(value = "/pet/findByStatus", produces = {"application/xml", "application/json"})
    ResponseEntity<List<Pet>> findPetsByStatus(
            @Parameter(explode = Explode.TRUE, name = "status", in = ParameterIn.QUERY, description = "Status values that need to be considered for filter", style = ParameterStyle.FORM, schema = @Schema(type = "string", defaultValue = "available", allowableValues = {"available", "pending", "sold"})) @Valid @RequestParam(value = "status", required = false) String status);


    @Operation(summary = "Finds Pets by tags", description = "Multiple tags can be provided with comma separated strings. Use tag1, tag2, tag3 for testing.", security = {
            @SecurityRequirement(name = "petstore_auth", scopes = {"write:pets", "read:pets"})}, tags = {"pet"})
    @ApiResponses(value = {
            @ApiResponse(responseCode = "200", description = "successful operation"),
            @ApiResponse(responseCode = "400", description = "Invalid tag value", content = @Content)})
    @GetMapping(value = "/pet/findByTags", produces = {"application/xml", "application/json"})
    ResponseEntity<List<Pet>> findPetsByTags(@Parameter(description = "Tags to filter by", explode = Explode.TRUE, in = ParameterIn.QUERY, name = "tags", style = ParameterStyle.FORM) @Valid @RequestParam(value = "tags", required = false) List<String> tags);

    @Operation(summary = "Find pet by ID", description = "Returns a single pet", security = {
            @SecurityRequirement(name = "api_key"),
            @SecurityRequirement(name = "petstore_auth", scopes = {"write:pets", "read:pets"})
    }, tags = {"pet"})
    @ApiResponses(value = {
            @ApiResponse(responseCode = "200", description = "successful operation"),
            @ApiResponse(responseCode = "400", description = "Invalid ID supplied", content = @Content),
            @ApiResponse(responseCode = "404", description = "Pet not found", content = @Content)})
    @GetMapping(value = "/pet/{petId}", produces = {"application/xml", "application/json"})
    ResponseEntity<Pet> getPetById(
            @Parameter(description = "ID of pet to return", required = true) @PathVariable("petId") Long petId);

    @Operation(summary = "Update an existing pet", description = "Update an existing pet by Id", operationId = "updatePet", security = {
            @SecurityRequirement(name = "petstore_auth", scopes = {"write:pets", "read:pets"})}, tags = {"pet"})
    @ApiResponses(value = {
            @ApiResponse(responseCode = "200", description = "Successful operation",
                    content =
                            {@Content(mediaType = "application/xml", schema = @Schema(implementation = Pet.class)), @Content(mediaType = "application/json", schema = @Schema(implementation = Pet.class))}
            ),
            @ApiResponse(responseCode = "400", description = "Invalid ID supplied", content = @Content),
            @ApiResponse(responseCode = "404", description = "Pet not found", content = @Content),
            @ApiResponse(responseCode = "405", description = "Validation exception", content = @Content)})
    @PutMapping(value = "/pet", consumes = {"application/json", "application/xml", "application/x-www-form-urlencoded"})
    ResponseEntity<Pet> updatePet(
            @Parameter(description = "Update an existent pet in the store", required = true) @Valid @RequestBody Pet pet);

    @Operation(summary = "Updates a pet in the store with form data", description = "", security = {
            @SecurityRequirement(name = "petstore_auth", scopes = {"write:pets", "read:pets"})}, tags = {"pet"})
    @ApiResponses(value = {@ApiResponse(responseCode = "405", description = "Invalid input")})
    @PostMapping(value = "/pet/{petId}")
    ResponseEntity<Void> updatePetWithForm(
            @Parameter(description = "ID of pet that needs to be updated", required = true) @PathVariable("petId") Long petId,
            @Parameter(description = "Name of pet that needs to be updated") @RequestParam(value = "name", required = false) String name,
            @Parameter(description = "Status of pet that needs to be updated") @RequestParam(value = "status", required = false) String status);


    @Operation(summary = "uploads an image", security = {
            @SecurityRequirement(name = "petstore_auth", scopes = {"write:pets", "read:pets"})}, tags = {"pet"})
    @ApiResponses(value = {
            @ApiResponse(responseCode = "200", description = "successful operation")})
    @PostMapping(value = "/pet/{petId}/uploadImage",
            produces = {"application/json"},
            consumes = {"application/octet-stream"})
    ResponseEntity<ModelApiResponse> uploadFile(
            @Parameter(description = "ID of pet to update", required = true) @PathVariable("petId") Long petId,
            @Parameter(description = "Additional Metadata") @RequestParam(value = "additionalMetadata", required = false) String additionalMetadata,
            @io.swagger.v3.oas.annotations.parameters.RequestBody(content = @Content(mediaType = "application/octet-stream", schema = @Schema(type = "string", format = "binary"))) @Valid @RequestBody Resource file);
}
