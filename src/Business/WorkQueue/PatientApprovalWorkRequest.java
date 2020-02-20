/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Business.WorkQueue;

import Business.Patient.MedicalRecordHistory;
import Business.Patient.Patient;
import java.util.ArrayList;

/**
 *
 * @author Gunjan
 */
public class PatientApprovalWorkRequest extends WorkRequest {

    private int patientID;
    private String patientName;
    private String SSN;
    private int age;
    private int zipcode;
    private String gender;
    private long phone;    
    private String address;
    private String assignedPhysician;
    private MedicalRecordHistory medicalRecordHistory;

    public PatientApprovalWorkRequest() {
        this.medicalRecordHistory = new MedicalRecordHistory();
    }

    public String getGender() {
        return gender;
    }

    public void setGender(String gender) {
        this.gender = gender;
    }

    public long getPhone() {
        return phone;
    }

    public void setPhone(long phone) {
        this.phone = phone;
    }

    public int getPatientID() {
        return patientID;
    }

    public void setPatientID(int patientID) {
        this.patientID = patientID;
    }

    public String getPatientName() {
        return patientName;
    }

    public void setPatientName(String patientName) {
        this.patientName = patientName;
    }

    public String getSSN() {
        return SSN;
    }

    public void setSSN(String SSN) {
        this.SSN = SSN;
    }

    public int getAge() {
        return age;
    }

    public void setAge(int age) {
        this.age = age;
    }

    public int getZipcode() {
        return zipcode;
    }

    public void setZipcode(int zipcode) {
        this.zipcode = zipcode;
    }

    public String getAssignedPhysician() {
        return assignedPhysician;
    }

    public void setAssignedPhysician(String assignedPhysician) {
        this.assignedPhysician = assignedPhysician;
    }

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
    }

    public MedicalRecordHistory getMedicalRecordHistory() {
        return medicalRecordHistory;
    }

    public void setMedicalRecordHistory(MedicalRecordHistory medicalRecordHistory) {
        this.medicalRecordHistory = medicalRecordHistory;
    }

    @Override
    public String toString() {
        return this.patientName;
    }

}
