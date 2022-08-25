package com.confrenseroom.model;

/**
 *
 * @author MCDAVE MAKHUBELE
 */
public class Building {
    private int id;
    private String buildingName;
   

    public Building(String buildingName) {
        this.buildingName = buildingName;
    }

    public Building(int id, String buildingName) {
        this.id = id;
        this.buildingName = buildingName;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getBuildingName() {
        return buildingName;
    }

    public void setBuildingName(String buildingName) {
        this.buildingName = buildingName;
    }

    @Override
    public String toString() {
        return "Building{" + "id=" + id + ", buildingName=" + buildingName + '}';
    }
    
}
