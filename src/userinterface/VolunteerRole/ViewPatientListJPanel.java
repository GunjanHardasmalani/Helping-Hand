/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package userinterface.VolunteerRole;

import Business.EcoSystem;
import Business.Enterprise.Enterprise;
import Business.GenerateLogs;
import Business.Organization.DHSSOrganization;
import Business.Organization.Organization;
import Business.Organization.OrganizationDirectory;
import Business.Organization.WelfareOrganization;
import Business.UserAccount.UserAccount;
import Business.WorkQueue.PatientApprovalWorkRequest;
import Business.WorkQueue.WorkRequest;
import java.awt.CardLayout;
import java.io.IOException;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.table.DefaultTableModel;

/**
 *
 * @author mayur
 */
public class ViewPatientListJPanel extends javax.swing.JPanel {

    /**
     * Creates new form ViewPatientListJPanel
     */
    JPanel userProcessContainer;
    OrganizationDirectory organizationDirectory;
    WelfareOrganization welfareOrganization;
    EcoSystem system;
    Enterprise enterprise;
    UserAccount account;
    private GenerateLogs logs;

    ViewPatientListJPanel(JPanel userProcessContainer, UserAccount account, OrganizationDirectory organizationDirectory, WelfareOrganization welfareOrganization, Enterprise enterprise, EcoSystem system, GenerateLogs logs) {
        initComponents();
        this.userProcessContainer = userProcessContainer;
        this.organizationDirectory = organizationDirectory;
        this.enterprise = enterprise;
        this.welfareOrganization = (WelfareOrganization) welfareOrganization;
        this.system = system;
        this.account = account;
        this.logs = logs;
        populateTable();
        txtApprovedCheckBox.setSelected(false);
        txtCompletedCheckBox.setSelected(false);
        txtPendingCheckBox.setSelected(false);
    }

    public void populateTable() {
        DefaultTableModel dtm = (DefaultTableModel) tblPatientDetails.getModel();
        dtm.setRowCount(0);
        //All checkbox selected TTT or FFF
        if ((txtApprovedCheckBox.isSelected() && txtCompletedCheckBox.isSelected() && txtPendingCheckBox.isSelected()) || (!txtApprovedCheckBox.isSelected() && !txtCompletedCheckBox.isSelected() && !txtPendingCheckBox.isSelected())) {
            for (WorkRequest request : account.getWorkQueue().getWorkRequestList()) {
                PatientApprovalWorkRequest patientApprovalWorkRequest = (PatientApprovalWorkRequest) request;
                Object[] row = new Object[9];
                row[0] = patientApprovalWorkRequest.getPatientID();
                row[1] = patientApprovalWorkRequest;
                row[2] = patientApprovalWorkRequest.getAge();
                row[3] = patientApprovalWorkRequest.getSSN();
                row[4] = patientApprovalWorkRequest.getGender();
                row[5] = patientApprovalWorkRequest.getZipcode();
                row[6] = patientApprovalWorkRequest.getPhone();
                row[7] = patientApprovalWorkRequest.getStatus();
                row[8] = patientApprovalWorkRequest.getAssignedPhysician();

                dtm.addRow(row);
            }
        } //TTF
        else if (txtApprovedCheckBox.isSelected() && txtCompletedCheckBox.isSelected() && !txtPendingCheckBox.isSelected()) {
            for (WorkRequest request : account.getWorkQueue().getWorkRequestList()) {
                PatientApprovalWorkRequest patientApprovalWorkRequest = (PatientApprovalWorkRequest) request;
                if (patientApprovalWorkRequest.getStatus().equals("Approved") || patientApprovalWorkRequest.getStatus().equals("Completed")) {
                    Object[] row = new Object[9];
                    row[0] = patientApprovalWorkRequest.getPatientID();
                    row[1] = patientApprovalWorkRequest;
                    row[2] = patientApprovalWorkRequest.getAge();
                    row[3] = patientApprovalWorkRequest.getSSN();
                    row[4] = patientApprovalWorkRequest.getGender();
                    row[5] = patientApprovalWorkRequest.getZipcode();
                    row[6] = patientApprovalWorkRequest.getPhone();
                    row[7] = patientApprovalWorkRequest.getStatus();
                    row[8] = patientApprovalWorkRequest.getAssignedPhysician();

                    dtm.addRow(row);
                }
            }
        } //TFT
        else if (txtApprovedCheckBox.isSelected() && !txtCompletedCheckBox.isSelected() && txtPendingCheckBox.isSelected()) {
            for (WorkRequest request : account.getWorkQueue().getWorkRequestList()) {
                PatientApprovalWorkRequest patientApprovalWorkRequest = (PatientApprovalWorkRequest) request;
                if (patientApprovalWorkRequest.getStatus().equals("Approved") || patientApprovalWorkRequest.getStatus().equals("Pending")) {
                    Object[] row = new Object[9];
                    row[0] = patientApprovalWorkRequest.getPatientID();
                    row[1] = patientApprovalWorkRequest;
                    row[2] = patientApprovalWorkRequest.getAge();
                    row[3] = patientApprovalWorkRequest.getSSN();
                    row[4] = patientApprovalWorkRequest.getGender();
                    row[5] = patientApprovalWorkRequest.getZipcode();
                    row[6] = patientApprovalWorkRequest.getPhone();
                    row[7] = patientApprovalWorkRequest.getStatus();
                    row[8] = patientApprovalWorkRequest.getAssignedPhysician();

                    dtm.addRow(row);
                }
            }
        }// TFF
        else if (txtApprovedCheckBox.isSelected() && !txtCompletedCheckBox.isSelected() && !txtPendingCheckBox.isSelected()) {
            for (WorkRequest request : account.getWorkQueue().getWorkRequestList()) {
                PatientApprovalWorkRequest patientApprovalWorkRequest = (PatientApprovalWorkRequest) request;
                if (patientApprovalWorkRequest.getStatus().equals("Approved")) {
                    Object[] row = new Object[9];
                    row[0] = patientApprovalWorkRequest.getPatientID();
                    row[1] = patientApprovalWorkRequest;
                    row[2] = patientApprovalWorkRequest.getAge();
                    row[3] = patientApprovalWorkRequest.getSSN();
                    row[4] = patientApprovalWorkRequest.getGender();
                    row[5] = patientApprovalWorkRequest.getZipcode();
                    row[6] = patientApprovalWorkRequest.getPhone();
                    row[7] = patientApprovalWorkRequest.getStatus();
                    row[8] = patientApprovalWorkRequest.getAssignedPhysician();

                    dtm.addRow(row);
                }
            }
        }// FTT
        else if (!txtApprovedCheckBox.isSelected() && txtCompletedCheckBox.isSelected() && txtPendingCheckBox.isSelected()) {
            for (WorkRequest request : account.getWorkQueue().getWorkRequestList()) {
                PatientApprovalWorkRequest patientApprovalWorkRequest = (PatientApprovalWorkRequest) request;
                if (patientApprovalWorkRequest.getStatus().equals("Completed") || patientApprovalWorkRequest.getStatus().equals("Pending")) {
                    Object[] row = new Object[9];
                    row[0] = patientApprovalWorkRequest.getPatientID();
                    row[1] = patientApprovalWorkRequest;
                    row[2] = patientApprovalWorkRequest.getAge();
                    row[3] = patientApprovalWorkRequest.getSSN();
                    row[4] = patientApprovalWorkRequest.getGender();
                    row[5] = patientApprovalWorkRequest.getZipcode();
                    row[6] = patientApprovalWorkRequest.getPhone();
                    row[7] = patientApprovalWorkRequest.getStatus();
                    row[8] = patientApprovalWorkRequest.getAssignedPhysician();

                    dtm.addRow(row);
                }
            }
        }// FTF
        else if (!txtApprovedCheckBox.isSelected() && txtCompletedCheckBox.isSelected() && !txtPendingCheckBox.isSelected()) {
            for (WorkRequest request : account.getWorkQueue().getWorkRequestList()) {
                PatientApprovalWorkRequest patientApprovalWorkRequest = (PatientApprovalWorkRequest) request;
                if (patientApprovalWorkRequest.getStatus().equals("Completed")) {
                    Object[] row = new Object[9];
                    row[0] = patientApprovalWorkRequest.getPatientID();
                    row[1] = patientApprovalWorkRequest;
                    row[2] = patientApprovalWorkRequest.getAge();
                    row[3] = patientApprovalWorkRequest.getSSN();
                    row[4] = patientApprovalWorkRequest.getGender();
                    row[5] = patientApprovalWorkRequest.getZipcode();
                    row[6] = patientApprovalWorkRequest.getPhone();
                    row[7] = patientApprovalWorkRequest.getStatus();
                    row[8] = patientApprovalWorkRequest.getAssignedPhysician();

                    dtm.addRow(row);
                }
            }
        }// FFT
        else if (!txtApprovedCheckBox.isSelected() && !txtCompletedCheckBox.isSelected() && txtPendingCheckBox.isSelected()) {
            for (WorkRequest request : account.getWorkQueue().getWorkRequestList()) {
                PatientApprovalWorkRequest patientApprovalWorkRequest = (PatientApprovalWorkRequest) request;
                if (patientApprovalWorkRequest.getStatus().equals("Pending")) {
                    Object[] row = new Object[9];
                    row[0] = patientApprovalWorkRequest.getPatientID();
                    row[1] = patientApprovalWorkRequest;
                    row[2] = patientApprovalWorkRequest.getAge();
                    row[3] = patientApprovalWorkRequest.getSSN();
                    row[4] = patientApprovalWorkRequest.getGender();
                    row[5] = patientApprovalWorkRequest.getZipcode();
                    row[6] = patientApprovalWorkRequest.getPhone();
                    row[7] = patientApprovalWorkRequest.getStatus();
                    row[8] = patientApprovalWorkRequest.getAssignedPhysician();

                    dtm.addRow(row);
                }
            }
        }
    }

    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        heading = new javax.swing.JLabel();
        jScrollPane1 = new javax.swing.JScrollPane();
        tblPatientDetails = new javax.swing.JTable();
        btnBack = new javax.swing.JButton();
        btnSearchPatient = new javax.swing.JButton();
        btnDeletePatient = new javax.swing.JButton();
        txtSearchPatient = new javax.swing.JTextField();
        btnPhysician = new javax.swing.JButton();
        btnUpdatePatient3 = new javax.swing.JButton();
        txtCompletedCheckBox = new javax.swing.JCheckBox();
        txtApprovedCheckBox = new javax.swing.JCheckBox();
        txtPendingCheckBox = new javax.swing.JCheckBox();

        setBackground(new java.awt.Color(251, 251, 251));

        heading.setFont(new java.awt.Font("Century Gothic", 1, 24)); // NOI18N
        heading.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        heading.setText("Patient Details");

        tblPatientDetails.setFont(new java.awt.Font("Century Gothic", 0, 18)); // NOI18N
        tblPatientDetails.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {

            },
            new String [] {
                "Patient ID", "Patient Name", "Age", "SSN", "Gender", "Zipcode", "Phone Number", "Status", "Physician"
            }
        ) {
            boolean[] canEdit = new boolean [] {
                false, false, false, false, false, false, false, false, false
            };

            public boolean isCellEditable(int rowIndex, int columnIndex) {
                return canEdit [columnIndex];
            }
        });
        jScrollPane1.setViewportView(tblPatientDetails);
        if (tblPatientDetails.getColumnModel().getColumnCount() > 0) {
            tblPatientDetails.getColumnModel().getColumn(0).setResizable(false);
            tblPatientDetails.getColumnModel().getColumn(1).setResizable(false);
            tblPatientDetails.getColumnModel().getColumn(2).setResizable(false);
            tblPatientDetails.getColumnModel().getColumn(3).setResizable(false);
            tblPatientDetails.getColumnModel().getColumn(4).setResizable(false);
            tblPatientDetails.getColumnModel().getColumn(5).setResizable(false);
            tblPatientDetails.getColumnModel().getColumn(6).setResizable(false);
            tblPatientDetails.getColumnModel().getColumn(7).setResizable(false);
            tblPatientDetails.getColumnModel().getColumn(8).setResizable(false);
        }

        btnBack.setBackground(new java.awt.Color(251, 251, 251));
        btnBack.setFont(new java.awt.Font("Century Gothic", 1, 18)); // NOI18N
        btnBack.setText("< Back");
        btnBack.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnBackActionPerformed(evt);
            }
        });

        btnSearchPatient.setBackground(new java.awt.Color(251, 251, 251));
        btnSearchPatient.setFont(new java.awt.Font("Century Gothic", 1, 18)); // NOI18N
        btnSearchPatient.setText("Search Patients By Name");
        btnSearchPatient.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnSearchPatientActionPerformed(evt);
            }
        });

        btnDeletePatient.setBackground(new java.awt.Color(251, 251, 251));
        btnDeletePatient.setFont(new java.awt.Font("Century Gothic", 1, 18)); // NOI18N
        btnDeletePatient.setText("Delete Patient");
        btnDeletePatient.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnDeletePatientActionPerformed(evt);
            }
        });

        txtSearchPatient.setFont(new java.awt.Font("Century Gothic", 1, 18)); // NOI18N
        txtSearchPatient.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(0, 0, 0)));
        txtSearchPatient.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                txtSearchPatientActionPerformed(evt);
            }
        });

        btnPhysician.setBackground(new java.awt.Color(251, 251, 251));
        btnPhysician.setFont(new java.awt.Font("Century Gothic", 1, 18)); // NOI18N
        btnPhysician.setText("Assign a Physician");
        btnPhysician.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnPhysicianActionPerformed(evt);
            }
        });

        btnUpdatePatient3.setBackground(new java.awt.Color(251, 251, 251));
        btnUpdatePatient3.setFont(new java.awt.Font("Century Gothic", 1, 18)); // NOI18N
        btnUpdatePatient3.setText("Update Details");
        btnUpdatePatient3.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnUpdatePatient3ActionPerformed(evt);
            }
        });

        txtCompletedCheckBox.setBackground(new java.awt.Color(251, 251, 251));
        txtCompletedCheckBox.setFont(new java.awt.Font("Century Gothic", 1, 18)); // NOI18N
        txtCompletedCheckBox.setText("Completed");
        txtCompletedCheckBox.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                txtCompletedCheckBoxActionPerformed(evt);
            }
        });

        txtApprovedCheckBox.setBackground(new java.awt.Color(251, 251, 251));
        txtApprovedCheckBox.setFont(new java.awt.Font("Century Gothic", 1, 18)); // NOI18N
        txtApprovedCheckBox.setText("Approved");
        txtApprovedCheckBox.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                txtApprovedCheckBoxActionPerformed(evt);
            }
        });

        txtPendingCheckBox.setBackground(new java.awt.Color(251, 251, 251));
        txtPendingCheckBox.setFont(new java.awt.Font("Century Gothic", 1, 18)); // NOI18N
        txtPendingCheckBox.setText("Pending");
        txtPendingCheckBox.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                txtPendingCheckBoxActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(this);
        this.setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                .addContainerGap(38, Short.MAX_VALUE)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addComponent(jScrollPane1)
                    .addGroup(layout.createSequentialGroup()
                        .addComponent(txtCompletedCheckBox)
                        .addGap(18, 18, 18)
                        .addComponent(txtApprovedCheckBox)
                        .addGap(18, 18, 18)
                        .addComponent(txtPendingCheckBox)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                            .addComponent(txtSearchPatient)
                            .addComponent(btnSearchPatient, javax.swing.GroupLayout.DEFAULT_SIZE, 277, Short.MAX_VALUE)))
                    .addGroup(javax.swing.GroupLayout.Alignment.LEADING, layout.createSequentialGroup()
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(layout.createSequentialGroup()
                                .addComponent(btnUpdatePatient3, javax.swing.GroupLayout.PREFERRED_SIZE, 181, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addGap(102, 102, 102)
                                .addComponent(btnPhysician))
                            .addGroup(layout.createSequentialGroup()
                                .addComponent(btnBack, javax.swing.GroupLayout.PREFERRED_SIZE, 106, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(heading, javax.swing.GroupLayout.PREFERRED_SIZE, 517, javax.swing.GroupLayout.PREFERRED_SIZE)))
                        .addGap(0, 118, Short.MAX_VALUE))
                    .addGroup(layout.createSequentialGroup()
                        .addGap(0, 0, Short.MAX_VALUE)
                        .addComponent(btnDeletePatient, javax.swing.GroupLayout.PREFERRED_SIZE, 179, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addComponent(heading, javax.swing.GroupLayout.PREFERRED_SIZE, 33, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addGroup(layout.createSequentialGroup()
                        .addComponent(btnBack, javax.swing.GroupLayout.PREFERRED_SIZE, 53, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(3, 3, 3)))
                .addGap(35, 35, 35)
                .addComponent(txtSearchPatient, javax.swing.GroupLayout.PREFERRED_SIZE, 40, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(btnSearchPatient, javax.swing.GroupLayout.PREFERRED_SIZE, 40, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(txtCompletedCheckBox)
                    .addComponent(txtApprovedCheckBox)
                    .addComponent(txtPendingCheckBox))
                .addGap(18, 18, 18)
                .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 198, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(45, 45, 45)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(btnDeletePatient, javax.swing.GroupLayout.PREFERRED_SIZE, 40, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(btnUpdatePatient3, javax.swing.GroupLayout.PREFERRED_SIZE, 40, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(btnPhysician, javax.swing.GroupLayout.PREFERRED_SIZE, 40, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(109, 109, 109))
        );
    }// </editor-fold>//GEN-END:initComponents

    private void btnBackActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnBackActionPerformed
        // TODO add your handling code here:
        userProcessContainer.remove(this);
        CardLayout layout = (CardLayout) userProcessContainer.getLayout();
        layout.previous(userProcessContainer);
    }//GEN-LAST:event_btnBackActionPerformed

    private void btnDeletePatientActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnDeletePatientActionPerformed
        // TODO add your handling code here:
        int selectedRow = tblPatientDetails.getSelectedRow();
        if (selectedRow >= 0) {
            int dialogButton = JOptionPane.YES_NO_OPTION;
            int dialogResult = JOptionPane.showConfirmDialog(null, "Would you like to remove the patient records ?", "Warning", dialogButton);
            if (dialogResult == JOptionPane.YES_OPTION) {
                PatientApprovalWorkRequest patientReq = (PatientApprovalWorkRequest) tblPatientDetails.getValueAt(selectedRow, 1);
                if (patientReq.getStatus().equalsIgnoreCase("Pending")) {
                    Organization org = null;
                    for (Organization organization : enterprise.getOrganizationDirectory().getOrganizationList()) {
                        if (organization instanceof DHSSOrganization) {
                            org = organization;
                            break;
                        }
                    }
                    
                    if (org != null) {
                        try {
                            logs.generateLogs(ViewPatientListJPanel.class.getName(),  patientReq.getPatientName()+" removed from records");
                        } catch (IOException ex) {
                            Logger.getLogger(ViewPatientListJPanel.class.getName()).log(Level.SEVERE, null, ex);
                        }
                        org.getWorkQueue().getWorkRequestList().remove(patientReq);
                        account.getWorkQueue().getWorkRequestList().remove(patientReq);
                    }
                    populateTable();
                    
                } else if (patientReq.getStatus().equalsIgnoreCase("Completed")) {
                    JOptionPane.showMessageDialog(null, "Cannot delete completed requests", "Warning", JOptionPane.WARNING_MESSAGE);
                } else if (patientReq.getStatus().equalsIgnoreCase("Approved")) {
                    JOptionPane.showMessageDialog(null, "Cannot delete patient requests which are approved through DHSS", "Warning", JOptionPane.WARNING_MESSAGE);
                }
            }
        } else {
            JOptionPane.showMessageDialog(null, "Please select a row from table first", "Warning", JOptionPane.WARNING_MESSAGE);
        }
    }//GEN-LAST:event_btnDeletePatientActionPerformed

    private void btnSearchPatientActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnSearchPatientActionPerformed
        // TODO add your handling code here:
        txtApprovedCheckBox.setSelected(false);
        txtCompletedCheckBox.setSelected(false);
        txtPendingCheckBox.setSelected(false);
        String searchText = txtSearchPatient.getText();
        if (searchText.equals("") || searchText == null) {
            JOptionPane.showMessageDialog(null, "Please enter Patient Name to search");
        } else {
            DefaultTableModel dtm = (DefaultTableModel) tblPatientDetails.getModel();
            dtm.setRowCount(0);
            for (WorkRequest request : account.getWorkQueue().getWorkRequestList()) {
                PatientApprovalWorkRequest patientApprovalWorkRequest = (PatientApprovalWorkRequest) request;
                if (patientApprovalWorkRequest.toString().equalsIgnoreCase(searchText)) {
                    Object[] row = new Object[8];
                    row[0] = patientApprovalWorkRequest.getPatientID();
                    row[1] = patientApprovalWorkRequest;
                    row[2] = patientApprovalWorkRequest.getAge();
                    row[3] = patientApprovalWorkRequest.getSSN();
                    row[4] = patientApprovalWorkRequest.getGender();
                    row[5] = patientApprovalWorkRequest.getZipcode();
                    row[6] = patientApprovalWorkRequest.getPhone();
                    row[7] = patientApprovalWorkRequest.getStatus();

                    dtm.addRow(row);
                }
            }
        }
    }//GEN-LAST:event_btnSearchPatientActionPerformed

    private void btnPhysicianActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnPhysicianActionPerformed
        // TODO add your handling code here:
        int selectedRow = tblPatientDetails.getSelectedRow();
        PatientApprovalWorkRequest patientReq = (PatientApprovalWorkRequest) tblPatientDetails.getValueAt(selectedRow, 1);
        if (selectedRow >= 0) {
            if (patientReq.getStatus().equalsIgnoreCase("Approved")) {
                AssignPhysicianJPanel assignPhysicianJPanel = new AssignPhysicianJPanel(userProcessContainer, account, enterprise.getOrganizationDirectory(), welfareOrganization, enterprise, system, patientReq, logs);
                userProcessContainer.add("assignPhysicianJPanel", assignPhysicianJPanel);
                CardLayout layout = (CardLayout) userProcessContainer.getLayout();
                layout.next(userProcessContainer);
            } else if (patientReq.getStatus().equalsIgnoreCase("Completed")) {
                JOptionPane.showMessageDialog(null, patientReq.getPatientName() + "'s request has already been completed", "Warning", JOptionPane.WARNING_MESSAGE);
            } else {
                JOptionPane.showMessageDialog(null, "Only Approved patients can be assigned a Physician", "Warning", JOptionPane.WARNING_MESSAGE);
            }

        } else {
            JOptionPane.showMessageDialog(null, "Please select a row from table first", "Warning", JOptionPane.WARNING_MESSAGE);
        }
    }//GEN-LAST:event_btnPhysicianActionPerformed

    private void btnUpdatePatient3ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnUpdatePatient3ActionPerformed
        // TODO add your handling code here:
        int selectedRow = tblPatientDetails.getSelectedRow();
        PatientApprovalWorkRequest patientReq = (PatientApprovalWorkRequest) tblPatientDetails.getValueAt(selectedRow, 1);
        if (selectedRow >= 0) {
            if (patientReq.getStatus().equalsIgnoreCase("Completed")) {
                JOptionPane.showMessageDialog(null, "Cannot update completed patient requests", "Warning", JOptionPane.WARNING_MESSAGE);
            } else if (patientReq.getStatus().equalsIgnoreCase("Approved")) {
                JOptionPane.showMessageDialog(null, "Cannot update patient requests which are approved through DHSS", "Warning", JOptionPane.WARNING_MESSAGE);
            }else{
            UpdatePatientDetailsJPanel updatePatientDetailJPanel = new UpdatePatientDetailsJPanel(userProcessContainer, account, enterprise.getOrganizationDirectory(), welfareOrganization, enterprise, system, patientReq);
            userProcessContainer.add("UpdatePatientDetailsJPanel", updatePatientDetailJPanel);
            CardLayout layout = (CardLayout) userProcessContainer.getLayout();
            layout.next(userProcessContainer);
            }
        } else {
            JOptionPane.showMessageDialog(null, "Please select a row from table first", "Warning", JOptionPane.WARNING_MESSAGE);
        }


    }//GEN-LAST:event_btnUpdatePatient3ActionPerformed

    private void txtCompletedCheckBoxActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_txtCompletedCheckBoxActionPerformed
        // TODO add your handling code here:
        populateTable();
    }//GEN-LAST:event_txtCompletedCheckBoxActionPerformed

    private void txtApprovedCheckBoxActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_txtApprovedCheckBoxActionPerformed
        // TODO add your handling code here:
        populateTable();
    }//GEN-LAST:event_txtApprovedCheckBoxActionPerformed

    private void txtPendingCheckBoxActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_txtPendingCheckBoxActionPerformed
        // TODO add your handling code here:
        populateTable();
    }//GEN-LAST:event_txtPendingCheckBoxActionPerformed

    private void txtSearchPatientActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_txtSearchPatientActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_txtSearchPatientActionPerformed


    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton btnBack;
    private javax.swing.JButton btnDeletePatient;
    private javax.swing.JButton btnPhysician;
    private javax.swing.JButton btnSearchPatient;
    private javax.swing.JButton btnUpdatePatient3;
    private javax.swing.JLabel heading;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JTable tblPatientDetails;
    private javax.swing.JCheckBox txtApprovedCheckBox;
    private javax.swing.JCheckBox txtCompletedCheckBox;
    private javax.swing.JCheckBox txtPendingCheckBox;
    private javax.swing.JTextField txtSearchPatient;
    // End of variables declaration//GEN-END:variables
}
