package org.example;

import io.restassured.RestAssured;
import io.restassured.filter.log.LogDetail;

public class PetStoreMethods {
    String bodyAddNewPet = "{\n" +
            "  \"id\": 123456789,\n" +
            "  \"category\": {\n" +
            "    \"id\": 228,\n" +
            "    \"name\": \"dogs\"\n" +
            "  },\n" +
            "  \"name\": \"Sheldon\",\n" +
            "  \"photoUrls\": [\n" +
            "    \"string\"\n" +
            "  ],\n" +
            "  \"tags\": [\n" +
            "    {\n" +
            "      \"id\": 1488,\n" +
            "      \"name\": \"string\"\n" +
            "    }\n" +
            "  ],\n" +
            "  \"status\": \"unic\"\n" +
            "}";

    String bodyUpdatePet = "{\n" +
            "  \"id\": 123456789,\n" +
            "  \"category\": {\n" +
            "    \"id\": 229,\n" +
            "    \"name\": \"cats\"\n" +
            "  },\n" +
            "  \"name\": \"Barsik\",\n" +
            "  \"photoUrls\": [\n" +
            "    \"string\"\n" +
            "  ],\n" +
            "  \"tags\": [\n" +
            "    {\n" +
            "      \"id\": 1499,\n" +
            "      \"name\": \"string\"\n" +
            "    }\n" +
            "  ],\n" +
            "  \"status\": \"unic\"\n" +
            "}";

    public void addNewPet() {
        RestAssured.given()
                .header("Content-type", "application/json")
                .body(bodyAddNewPet)
                .post("https://petstore.swagger.io/v2/pet")
                .then()
                .log()
                .ifValidationFails(LogDetail.ALL)
                .statusCode(200)
                .extract()
                .response()
                .body()
                .prettyPrint();
    }

    public void updatePet() {
        RestAssured.given()
                .header("Content-type", "application/json")
                .body(bodyUpdatePet)
                .put("https://petstore.swagger.io/v2/pet")
                .then()
                .log()
                .ifValidationFails(LogDetail.ALL)
                .statusCode(200)
                .extract()
                .response()
                .body()
                .prettyPrint();
    }

    public void findPetByStatus() {
        RestAssured.given()
                .queryParam("status", "unic")
                .get("https://petstore.swagger.io/v2/pet/findByStatus")
                .then()
                .log()
                .ifValidationFails(LogDetail.ALL)
                .statusCode(200)
                .extract()
                .response()
                .body()
                .prettyPrint();

    }

    public void deletePet(int petId) {
        RestAssured.given()
                .header("api_key", "myapikey")
                .delete("https://petstore.swagger.io/v2/pet/" + petId)
                .then()
                .log()
                .ifValidationFails(LogDetail.ALL)
                .statusCode(200)
                .extract()
                .response()
                .body()
                .prettyPrint();
    }
}
