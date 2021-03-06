/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package userinterface.VolunteerRole;

import Business.EcoSystem;
import Business.Enterprise.Enterprise;
import Business.Organization.DHSSOrganization;
import Business.Organization.Organization;
import Business.Organization.OrganizationDirectory;
import Business.Organization.WelfareOrganization;
import Business.Patient.Patient;
import Business.UserAccount.UserAccount;
import Business.Validate.Validator;
import Business.WorkQueue.PatientApprovalWorkRequest;
import Business.WorkQueue.WorkRequest;
import java.awt.CardLayout;
import java.awt.Component;
import javax.swing.JOptionPane;
import javax.swing.JPanel;

/**
 *
 * @author Gunjan
 */
public class UpdatePatientDetailsJPanel extends javax.swing.JPanel {

    /**
     * Creates new form UpdatePatientDetailsJPanel
     */
    JPanel userProcessContainer;
    OrganizationDirectory organizationDirectory;
    Enterprise enterprise;
    WelfareOrganization welfareOrganization;
    EcoSystem system;
    UserAccount account;
    PatientApprovalWorkRequest patientApprovalWorkRequest;

    public UpdatePatientDetailsJPanel(JPanel userProcessContainer, UserAccount account, OrganizationDirectory organizationDirectory, WelfareOrganization welfareOrganization, Enterprise enterprise, EcoSystem system, PatientApprovalWorkRequest patientApprovalWorkRequest) {
        initComponents();
        this.userProcessContainer = userProcessContainer;
        this.organizationDirectory = organizationDirectory;
        this.enterprise = enterprise;
        this.welfareOrganization = (WelfareOrganization) welfareOrganization;
        this.system = system;
        this.account = account;
        this.patientApprovalWorkRequest = patientApprovalWorkRequest;
        populatePatientDetails();
    }

    public void populatePatientDetails() {

        txtNameField.setText(patientApprovalWorkRequest.getPatientName());
        txtPhoneField.setText(String.valueOf(patientApprovalWorkRequest.getPhone()));
        txtAgeField.setText(String.valueOf(patientApprovalWorkRequest.getAge()));
        txtAddressField.setText(patientApprovalWorkRequest.getAddress());
        txtGenderComboBox.setSelectedItem(patientApprovalWorkRequest.getGender());
        txtSSNField.setText(patientApprovalWorkRequest.getSSN());
        txtZipCodeField.setText(String.valueOf(patientApprovalWorkRequest.getZipcode()));
    }

    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        lblName = new javax.swing.JLabel();
        txtGenderComboBox = new javax.swing.JComboBox<>();
        Heading = new javax.swing.JLabel();
        lblGender = new javax.swing.JLabel();
        txtZipCodeField = new javax.swing.JTextField();
        lblZipCode = new javax.swing.JLabel();
        txtAddressField = new javax.swing.JTextField();
        lblAddress = new javax.swing.JLabel();
        txtAgeField = new javax.swing.JTextField();
        btnBack = new javax.swing.JButton();
        lblAge = new javax.swing.JLabel();
        txtSSNField = new javax.swing.JTextField();
        btnSave = new javax.swing.JButton();
        txtNameField = new javax.swing.JTextField();
        txtPhoneField = new javax.swing.JTextField();
        lblSSN = new javax.swing.JLabel();
        lblPhone = new javax.swing.JLabel();
        btnUpdate = new javax.swing.JButton();

        setBackground(new java.awt.Color(251, 251, 251));

        lblName.setFont(new java.awt.Font("Century Gothic", 1, 18)); // NOI18N
        lblName.setText("Name");

        txtGenderComboBox.setEditable(true);
        txtGenderComboBox.setFont(new java.awt.Font("Century Gothic", 1, 18)); // NOI18N
        txtGenderComboBox.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "Male", "Female" }));
        txtGenderComboBox.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(0, 0, 0)));
        txtGenderComboBox.setEnabled(false);

        Heading.setFont(new java.awt.Font("Century Gothic", 1, 24)); // NOI18N
        Heading.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        Heading.setText("Update Patient");

        lblGender.setFont(new java.awt.Font("Century Gothic", 1, 18)); // NOI18N
        lblGender.setText("Gender");

        txtZipCodeField.setFont(new java.awt.Font("Century Gothic", 1, 18)); // NOI18N
        txtZipCodeField.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(0, 0, 0)));
        txtZipCodeField.setEnabled(false);

        lblZipCode.setFont(new java.awt.Font("Century Gothic", 1, 18)); // NOI18N
        lblZipCode.setText("ZipCode");

        txtAddressField.setFont(new java.awt.Font("Century Gothic", 1, 18)); // NOI18N
        txtAddressField.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(0, 0, 0)));
        txtAddressField.setEnabled(false);
        txtAddressField.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                txtAddressFieldActionPerformed(evt);
            }
        });

        lblAddress.setFont(new java.awt.Font("Century Gothic", 1, 18)); // NOI18N
        lblAddress.setText("Address");

        txtAgeField.setFont(new java.awt.Font("Century Gothic", 1, 18)); // NOI18N
        txtAgeField.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(0, 0, 0)));
        txtAgeField.setEnabled(false);

        btnBack.setBackground(new java.awt.Color(251, 251, 251));
        btnBack.setFont(new java.awt.Font("Century Gothic", 1, 18)); // NOI18N
        btnBack.setText("< Back");
        btnBack.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnBackActionPerformed(evt);
            }
        });

        lblAge.setFont(new java.awt.Font("Century Gothic", 1, 18)); // NOI18N
        lblAge.setText("Age");

        txtSSNField.setEditable(false);
        txtSSNField.setFont(new java.awt.Font("Century Gothic", 1, 18)); // NOI18N
        txtSSNField.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(0, 0, 0)));
        txtSSNField.setEnabled(false);
        txtSSNField.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                txtSSNFieldActionPerformed(evt);
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

        txtNameField.setFont(new java.awt.Font("Century Gothic", 1, 18)); // NOI18N
        txtNameField.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(0, 0, 0)));
        txtNameField.setEnabled(false);

        txtPhoneField.setFont(new java.awt.Font("Century Gothic", 1, 18)); // NOI18N
        txtPhoneField.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(0, 0, 0)));
        txtPhoneField.setEnabled(false);
        txtPhoneField.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                txtPhoneFieldActionPerformed(evt);
            }
        });

        lblSSN.setFont(new java.awt.Font("Century Gothic", 1, 18)); // NOI18N
        lblSSN.setText("SSN");

        lblPhone.setFont(new java.awt.Font("Century Gothic", 1, 18)); // NOI18N
        lblPhone.setText("Phone Number");

        btnUpdate.setBackground(new java.awt.Color(251, 251, 251));
        btnUpdate.setFont(new java.awt.Font("Century Gothic", 1, 18)); // NOI18N
        btnUpdate.setText("Update");
        btnUpdate.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnUpdateActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(this);
        this.setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGap(43, 43, 43)
                .addComponent(btnBack, javax.swing.GroupLayout.PREFERRED_SIZE, 115, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(34, 34, 34)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                            .addComponent(lblGender, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                            .addComponent(lblZipCode, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                            .addComponent(lblAge, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                            .addComponent(lblAddress, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                            .addComponent(lblSSN, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                            .addComponent(lblName, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                            .addComponent(lblPhone, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                        .addGap(73, 73, 73)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                            .addComponent(txtZipCodeField)
                            .addComponent(txtAddressField, javax.swing.GroupLayout.DEFAULT_SIZE, 247, Short.MAX_VALUE)
                            .addComponent(txtAgeField, javax.swing.GroupLayout.DEFAULT_SIZE, 247, Short.MAX_VALUE)
                            .addComponent(txtNameField)
                            .addComponent(txtSSNField, javax.swing.GroupLayout.DEFAULT_SIZE, 247, Short.MAX_VALUE)
                            .addComponent(txtGenderComboBox, 0, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                            .addComponent(txtPhoneField, javax.swing.GroupLayout.Alignment.TRAILING)))
                    .addComponent(Heading, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.PREFERRED_SIZE, 452, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addContainerGap(156, Short.MAX_VALUE))
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(btnSave, javax.swing.GroupLayout.PREFERRED_SIZE, 99, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(104, 104, 104)
                .addComponent(btnUpdate, javax.swing.GroupLayout.PREFERRED_SIZE, 124, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGap(26, 26, 26)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(Heading)
                    .addComponent(btnBack, javax.swing.GroupLayout.PREFERRED_SIZE, 39, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(46, 46, 46)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(lblName)
                    .addComponent(txtNameField, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(18, 18, 18)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(txtSSNField, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(lblSSN))
                .addGap(18, 18, 18)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(txtAgeField, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(lblAge))
                .addGap(18, 18, 18)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(lblAddress)
                    .addComponent(txtAddressField, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(lblZipCode)
                    .addComponent(txtZipCodeField, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(18, 18, 18)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(lblGender)
                    .addComponent(txtGenderComboBox, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(18, 18, 18)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(lblPhone)
                    .addComponent(txtPhoneField, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 82, Short.MAX_VALUE)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(btnSave, javax.swing.GroupLayout.PREFERRED_SIZE, 48, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(btnUpdate, javax.swing.GroupLayout.PREFERRED_SIZE, 48, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(77, 77, 77))
        );
    }// </editor-fold>//GEN-END:initComponents

    private void txtAddressFieldActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_txtAddressFieldActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_txtAddressFieldActionPerformed

    private void btnBackActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnBackActionPerformed

        userProcessContainer.remove(this);
        Component[] componentArray = userProcessContainer.getComponents();
        Component component = componentArray[componentArray.length - 1];
        ViewPatientListJPanel panel = (ViewPatientListJPanel) component;
        panel.populateTable();
        CardLayout layout = (CardLayout) userProcessContainer.getLayout();
        layout.previous(userProcessContainer);
    }//GEN-LAST:event_btnBackActionPerformed

    private void txtSSNFieldActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_txtSSNFieldActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_txtSSNFieldActionPerformed

    private void btnSaveActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnSaveActionPerformed
        // TODO add your handling code here:
        Validator validate = new Validator();

        try {
            String patientName = txtNameField.getText();
            String SSN = txtSSNField.getText();
            int age = Integer.parseInt(txtAgeField.getText());
            String address = txtAddressField.getText();
            int zipcode = Integer.parseInt(txtZipCodeField.getText());
            String gender = txtGenderComboBox.getSelectedItem().toString();
            long phone = Long.parseLong(txtPhoneField.getText());

            if (patientName.equals("")) {
                JOptionPane.showMessageDialog(null, "Patient Name cannot be blank", "Empty Field Error", JOptionPane.WARNING_MESSAGE);
            } else if (address.equals("")) {
                JOptionPane.showMessageDialog(null, "Patient Address cannot be blank", "Empty Field Error", JOptionPane.WARNING_MESSAGE);
            } else if (!validate.ssnPattern(SSN)) {
                JOptionPane.showMessageDialog(null, "Please enter valid SSN format: xxx-xx-xxxx", "Invalid value Error", JOptionPane.WARNING_MESSAGE);
            } else if (txtZipCodeField.getText().length() > 5 || txtZipCodeField.getText().length() < 5) {
                JOptionPane.showMessageDialog(null, "ZipCode cannot be more or less than 5 digits", "Invalid value Error", JOptionPane.WARNING_MESSAGE);
            } else if (txtPhoneField.getText().length() > 10 || txtPhoneField.getText().length() < 10) {
                JOptionPane.showMessageDialog(null, "Phone Number cannot be more or less than 10 digits", "Invalid value Error", JOptionPane.WARNING_MESSAGE);
            } else {
                for (Patient patient : welfareOrganization.getPatientDirectory().getPatientList()) {
                    if (patient.getSSN().equals(txtSSNField)) {
                        patient.setPatientName(patientName);
                        patient.setAge(age);
                        patient.setAddress(address);
                        patient.setZipcode(zipcode);
                        patient.setPhone(phone);
                        patient.setGender(gender);
                    }
                }
                for (WorkRequest request : welfareOrganization.getWorkQueue().getWorkRequestList()) {
                    if (request instanceof PatientApprovalWorkRequest) {
                        PatientApprovalWorkRequest req = (PatientApprovalWorkRequest) request;
                        if(req.getSSN().equals(SSN)){
                        req.setPatientName(patientName);
                        req.setAge(age);
                        req.setZipcode(zipcode);
                        req.setGender(gender);
                        req.setPhone(phone);
                        req.setAddress(address);
                        }
                    }
                }
                JOptionPane.showMessageDialog(null, "Patient: " + patientName + " records updated successfully");
                txtNameField.setEnabled(false);
                txtAddressField.setEnabled(false);
                txtAgeField.setEnabled(false);
                txtGenderComboBox.setEnabled(false);
                txtPhoneField.setEnabled(false);
                txtZipCodeField.setEnabled(false);
            }
        } catch (NumberFormatException e) {
            JOptionPane.showMessageDialog(null, "Please enter number for ZipCode and PhoneNumber fields", "Empty Field Error", JOptionPane.WARNING_MESSAGE);
        }
    }//GEN-LAST:event_btnSaveActionPerformed

    private void txtPhoneFieldActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_txtPhoneFieldActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_txtPhoneFieldActionPerformed

    private void btnUpdateActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnUpdateActionPerformed
        // TODO add your handling code here:
        txtNameField.setEnabled(true);
        txtSSNField.setEnabled(false);
        txtAgeField.setEnabled(true);
        txtAddressField.setEnabled(true);
        txtZipCodeField.setEnabled(true);
        txtPhoneField.setEnabled(true);
        txtGenderComboBox.setEnabled(true);

    }//GEN-LAST:event_btnUpdateActionPerformed


    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JLabel Heading;
    private javax.swing.JButton btnBack;
    private javax.swing.JButton btnSave;
    private javax.swing.JButton btnUpdate;
    private javax.swing.JLabel lblAddress;
    private javax.swing.JLabel lblAge;
    private javax.swing.JLabel lblGender;
    private javax.swing.JLabel lblName;
    private javax.swing.JLabel lblPhone;
    private javax.swing.JLabel lblSSN;
    private javax.swing.JLabel lblZipCode;
    private javax.swing.JTextField txtAddressField;
    private javax.swing.JTextField txtAgeField;
    private javax.swing.JComboBox<String> txtGenderComboBox;
    private javax.swing.JTextField txtNameField;
    private javax.swing.JTextField txtPhoneField;
    private javax.swing.JTextField txtSSNField;
    private javax.swing.JTextField txtZipCodeField;
    // End of variables declaration//GEN-END:variables
}
