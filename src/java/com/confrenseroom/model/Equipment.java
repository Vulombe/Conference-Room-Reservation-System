package com.confrenseroom.model;

/**
 *
 * @author MCDAVE MAKHUBELE
 */
public class Equipment {
    private int equipmentID;
    private String equipmntName;
    private Status status;

    public Equipment(int equipmentID, String equipmntName, Status status) {
        this.equipmentID = equipmentID;
        this.equipmntName = equipmntName;
        this.status = status;
    }

    public Equipment(String equipmntName, Status status) {
        this.equipmntName = equipmntName;
        this.status = status;
    }

    public int getEquipmentID() {
        return equipmentID;
    }

    public void setEquipmentID(int equipmentID) {
        this.equipmentID = equipmentID;
    }

    public String getEquipmntName() {
        return equipmntName;
    }

    public void setEquipmntName(String equipmntName) {
        this.equipmntName = equipmntName;
    }

    public Status getStatus() {
        return status;
    }

    public void setStatus(Status status) {
        this.status = status;
    }

    @Override
    public String toString() {
        return "Equipment{" + "equipmentID=" + equipmentID + ", equipmntName=" + equipmntName + ", status=" + status + '}';
    }

}
