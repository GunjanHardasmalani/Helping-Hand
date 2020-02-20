/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Business.Patient;

/**
 *
 * @author mayur
 */
public class Patient {

    private int patientID;
    private String patientName;
    private String SSN;
    private int age;
    private String address;
    private int zipcode;
    private String gender;
    private long phone;
    private String status;
    private MedicalRecordHistory medicalRecordHistory;
    private static int count = 0;

    public Patient(String patientName, String SSN, int age, int zipcode, String gender, long phone, String status) {
        count++;
        this.patientID = count;
        this.patientName = patientName;
        this.SSN = SSN;
        this.age = age;
        this.zipcode = zipcode;
        this.gender = gender;
        this.phone = phone;
        this.status = status;
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

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
    }

    public int getZipcode() {
        return zipcode;
    }

    public void setZipcode(int zipcode) {
        this.zipcode = zipcode;
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

    public String isStatus() {
        return status;
    }

    public void setStatus(String status) {
        this.status = status;
    }

    public MedicalRecordHistory getMedicalRecordHistory() {
        return medicalRecordHistory;
    }

    public void setMedicalRecordHistory(MedicalRecordHistory medicalRecordHistory) {
        this.medicalRecordHistory = medicalRecordHistory;
    }

    @Override
    public String toString() {
        return patientName;
    }
}
