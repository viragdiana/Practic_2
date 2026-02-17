package org.example;

import org.example.controller.SupplyController;
import org.example.controller.MissionEventController;
import org.example.controller.AstronautController;
import org.example.model.MissionEvent;
import org.example.model.AstronautStatus;
import org.example.model.SupplyType;
import org.example.service.SupplyService;
import org.example.service.MissionEventService;
import org.example.service.AstronautService;

import java.io.IOException;
import java.util.List;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) throws IOException {
        //AUFGABE 1 - initializare straturi
        //Astronauts
        AstronautService astronautService = new AstronautService();
        AstronautController astronautController = new AstronautController(astronautService);

        //missionEvents
        MissionEventService missionEventService = new MissionEventService();
        MissionEventController missionEventController = new MissionEventController(missionEventService);

        //supplies
        SupplyService fineService = new SupplyService();
        SupplyController fineController = new SupplyController(fineService);




        try{
            System.out.println("-----------VEHICLES APPLICATION-----------");
            System.out.println("AUFGABE 1 ------------------------------------");

            //AUFGABE 1 ----------------------------------------------------------------------------------------------------------
            //incarcare si afisare
            String astronautsFilePath = "astronauts.json";
            String missionEventsFilepath = "events.json";
            String suppliesFilePath = "supplies.json";

            //Incarc datele Astronauts, ereignissen, geschanken din json
            astronautController.loadAstronauts(astronautsFilePath);
            missionEventController.loadMissionEvents(missionEventsFilepath);
            fineController.loadSupplys(suppliesFilePath);

            //afisam nr de Astronauts, ereignissen, geschanken
            System.out.println("Astronauts loaded: " + astronautController.getNumbersOfAstronauts());
            System.out.println("MissionEvents loaded: " + missionEventController.getNumberOfMissionEvents());
            System.out.println("Supplys loaded: " + fineController.getNumberOfSupplys());


            //afisam toate tributele cu formatarea ceruta
            astronautController.printAstronauts(astronautController.getAllAstronauts());



            //AUFGABE 2------------------------------------------------------------------------------------------------------------
            //filtrare
            System.out.println("AUFGABE 2 ------------------------------------");
            System.out.println("Enter spacecraft: ");
            Scanner scanner = new Scanner(System.in);
            String spacecraftInput = scanner.nextLine().trim(); // Convertim la majuscule pentru siguranță

            String selectedSpacecraft = String.valueOf(spacecraftInput).trim();

           
            astronautController.filterAstronauts(selectedSpacecraft);

            //INT
            //System.out.print("Enter ID: ");
            //int id = Integer.parseInt(scanner.nextLine());
            //DOUBLE
            //System.out.print("Enter Price/Severity: ");
            //double value = Double.parseDouble(scanner.nextLine());
            //ENUM
            //System.out.print("Enter Type: ");
            //String input = scanner.nextLine().toUpperCase();
            //AstronautType type = AstronautType.valueOf(input);
            //STRING
            //System.out.print("Enter City: ");
            // .trim() elimină spațiile accidentale de la început/final (" Berlin " -> "Berlin")
            //String city = scanner.nextLine().trim();
            //BOOLEAN
            //System.out.print("Is it electric? (true/false): ");
            //boolean isElectric = Boolean.parseBoolean(scanner.nextLine());



            //AUFGABE 3------------------------------------------------------------------------------------------------------------
            //sortare
            System.out.println("AUFGABE 3 ------------------------------------");
            System.out.println("Sorted astronauts by Experienlevl: " );
            astronautController.sortedAstronauts();



            //AUFGABE 4------------------------------------------------------------------------------------------------------------
            //write to file
            System.out.println("AUFGABE 4 ------------------------------------");
            System.out.println("astronauts written into: astronauts_sorted.txt " );
            astronautController.writeToFile("astronauts_sorted.txt");


            //AUFGABE 5------------------------------------------------------------------------------------------------------------
            //computed points
            System.out.println("AUFGABE 5 ------------------------------------");
            List<MissionEvent> missionEvents = missionEventController.getAlLMissionEvents();
            missionEventController.computefisrtFiveEvents(missionEvents);

/*
            //AUFGABE 6------------------------------------------------------------------------------------------------------------
            System.out.println("AUFGABE 6 ------------------------------------");
            astronautController.printAstronautRanking(
                    missionEventController.getAlLMissionEvents(),
                    fineController.getAlLSupplys(),
                    missionEventService
            );


*/
            //AUFGABE 7------------------------------------------------------------------------------------------------------------
            System.out.println("AUFGABE 7 ------------------------------------");
            try {
                missionEventController.generateMissionReport("mission_report.txt");
                System.out.println("\nmission report generated successfully.");
            } catch (IOException e) {
                System.err.println("Error generating report: " + e.getMessage());
            }




        }catch(Exception e) {
            System.err.println("CRITICAL ERROR: " + e.getMessage());
            e.printStackTrace();
        }


    }


}

