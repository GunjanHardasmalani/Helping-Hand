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
public class PatientDirectory {
    private ArrayList<Patient> patientList;

    public PatientDirectory() {
        this.patientList = new ArrayList();
    }

    public ArrayList<Patient> getPatientList() {
        return patientList;
    }

    public void setPatientList(ArrayList<Patient> patientList) {
        this.patientList = patientList;
    }

    public Patient createPatient(String patientName, String SSN, int age, int zipcode, String gender, long phone, String status) {
        Patient pt = new Patient(patientName, SSN, age, zipcode, gender, phone, status);
        patientList.add(pt);
        return pt;
    }

    public void removePatient(Patient pt) {
        patientList.remove(pt);
    }

}
