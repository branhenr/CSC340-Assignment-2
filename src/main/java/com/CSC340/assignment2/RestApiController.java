package com.CSC340.assignment2;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.JsonNode;
import com.fasterxml.jackson.databind.ObjectMapper;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.client.RestTemplate;


import java.util.logging.Level;
import java.util.logging.Logger;


@RestController
public class RestApiController {

    @GetMapping("/disney")
    public Object getCharacter(@RequestParam(value = "id", defaultValue = "308") String id){
        try{
            String url = "https://api.disneyapi.dev/character/" + id;
            RestTemplate restTemplate = new RestTemplate();
            ObjectMapper mapper = new ObjectMapper();

            String jsonListResponse = restTemplate.getForObject(url, String.class);
            JsonNode root = mapper.readTree(jsonListResponse);

            DisneyCharacter disneyCharacter = new DisneyCharacter(root.get("data").get("name").asText(),
                    root.get("data").get("_id").asInt(),
                    root.get("data").get("sourceUrl").asText());
            return disneyCharacter;
            
        } catch(JsonProcessingException ex){
            Logger.getLogger(RestApiController.class.getName()).log(Level.SEVERE, null, ex);
            return "error in /disney";
        }
    }
}
