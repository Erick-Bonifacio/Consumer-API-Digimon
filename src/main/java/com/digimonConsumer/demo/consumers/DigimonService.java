package com.digimonConsumer.demo.consumers;
import java.io.IOException;
import java.net.URI;
import java.net.http.HttpClient;
import java.net.http.HttpRequest;
import java.net.http.HttpResponse;
import java.util.ArrayList;

import com.digimonConsumer.demo.entitiesDto.DigimonDto;
import com.fasterxml.jackson.core.type.TypeReference;
import com.fasterxml.jackson.databind.ObjectMapper;

public class DigimonService {

    public ArrayList<DigimonDto> getDigimons() throws IOException, InterruptedException {
        HttpClient client = HttpClient.newHttpClient();
        HttpRequest request = HttpRequest.newBuilder()
                .uri(URI.create("https://digimon-api.vercel.app/api/digimon/"))
                .build();
        HttpResponse<String> response = client.send(request, HttpResponse.BodyHandlers.ofString());

        ObjectMapper mapper = new ObjectMapper();
        ArrayList<DigimonDto> digimons = mapper.readValue(response.body(), new TypeReference<ArrayList<DigimonDto>>(){});

        return digimons;
    }
}
