package com.confrenseroom.model;

/**
 *
 * @author MCDAVE MAKHUBELE
 */
public class Room {

    private int roomID;
    private String roomName;
    private int capacity;
    private String buildingName;
    private Status status;

    public Room(int roomID, String roomName, int capacity, String building, Status status) {
        this.roomID = roomID;
        this.roomName = roomName;
        this.capacity = capacity;
        this.buildingName = building;
        this.status = status;
    }

    public Room(String roomName, int capacity, String building, Status status) {
        this.roomName = roomName;
        this.capacity = capacity;
        this.buildingName = building;
        this.status = status;
    }
   

    public int getRoomID() {
        return roomID;
    }

    public void setRoomID(int roomID) {
        this.roomID = roomID;
    }

    public String getRoomName() {
        return roomName;
    }

    public void setRoomName(String roomName) {
        this.roomName = roomName;
    }

    public int getCapacity() {
        return capacity;
    }

    public void setCapacity(int capacity) {
        this.capacity = capacity;
    }

    public Status getStatus() {
        return status;
    }

    public void setStatus(Status status) {
        this.status = status;
    }

    public String getBuildingName() {
        return buildingName;
    }

    public void setBuildingName(String buildingName) {
        this.buildingName = buildingName;
    }

    @Override
    public String toString() {
        return "Room{" + "roomID=" + roomID + ", roomName=" + roomName + ", capacity=" + capacity + ", building=" + buildingName + ", status=" + status + '}';
    }
}
