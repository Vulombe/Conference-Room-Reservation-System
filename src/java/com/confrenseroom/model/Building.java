package com.confrenseroom.model;

/**
 *
 * @author MCDAVE MAKHUBELE
 */
public class Building {
    private int id;
    private String buildingName;
    private int roomID;

    public Building(String buildingName, int roomID) {
        this.buildingName = buildingName;
        this.roomID = roomID;
    }

    public Building(int id, String buildingName, int roomID) {
        this.id = id;
        this.buildingName = buildingName;
        this.roomID = roomID;
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

    public int getRoomID() {
        return roomID;
    }

    public void setRoomID(int roomID) {
        this.roomID = roomID;
    }

    @Override
    public String toString() {
        return "Building{" + "id=" + id + ", buildingName=" + buildingName + ", roomID=" + roomID + '}';
    }
    
    
}
