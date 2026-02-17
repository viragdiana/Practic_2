package org.example.service;

import com.fasterxml.jackson.core.type.TypeReference;
import com.fasterxml.jackson.databind.ObjectMapper;
import org.example.model.MissionEvent;
import org.example.model.MissionEventType;

import java.io.File;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

public class MissionEventService {
    private List<MissionEvent> missionEvents = new ArrayList<>();

    //AUFGABE 1 ----------------------------------------------------------------------------------------
    //Load Missionevents from json file
    public void loadMissionEvents(String filepath) throws IOException {
        ObjectMapper mapper = new ObjectMapper();
        this.missionEvents = mapper.readValue(new File(filepath), new TypeReference<List<MissionEvent>>() {});
    }

    //Number of Missionevents form file
    public int getNumberOfMissionEvents(){return missionEvents.size();}

    //Get all Missionevents
    public List<MissionEvent> getAlLMissionEvents(){return missionEvents;}



    //AUFGABE 5 ----------------------------------------------------------------------------------------
    //computed points
    public int computedPoints(MissionEvent t) {
        return switch (t.getType()) {
            case EVA -> t.getBasePoints() + t.getDay() * 2;
            case SYSTEM_FAILURE -> t.getBasePoints() - 3 - t.getDay();
            case SCIENCE -> t.getBasePoints() + (t.getDay() % 4);
            case MEDICAL -> t.getBasePoints() + (t.getDay() % 3);
            case COMMUNICATION -> t.getBasePoints() + 5;
        };
    }


    //AUFGABE 7 ----------------------------------------------------------------------------------------
    public Map<MissionEventType, Long> countEventsByType() {
        // Grupăm evenimentele după tip și numărăm fiecare apariție
        return missionEvents.stream()
                .collect(Collectors.groupingBy(MissionEvent::getType, Collectors.counting()));
    }

}
