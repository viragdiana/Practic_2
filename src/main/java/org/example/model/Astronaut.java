package org.example.model;

public class Astronaut {
    private int id;
    private String name;
    private String Spacecraft;
    private AstronautStatus status;
    private int experienceLevel;

    public Astronaut() {
    }

    public Astronaut(int id, String name, String spacecraft, AstronautStatus status, int experienceLevel) {
        this.id = id;
        this.name = name;
        Spacecraft = spacecraft;
        this.status = status;
        this.experienceLevel = experienceLevel;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getSpacecraft() {
        return Spacecraft;
    }

    public void setSpacecraft(String spacecraft) {
        Spacecraft = spacecraft;
    }

    public AstronautStatus getStatus() {
        return status;
    }

    public void setStatus(AstronautStatus status) {
        this.status = status;
    }

    public int getExperienceLevel() {
        return experienceLevel;
    }

    public void setExperienceLevel(int experienceLevel) {
        this.experienceLevel = experienceLevel;
    }

    @Override
    public String toString() {
        return "Astronaut{" +
                "id=" + id +
                ", name='" + name + '\'' +
                ", Spacecraft='" + Spacecraft + '\'' +
                ", status=" + status +
                ", experienceLevel=" + experienceLevel +
                '}';
    }
}
