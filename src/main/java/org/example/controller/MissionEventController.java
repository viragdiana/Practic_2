package org.example.controller;

import org.example.model.MissionEvent;
import org.example.model.MissionEventType;
import org.example.service.MissionEventService;

import java.io.FileWriter;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.List;
import java.util.Map;

public class MissionEventController {
    private MissionEventService service;

    public MissionEventController(MissionEventService service){
        this.service = service;
    }

    public List<MissionEvent> getAlLMissionEvents(){return service.getAlLMissionEvents();}

    //AUFGABE  1 --------------------------------------------------------------------------------
    public void loadMissionEvents(String filepath) throws IOException {
        service.loadMissionEvents(filepath);
    }

    public int getNumberOfMissionEvents(){return service.getNumberOfMissionEvents();}

    //AUFGABE  5 --------------------------------------------------------------------------------
    public void computefisrtFiveEvents(List<MissionEvent> missionEvents){
        for(int j = 0; j < 5 && j < missionEvents.size(); j++){
            MissionEvent missionEvent = missionEvents.get(j);
            int computedPoints = service.computedPoints(missionEvent);

            System.out.println("Event " + missionEvent.getId() +
                    "-> severity = " + missionEvent.getBasePoints() +
                    "-> riskScore = " + computedPoints);
        }
    }






    //AUFGABE  7 --------------------------------------------------------------------------------
    public void generateMissionReport(String filename) throws IOException {
        Map<MissionEventType, Long> reportData = service.countEventsByType();

        try (PrintWriter writer = new PrintWriter(new FileWriter(filename))) {
            // Parcurgem mapa și scriem fiecare linie în formatul: TIP -> NR
            reportData.forEach((type, count) -> {
                writer.println(type + " -> " + count);
            });
        }
    }


}
