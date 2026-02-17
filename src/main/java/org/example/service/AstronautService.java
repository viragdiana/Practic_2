package org.example.service;

import com.fasterxml.jackson.core.type.TypeReference;
import com.fasterxml.jackson.databind.ObjectMapper;
import org.example.model.Astronaut;
import org.example.model.AstronautStatus;

import java.io.File;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;
import java.util.Objects;
import java.util.stream.Collectors;

public class AstronautService {
    private List<Astronaut> astronauts = new ArrayList<>();

    //AUFGABE 1 ----------------------------------------------------------------------------------------
    //Load astronauts from json file
    public void loadAstronauts(String filepath) throws IOException {
        ObjectMapper mapper = new ObjectMapper();
        this.astronauts = mapper.readValue(new File(filepath), new TypeReference<List<Astronaut>>() {});
    }

    //Number of astronauts form file
    public int getNumberOfAstronauts(){return astronauts.size();}

    //Get all astronauts
    public List<Astronaut> getAlLAstronauts(){return astronauts;}


    //AUFGABE 2 ----------------------------------------------------------------------------------------
    //filtern nach spacecraft == input AstronautType und status == ACtive AstronautStatus
    public List<Astronaut> filterAstronauts(String spacecraft){
        return astronauts.stream()
                .filter(v-> Objects.equals(v.getSpacecraft(), spacecraft))
                .filter(v->v.getStatus() ==  AstronautStatus.ACTIVE)
                .collect(Collectors.toList());
    }

    //AUFGABE 3 ----------------------------------------------------------------------------------------
    //sortierung aufsteigend nach ownerCity und bei gleichem ownerCity absteigend nach id
    public List<Astronaut> sortedAstronauts(){
        return astronauts.stream()
                .sorted(Comparator.comparing(Astronaut::getExperienceLevel).reversed()
                        .thenComparing(Comparator.comparing(Astronaut::getName)))
                .collect(Collectors.toList());
    }
/*
    //AUFGABE 6 ----------------------------------------------------------------------------------------
    public int calculateTotalRisk(Astronaut v, List<TrafficEvent> events, List<Fine> fines, TrafficEventService eventService) {
        // 1. Suma severității calculate din evenimente
        int totalEventRisk = events.stream()
                .filter(e -> e.getAstronautId() == v.getId())
                .mapToInt(eventService::computedPoints)
                .sum();

        // 2. Suma amenzilor primite
        int totalFines = fines.stream()
                .filter(f -> f.getAstronautId() == v.getId())
                .mapToInt(Fine::getAmount)
                .sum();

        return totalEventRisk - totalFines;
    }
    */
}
