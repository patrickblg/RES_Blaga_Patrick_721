package org.example.model;

public class Astronaut {
    private int id;
    private String name;
    private String spacecraft;
    private AstronautStatus status;
    private int experienceLevel;
    private int totalScore;

    public Astronaut(){}

    public Astronaut(int id, String name, String spacecraft, AstronautStatus status, int experienceLevel, int totalScore) {
        this.id = id;
        this.name = name;
        this.spacecraft = spacecraft;
        this.status = status;
        this.experienceLevel = experienceLevel;
        this.totalScore = totalScore;
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
        return spacecraft;
    }

    public void setSpacecraft(String spacecraft) {
        this.spacecraft = spacecraft;
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

    public int getTotalScore() {
        return totalScore;
    }

    public void setTotalScore(int totalScore) {
        this.totalScore = totalScore;
    }

    @Override
    public String toString() {
        return
                "[#" + id +
                "] " + name +
                " | " + spacecraft +
                " | " + status +
                " | exp=<" + experienceLevel +
                '>';
    }
}
