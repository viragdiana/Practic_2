package org.example.controller;

import org.example.model.Astronaut;
import org.example.model.AstronautStatus;
import org.example.service.AstronautService;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.List;

public class AstronautController {
    private AstronautService service;

    public AstronautController(AstronautService service){
        this.service = service;
    }

    //AUFGABE  1 --------------------------------------------------------------------------------
    public void loadAstronauts(String filepath) throws IOException {
        service.loadAstronauts(filepath);
    }

    public int getNumbersOfAstronauts(){return service.getNumberOfAstronauts();}

    public List<Astronaut> getAllAstronauts(){return service.getAlLAstronauts();}

    public void printAstronauts(List<Astronaut> astronauts){
        for(Astronaut astronaut : astronauts){
            System.out.println(astronaut);
        }
    }

    //AUFGABE  2 --------------------------------------------------------------------------------
    public void filterAstronauts (String spacecraft){
        List<Astronaut> astronauts = service.filterAstronauts(spacecraft);
        for(Astronaut astronaut : astronauts){
            System.out.println(astronaut);
        }
    }

    //AUFGABE  3 --------------------------------------------------------------------------------
    public void sortedAstronauts(){
        List<Astronaut> astronauts = service.sortedAstronauts();
        for(Astronaut astronaut : astronauts){
            System.out.println(astronaut);
        }
    }


    //AUFGABE  4 --------------------------------------------------------------------------------
    public void writeToFile(String filename) throws IOException{
        //1.obtinem lista sortata de la aufgabe 3
        List<Astronaut> sortedAstronauts = service.sortedAstronauts();

        //2.folosim try-with-resources pt a inchide automat fisierul la final
        try(PrintWriter writer = new PrintWriter(filename)){
            for(Astronaut  astronaut : sortedAstronauts){
                writer.println(astronaut);
            }
        }
    }

/*

    //AUFGABE  6 --------------------------------------------------------------------------------
    public void printAstronautRanking(List<TrafficEvent> events, List<Fine> fines, TrafficEventService eventService) {
        List<Astronaut> allAstronauts = service.getAlLAstronauts();

        // Sortăm vehiculele conform cerinței
        List<Astronaut> sortedAstronauts = allAstronauts.stream()
                .sorted((v1, v2) -> {
                    int risk1 = service.calculateTotalRisk(v1, events, fines, eventService);
                    int risk2 = service.calculateTotalRisk(v2, events, fines, eventService);

                    if (risk1 != risk2) {
                        return Integer.compare(risk1, risk2); // 1. Risk crescător
                    }
                    // 2. License Plate descrescător la egalitate
                    return v2.getLicensePlate().compareTo(v1.getLicensePlate());
                })
                .toList();

        // Afișăm Top 5
        System.out.println("Top 5 Astronauts:");
        for (int i = 0; i < Math.min(5, sortedAstronauts.size()); i++) {
            Astronaut v = sortedAstronauts.get(i);
            int score = service.calculateTotalRisk(v, events, fines, eventService);
            System.out.println((i + 1) + ". " + v.getLicensePlate() + " -> " + score);
        }

        // Cel mai sigur vehicul este primul din lista deja sortată crescător după risc
        if (!sortedAstronauts.isEmpty()) {
            Astronaut safest = sortedAstronauts.get(0);
            int safestScore = service.calculateTotalRisk(safest, events, fines, eventService);
            System.out.println("\nSafest astronaut: " + safest.getLicensePlate() + " -> " + safestScore);
        }
    }
*/
}
