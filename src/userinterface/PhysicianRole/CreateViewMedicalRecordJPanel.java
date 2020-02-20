/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package userinterface.PhysicianRole;

import Business.EcoSystem;
import Business.Enterprise.Enterprise;
import Business.GenerateLogs;
import Business.Network.Network;
import Business.Organization.LabOrganization;
import Business.Organization.Organization;
import Business.Organization.OrganizationDirectory;
import Business.Organization.WelfareOrganization;
import Business.Patient.MedicalRecord;
import Business.UserAccount.UserAccount;
import Business.WorkQueue.PatientApprovalWorkRequest;
import Business.WorkQueue.PatientLabTestWorkRequest;
import java.awt.CardLayout;
import java.awt.Color;
import java.awt.Component;
import java.io.IOException;
import java.time.Period;
import java.util.Date;
import java.util.HashMap;
import java.util.Map;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.BorderFactory;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.border.Border;
import javax.swing.border.LineBorder;

/**
 *
 * @author Gunjan
 */
public class CreateViewMedicalRecordJPanel extends javax.swing.JPanel {

    /**
     * Creates new form CreateViewMedicalRecordJPanel
     */
    private JPanel userProcessContainer;
    private UserAccount account;
    private OrganizationDirectory organizationDirectory;
    private WelfareOrganization welfareOrganization;
    private Enterprise enterprise;
    private EcoSystem system;
    private PatientApprovalWorkRequest patient;
    private Border border;
    private Border normalBorder;
    private GenerateLogs logs;

    CreateViewMedicalRecordJPanel(JPanel userProcessContainer, UserAccount account, OrganizationDirectory organizationDirectory, WelfareOrganization welfareOrganization, Enterprise enterprise, EcoSystem system, PatientApprovalWorkRequest patient, GenerateLogs logs) {
        initComponents();
        this.userProcessContainer = userProcessContainer;
        this.account = account;
        this.organizationDirectory = organizationDirectory;
        this.welfareOrganization = welfareOrganization;
        this.enterprise = enterprise;
        this.system = system;
        this.patient = patient;
        this.logs = logs;
        this.border = BorderFactory.createLineBorder(Color.RED, 2);
        this.normalBorder = BorderFactory.createLineBorder(Color.BLACK, 1);
        checkRecordExistsOrNot();
        txtAge.setText(String.valueOf(patient.getAge()));

    }

    public void generateMedicalRecordFields() {
        for (MedicalRecord medicalRecord : patient.getMedicalRecordHistory().getMedicalRecordList()) {
            float respiratoryRate = medicalRecord.getRespiratoryRate();
            float heartRate = medicalRecord.getHeartRate();
            float bloodPressure = medicalRecord.getSystolicBloodPressure();
            float bodyTemperature = medicalRecord.getBodyTemperature();
            int age = patient.getAge();
            txtRespiratoryRate.setText(String.valueOf(medicalRecord.getRespiratoryRate()));
            txtHeartRate.setText(String.valueOf(medicalRecord.getHeartRate()));
            txtBloodPressure.setText(String.valueOf(medicalRecord.getSystolicBloodPressure()));
            txtBodyTemperature.setText(String.valueOf(medicalRecord.getBodyTemperature()));
            txtHeight.setText(String.valueOf(medicalRecord.getHeight()));
            txtWeight.setText(String.valueOf(medicalRecord.getWeightInPounds()));
            txtHealthCondition.setText(medicalRecord.getHealthCondition());
            calculateHealthCondition(age, respiratoryRate, heartRate, bloodPressure, bodyTemperature);
            if (medicalRecord.getHealthCondition().equals("Normal")) {
                btnRequestLab.setEnabled(false);
                txtMessage.setEnabled(false);
                btnPrescription.setEnabled(false);
            } else if (medicalRecord.getHealthCondition().equals("Abnormal - Needs Lab Test")) {
                btnRequestLab.setEnabled(true);
                txtMessage.setEnabled(true);
                btnPrescription.setEnabled(false);
            } else if (medicalRecord.getHealthCondition().equals("Abnormal - Needs Prescription")) {
                btnRequestLab.setEnabled(false);
                txtMessage.setEnabled(false);
                btnPrescription.setEnabled(true);
            }
        }
    }

    public void checkRecordExistsOrNot() {
        try {
            if (patient.getMedicalRecordHistory().getMedicalRecordList().isEmpty()) {
                btnUpdate.setEnabled(false);
                btnRequestLab.setEnabled(false);
                btnPrescription.setEnabled(false);
                txtMessage.setEnabled(false);
                btnSave.setEnabled(true);
            } else {
                btnSave.setEnabled(false);
                txtRespiratoryRate.setEnabled(false);
                txtHeartRate.setEnabled(false);
                txtBloodPressure.setEnabled(false);
                txtBodyTemperature.setEnabled(false);
                txtHeight.setEnabled(false);
                txtWeight.setEnabled(false);
                btnUpdate.setEnabled(true);
                generateMedicalRecordFields();
            }
        } catch (NullPointerException e) {
            JOptionPane.showMessageDialog(null, "No medical records found");
        }

    }

    public String calculateHealthCondition(int age, float respiratoryRate, float heartRate, float bloodPressure, float bodyTemperature) {
        HashMap<String, String> healthCondition = new HashMap<>();
        String overallHealth = "";
        if (age < 18 && (respiratoryRate < 18 || respiratoryRate > 30)) {
            healthCondition.put("Respiratory Rate", "Abnormal");
            txtRespiratoryRate.setBorder(border);
        } else if (age > 18 && (respiratoryRate < 12 || respiratoryRate > 25)) {
            healthCondition.put("Respiratory Rate", "Abnormal");
            txtRespiratoryRate.setBorder(border);
        } else {
            healthCondition.put("Respiratory Rate", "Normal");
            txtRespiratoryRate.setBorder(normalBorder);
        }

        if (age < 10 && (heartRate < 70 || heartRate > 100)) {
            healthCondition.put("Heart Rate", "Abnormal");
            txtHeartRate.setBorder(border);
        } else if (age > 10 && (heartRate < 60 || respiratoryRate > 100)) {
            healthCondition.put("Heart Rate", "Abnormal");
            txtHeartRate.setBorder(border);
        } else {
            healthCondition.put("Heart Rate", "Normal");
            txtHeartRate.setBorder(normalBorder);
        }

        if (age < 20 && (bloodPressure < 90 || bloodPressure > 120)) {
            healthCondition.put("Blood Pressure", "Abnormal");
            txtBloodPressure.setBorder(border);
        } else if (age > 20 && (bloodPressure < 115 || bloodPressure > 140)) {
            healthCondition.put("Blood Pressure", "Abnormal");
            txtBloodPressure.setBorder(border);
        } else {
            healthCondition.put("Blood Pressure", "Normal");
            txtBloodPressure.setBorder(normalBorder);
        }

        if (bodyTemperature > 99) {
            healthCondition.put("Body Temperature", "Abnormal");
            txtBodyTemperature.setBorder(border);
        } else {
            healthCondition.put("Body Temperature", "Normal");
            txtBodyTemperature.setBorder(normalBorder);
        }

        for (Map.Entry<String, String> map : healthCondition.entrySet()) {
            String key = map.getKey();
            String value = map.getValue();

            if ((key.equals("Respiratory Rate") || key.equals("Blood Pressure") || key.equals("Heart Rate")) && value.equals("Abnormal")) {
                overallHealth = "Abnormal - Needs Lab Test";
                break;
            } else if (key.equals("Body Temperature") && value.equals("Abnormal")) {
                overallHealth = "Abnormal - Needs Prescription";
                break;
            } else {
                overallHealth = "Normal";
            }
        }
        return overallHealth;
    }

    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        btnBack = new javax.swing.JButton();
        heading = new javax.swing.JLabel();
        lblRespiratoryRate = new javax.swing.JLabel();
        lblHeartRate = new javax.swing.JLabel();
        lblBloodPressure = new javax.swing.JLabel();
        lblBodyTemperature = new javax.swing.JLabel();
        lblHeight = new javax.swing.JLabel();
        lblWeight = new javax.swing.JLabel();
        lblAge = new javax.swing.JLabel();
        txtRespiratoryRate = new javax.swing.JTextField();
        txtHeartRate = new javax.swing.JTextField();
        txtBloodPressure = new javax.swing.JTextField();
        txtBodyTemperature = new javax.swing.JTextField();
        txtHeight = new javax.swing.JTextField();
        txtWeight = new javax.swing.JTextField();
        txtAge = new javax.swing.JTextField();
        btnSave = new javax.swing.JButton();
        btnUpdate = new javax.swing.JButton();
        lblHealthCondition = new javax.swing.JLabel();
        txtHealthCondition = new javax.swing.JTextField();
        btnRequestLab = new javax.swing.JButton();
        btnPrescription = new javax.swing.JButton();
        lblHealthCondition1 = new javax.swing.JLabel();
        jSeparator1 = new javax.swing.JSeparator();
        jScrollPane1 = new javax.swing.JScrollPane();
        txtMessage = new javax.swing.JTextArea();

        setBackground(new java.awt.Color(251, 251, 251));

        btnBack.setBackground(new java.awt.Color(251, 251, 251));
        btnBack.setFont(new java.awt.Font("Century Gothic", 1, 18)); // NOI18N
        btnBack.setText("< Back");
        btnBack.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnBackActionPerformed(evt);
            }
        });

        heading.setFont(new java.awt.Font("Century Gothic", 1, 36)); // NOI18N
        heading.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        heading.setText("Medical Record");

        lblRespiratoryRate.setFont(new java.awt.Font("Century Gothic", 0, 18)); // NOI18N
        lblRespiratoryRate.setText("Respiratory Rate");

        lblHeartRate.setFont(new java.awt.Font("Century Gothic", 0, 18)); // NOI18N
        lblHeartRate.setText("Heart Rate");

        lblBloodPressure.setFont(new java.awt.Font("Century Gothic", 0, 18)); // NOI18N
        lblBloodPressure.setText("Blood Pressure");

        lblBodyTemperature.setFont(new java.awt.Font("Century Gothic", 0, 18)); // NOI18N
        lblBodyTemperature.setText("Body Temperature");

        lblHeight.setFont(new java.awt.Font("Century Gothic", 0, 18)); // NOI18N
        lblHeight.setText("Height");

        lblWeight.setFont(new java.awt.Font("Century Gothic", 0, 18)); // NOI18N
        lblWeight.setText("Weight");

        lblAge.setFont(new java.awt.Font("Century Gothic", 0, 18)); // NOI18N
        lblAge.setText("Age");

        txtRespiratoryRate.setBackground(new java.awt.Color(251, 251, 251));
        txtRespiratoryRate.setFont(new java.awt.Font("Century Gothic", 0, 18)); // NOI18N
        txtRespiratoryRate.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(0, 0, 0)));
        txtRespiratoryRate.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                txtRespiratoryRateActionPerformed(evt);
            }
        });

        txtHeartRate.setBackground(new java.awt.Color(251, 251, 251));
        txtHeartRate.setFont(new java.awt.Font("Century Gothic", 0, 18)); // NOI18N
        txtHeartRate.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(0, 0, 0)));

        txtBloodPressure.setBackground(new java.awt.Color(251, 251, 251));
        txtBloodPressure.setFont(new java.awt.Font("Century Gothic", 0, 18)); // NOI18N
        txtBloodPressure.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(0, 0, 0)));

        txtBodyTemperature.setBackground(new java.awt.Color(251, 251, 251));
        txtBodyTemperature.setFont(new java.awt.Font("Century Gothic", 0, 18)); // NOI18N
        txtBodyTemperature.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(0, 0, 0)));

        txtHeight.setBackground(new java.awt.Color(251, 251, 251));
        txtHeight.setFont(new java.awt.Font("Century Gothic", 0, 18)); // NOI18N
        txtHeight.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(0, 0, 0)));

        txtWeight.setBackground(new java.awt.Color(251, 251, 251));
        txtWeight.setFont(new java.awt.Font("Century Gothic", 0, 18)); // NOI18N
        txtWeight.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(0, 0, 0)));
        txtWeight.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                txtWeightActionPerformed(evt);
            }
        });

        txtAge.setBackground(new java.awt.Color(251, 251, 251));
        txtAge.setFont(new java.awt.Font("Century Gothic", 0, 18)); // NOI18N
        txtAge.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(0, 0, 0)));
        txtAge.setEnabled(false);
        txtAge.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                txtAgeActionPerformed(evt);
            }
        });

        btnSave.setBackground(new java.awt.Color(251, 251, 251));
        btnSave.setFont(new java.awt.Font("Century Gothic", 1, 18)); // NOI18N
        btnSave.setText("Save");
        btnSave.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnSaveActionPerformed(evt);
            }
        });

        btnUpdate.setBackground(new java.awt.Color(251, 251, 251));
        btnUpdate.setFont(new java.awt.Font("Century Gothic", 1, 18)); // NOI18N
        btnUpdate.setText("Update");
        btnUpdate.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnUpdateActionPerformed(evt);
            }
        });

        lblHealthCondition.setFont(new java.awt.Font("Century Gothic", 0, 18)); // NOI18N
        lblHealthCondition.setText("Comments");

        txtHealthCondition.setBackground(new java.awt.Color(251, 251, 251));
        txtHealthCondition.setFont(new java.awt.Font("Century Gothic", 0, 18)); // NOI18N
        txtHealthCondition.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(0, 0, 0)));
        txtHealthCondition.setEnabled(false);
        txtHealthCondition.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                txtHealthConditionActionPerformed(evt);
            }
        });

        btnRequestLab.setBackground(new java.awt.Color(251, 251, 251));
        btnRequestLab.setFont(new java.awt.Font("Century Gothic", 1, 18)); // NOI18N
        btnRequestLab.setText("Send Result to Lab");
        btnRequestLab.setEnabled(false);
        btnRequestLab.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnRequestLabActionPerformed(evt);
            }
        });

        btnPrescription.setBackground(new java.awt.Color(251, 251, 251));
        btnPrescription.setFont(new java.awt.Font("Century Gothic", 1, 18)); // NOI18N
        btnPrescription.setText("Make/View Prescription");
        btnPrescription.setEnabled(false);
        btnPrescription.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnPrescriptionActionPerformed(evt);
            }
        });

        lblHealthCondition1.setFont(new java.awt.Font("Century Gothic", 1, 24)); // NOI18N
        lblHealthCondition1.setText("Health Condition");

        jSeparator1.setOrientation(javax.swing.SwingConstants.VERTICAL);

        txtMessage.setColumns(20);
        txtMessage.setRows(5);
        txtMessage.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(0, 0, 0)));
        txtMessage.setEnabled(false);
        jScrollPane1.setViewportView(txtMessage);

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(this);
        this.setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap(19, Short.MAX_VALUE)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addGroup(layout.createSequentialGroup()
                        .addComponent(btnBack)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addComponent(heading, javax.swing.GroupLayout.PREFERRED_SIZE, 544, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(0, 0, Short.MAX_VALUE))
                    .addGroup(layout.createSequentialGroup()
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                            .addGroup(layout.createSequentialGroup()
                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING, false)
                                    .addComponent(lblBodyTemperature, javax.swing.GroupLayout.Alignment.LEADING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                    .addComponent(lblWeight, javax.swing.GroupLayout.Alignment.LEADING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                    .addComponent(lblHeight, javax.swing.GroupLayout.Alignment.LEADING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                    .addComponent(lblBloodPressure, javax.swing.GroupLayout.Alignment.LEADING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                    .addComponent(lblHeartRate, javax.swing.GroupLayout.Alignment.LEADING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                    .addComponent(lblRespiratoryRate, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                    .addComponent(lblAge, javax.swing.GroupLayout.Alignment.LEADING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                                .addGap(111, 111, 111)
                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addComponent(txtRespiratoryRate, javax.swing.GroupLayout.PREFERRED_SIZE, 196, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addComponent(txtHeartRate, javax.swing.GroupLayout.PREFERRED_SIZE, 196, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addComponent(txtBloodPressure, javax.swing.GroupLayout.PREFERRED_SIZE, 196, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addComponent(txtBodyTemperature, javax.swing.GroupLayout.PREFERRED_SIZE, 196, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addComponent(txtHeight, javax.swing.GroupLayout.PREFERRED_SIZE, 196, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addComponent(txtWeight, javax.swing.GroupLayout.PREFERRED_SIZE, 196, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addComponent(txtAge, javax.swing.GroupLayout.PREFERRED_SIZE, 196, javax.swing.GroupLayout.PREFERRED_SIZE)))
                            .addGroup(layout.createSequentialGroup()
                                .addComponent(btnSave, javax.swing.GroupLayout.PREFERRED_SIZE, 167, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                .addComponent(btnUpdate, javax.swing.GroupLayout.PREFERRED_SIZE, 167, javax.swing.GroupLayout.PREFERRED_SIZE)))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 18, Short.MAX_VALUE)
                        .addComponent(jSeparator1, javax.swing.GroupLayout.PREFERRED_SIZE, 9, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(btnRequestLab, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                            .addComponent(btnPrescription, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                            .addComponent(jScrollPane1)
                            .addComponent(txtHealthCondition)
                            .addGroup(layout.createSequentialGroup()
                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addComponent(lblHealthCondition, javax.swing.GroupLayout.PREFERRED_SIZE, 141, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addComponent(lblHealthCondition1))
                                .addGap(0, 0, Short.MAX_VALUE)))))
                .addContainerGap(30, Short.MAX_VALUE))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGap(21, 21, 21)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addComponent(heading, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(btnBack, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 24, Short.MAX_VALUE)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                            .addComponent(lblRespiratoryRate)
                            .addComponent(txtRespiratoryRate, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addGap(18, 18, 18)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(lblHeartRate)
                            .addComponent(txtHeartRate, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addGap(18, 18, 18)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(lblBloodPressure)
                            .addComponent(txtBloodPressure, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addGap(18, 18, 18)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(lblBodyTemperature)
                            .addComponent(txtBodyTemperature, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addGap(18, 18, 18)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(lblHeight)
                            .addComponent(txtHeight, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addGap(18, 18, 18)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(lblWeight)
                            .addComponent(txtWeight, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addGap(18, 18, 18)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(lblAge)
                            .addComponent(txtAge, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addGap(32, 32, 32)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(btnSave, javax.swing.GroupLayout.PREFERRED_SIZE, 58, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(btnUpdate, javax.swing.GroupLayout.PREFERRED_SIZE, 58, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                    .addGroup(layout.createSequentialGroup()
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jSeparator1, javax.swing.GroupLayout.PREFERRED_SIZE, 506, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addGroup(layout.createSequentialGroup()
                                .addComponent(lblHealthCondition1, javax.swing.GroupLayout.PREFERRED_SIZE, 32, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addGap(16, 16, 16)
                                .addComponent(txtHealthCondition, javax.swing.GroupLayout.PREFERRED_SIZE, 32, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addGap(85, 85, 85)
                                .addComponent(lblHealthCondition, javax.swing.GroupLayout.PREFERRED_SIZE, 32, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addGap(18, 18, 18)
                                .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 114, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addGap(18, 18, 18)
                                .addComponent(btnRequestLab, javax.swing.GroupLayout.PREFERRED_SIZE, 60, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addGap(39, 39, 39)
                                .addComponent(btnPrescription, javax.swing.GroupLayout.PREFERRED_SIZE, 60, javax.swing.GroupLayout.PREFERRED_SIZE)))
                        .addGap(0, 37, Short.MAX_VALUE))))
        );
    }// </editor-fold>//GEN-END:initComponents

    private void txtWeightActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_txtWeightActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_txtWeightActionPerformed

    private void txtAgeActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_txtAgeActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_txtAgeActionPerformed

    private void btnSaveActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnSaveActionPerformed
        // TODO add your handling code here:
        MedicalRecord medicalRecord = new MedicalRecord();
        Float respiratoryRate = Float.parseFloat(txtRespiratoryRate.getText());
        Float heartRate = Float.parseFloat(txtHeartRate.getText());
        Float bloodPressure = Float.parseFloat(txtBloodPressure.getText());
        Float bodyTemperature = Float.parseFloat(txtBodyTemperature.getText());
        Float height = Float.parseFloat(txtHeight.getText());
        Float weight = Float.parseFloat(txtWeight.getText());
        int age = patient.getAge();

        String healthCondition = calculateHealthCondition(age, respiratoryRate, heartRate, bloodPressure, bodyTemperature);

        medicalRecord.setRespiratoryRate(respiratoryRate);
        medicalRecord.setHeartRate(heartRate);
        medicalRecord.setSystolicBloodPressure(bloodPressure);
        medicalRecord.setBodyTemperature(bodyTemperature);
        medicalRecord.setHeight(height);
        medicalRecord.setWeightInPounds(weight);
        medicalRecord.setHealthCondition(healthCondition);

        patient.getMedicalRecordHistory().addRecord(medicalRecord);

        JOptionPane.showMessageDialog(null, "Medical Record added successfully");
        txtHealthCondition.setText(healthCondition);

        if (healthCondition.equals("Abnormal - Needs Lab Test")) {
            btnRequestLab.setEnabled(true);
            txtMessage.setEnabled(true);
        } else if (healthCondition.equals("Abnormal - Needs Prescription")) {
            btnPrescription.setEnabled(true);
        } else {
            btnRequestLab.setEnabled(false);
            txtMessage.setEnabled(false);
            btnPrescription.setEnabled(false);
            patient.setStatus("Completed");
            JOptionPane.showMessageDialog(null, "The health condotion of Patient is normal: Request Completed, No further action needed");
        }
        btnSave.setEnabled(false);
        btnUpdate.setEnabled(true);

        txtRespiratoryRate.setEnabled(false);
        txtHeartRate.setEnabled(false);
        txtBloodPressure.setEnabled(false);
        txtBodyTemperature.setEnabled(false);
        txtHeight.setEnabled(false);
        txtWeight.setEnabled(false);
    }//GEN-LAST:event_btnSaveActionPerformed

    private void btnUpdateActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnUpdateActionPerformed
        // TODO add your handling code here:
        if (patient.getStatus().equals("Completed")) {
            JOptionPane.showMessageDialog(null, "Cannot update medical records of completed patient requests");
        } else {
            txtRespiratoryRate.setEnabled(true);
            txtHeartRate.setEnabled(true);
            txtBloodPressure.setEnabled(true);
            txtBodyTemperature.setEnabled(true);
            txtHeight.setEnabled(true);
            txtWeight.setEnabled(true);
            btnUpdate.setEnabled(false);
            btnSave.setEnabled(true);
            btnPrescription.setEnabled(false);
            btnRequestLab.setEnabled(false);
            txtMessage.setEnabled(false);
        }
    }//GEN-LAST:event_btnUpdateActionPerformed

    private void txtHealthConditionActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_txtHealthConditionActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_txtHealthConditionActionPerformed

    private void btnRequestLabActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnRequestLabActionPerformed
        // TODO add your handling code here:
        if (patient.getStatus().equals("Completed")) {
            JOptionPane.showMessageDialog(null, "Request already sent to Lab for " + patient.getPatientName());
        } else {
            PatientLabTestWorkRequest request = new PatientLabTestWorkRequest();
            request.setPatientId(patient.getPatientID());
            request.setRespiratoryRate(Float.parseFloat(txtRespiratoryRate.getText()));
            request.setHeartRate(Float.parseFloat(txtHeartRate.getText()));
            request.setSystolicBloodPressure(Float.parseFloat(txtBloodPressure.getText()));
            request.setBodyTemperature(Float.parseFloat(txtBodyTemperature.getText()));
            request.setDate(new Date());
            request.setHeight(Float.parseFloat(txtHeight.getText()));
            request.setWeightInPounds(Float.parseFloat(txtWeight.getText()));
            request.setHealthCondition(txtHealthCondition.getText());
            request.setPhysicianComments(txtMessage.getText());
            request.setPatientName(patient.getPatientName());
            request.setAge(Integer.parseInt(txtAge.getText()));
            request.setStatus("Pending");
            Organization labOrg = null;
            Organization welOrg = null;
            for (Network n : system.getNetworkList()) {
                for (Enterprise e : n.getEnterpriseDirectory().getEnterpriseList()) {
                    if (e.getEnterpriseType().toString().equals("Hospital")) {
                        for (Organization organization : e.getOrganizationDirectory().getOrganizationList()) {
                            if (organization instanceof LabOrganization) {
                                labOrg = organization;
                                break;
                            }
                        }
                    }
                }
            }
            for (Organization organization : enterprise.getOrganizationDirectory().getOrganizationList()) {
                if (organization instanceof WelfareOrganization) {
                    welOrg = organization;
                    break;
                }
            }
            if (labOrg != null && welOrg != null) {
                labOrg.getWorkQueue().getWorkRequestList().add(request);
                welOrg.getWorkQueue().getWorkRequestList().add(request);
                try {
                    logs.generateLogs(CreateViewMedicalRecordJPanel.class.getName(), "Patient request for lab test added to " + labOrg.getName()+" work queue. "+ " Request Status: "+ request.getStatus());
                } catch (IOException ex) {
                    Logger.getLogger(CreateViewMedicalRecordJPanel.class.getName()).log(Level.SEVERE, null, ex);
                }
            }
            JOptionPane.showMessageDialog(null, "Patient: " + patient.getPatientName() + " sent for Lab Testing");
            patient.setStatus("Completed");
            try {
                logs.generateLogs(CreateViewMedicalRecordJPanel.class.getName(), "Patient Approval Work Request Status: "+ patient.getStatus());
            } catch (IOException ex) {
                Logger.getLogger(CreateViewMedicalRecordJPanel.class.getName()).log(Level.SEVERE, null, ex);
            }
        }
    }//GEN-LAST:event_btnRequestLabActionPerformed

    private void btnPrescriptionActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnPrescriptionActionPerformed
        // TODO add your handling code here:
        CreateViewPrescription createViewPrescriptionJPanel = new CreateViewPrescription(userProcessContainer, account, enterprise.getOrganizationDirectory(), welfareOrganization, enterprise, system, patient, logs);
        userProcessContainer.add("createViewPrescriptionJPanel", createViewPrescriptionJPanel);
        CardLayout layout = (CardLayout) userProcessContainer.getLayout();
        layout.next(userProcessContainer);
    }//GEN-LAST:event_btnPrescriptionActionPerformed

    private void txtRespiratoryRateActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_txtRespiratoryRateActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_txtRespiratoryRateActionPerformed

    private void btnBackActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnBackActionPerformed
        // TODO add your handling code here:
        userProcessContainer.remove(this);
        Component[] componentArray = userProcessContainer.getComponents();
        Component component = componentArray[componentArray.length - 1];
        PhysicianWorkAreaJPanel panel = (PhysicianWorkAreaJPanel) component;
        panel.populateTable();
        CardLayout layout = (CardLayout) userProcessContainer.getLayout();
        layout.previous(userProcessContainer);
    }//GEN-LAST:event_btnBackActionPerformed


    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton btnBack;
    private javax.swing.JButton btnPrescription;
    private javax.swing.JButton btnRequestLab;
    private javax.swing.JButton btnSave;
    private javax.swing.JButton btnUpdate;
    private javax.swing.JLabel heading;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JSeparator jSeparator1;
    private javax.swing.JLabel lblAge;
    private javax.swing.JLabel lblBloodPressure;
    private javax.swing.JLabel lblBodyTemperature;
    private javax.swing.JLabel lblHealthCondition;
    private javax.swing.JLabel lblHealthCondition1;
    private javax.swing.JLabel lblHeartRate;
    private javax.swing.JLabel lblHeight;
    private javax.swing.JLabel lblRespiratoryRate;
    private javax.swing.JLabel lblWeight;
    private javax.swing.JTextField txtAge;
    private javax.swing.JTextField txtBloodPressure;
    private javax.swing.JTextField txtBodyTemperature;
    private javax.swing.JTextField txtHealthCondition;
    private javax.swing.JTextField txtHeartRate;
    private javax.swing.JTextField txtHeight;
    private javax.swing.JTextArea txtMessage;
    private javax.swing.JTextField txtRespiratoryRate;
    private javax.swing.JTextField txtWeight;
    // End of variables declaration//GEN-END:variables
}
