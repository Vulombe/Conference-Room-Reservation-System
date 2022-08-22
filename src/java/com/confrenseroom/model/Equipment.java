package com.confrenseroom.model;

/**
 *
 * @author MCDAVE MAKHUBELE
 */
public class Equipment {
    private int equipmentID;
    private String equipmntName;

    public Equipment(int equipmentID, String equipmntName) {
        this.equipmentID = equipmentID;
        this.equipmntName = equipmntName;
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

    @Override
    public String toString() {
        return "Equipment{" + "equipmentID=" + equipmentID + ", equipmntName=" + equipmntName + '}';
    }
    
}
