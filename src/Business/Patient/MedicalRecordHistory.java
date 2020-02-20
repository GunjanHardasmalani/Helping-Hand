/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Business.Patient;

import java.util.ArrayList;

/**
 *
 * @author mayur
 */
public class MedicalRecordHistory {

    private ArrayList<MedicalRecord> medicalRecordList;

    public MedicalRecordHistory() {
        this.medicalRecordList = new ArrayList<>();
    }

    public ArrayList<MedicalRecord> getMedicalRecordList() {
        return medicalRecordList;
    }

    public void setMedicalRecordList(ArrayList<MedicalRecord> medicalRecordList) {
        this.medicalRecordList = medicalRecordList;
    }

    public MedicalRecord addRecord(MedicalRecord record) {
        medicalRecordList.add(record);
        return record;
    }

    public void removeRecord(MedicalRecord record) {
        medicalRecordList.remove(record);
    }
}
