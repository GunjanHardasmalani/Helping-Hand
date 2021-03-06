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
import Business.Patient.Patient;
import Business.UserAccount.UserAccount;
import Business.Validate.Validator;
import Business.WorkQueue.PatientApprovalWorkRequest;
import java.awt.CardLayout;
import java.io.IOException;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.JOptionPane;
import javax.swing.JPanel;

/**
 *
 * @author mayur
 */
public class CreatePatientProfileJPanel extends javax.swing.JPanel {

    /**
     * Creates new form CreatePatientProfileJPanel
     */
    private JPanel userProcessContainer;
    private OrganizationDirectory organizationDirectory;
    private Enterprise enterprise;
    private WelfareOrganization welfareOrganization;
    private EcoSystem system;
    private UserAccount account;
    private GenerateLogs logs;

    public CreatePatientProfileJPanel(JPanel userProcessContainer, UserAccount account, OrganizationDirectory organizationDirectory, WelfareOrganization welfareOrganization, Enterprise enterprise, EcoSystem system, GenerateLogs logs) {
        initComponents();
        this.userProcessContainer = userProcessContainer;
        this.organizationDirectory = organizationDirectory;
        this.enterprise = enterprise;
        this.welfareOrganization = (WelfareOrganization) welfareOrganization;
        this.system = system;
        this.account = account;
        this.logs = logs;
    }

    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        Heading = new javax.swing.JLabel();
        lblName = new javax.swing.JLabel();
        lblSSN = new javax.swing.JLabel();
        txtNameField = new javax.swing.JTextField();
        txtSSNField = new javax.swing.JTextField();
        lblAge = new javax.swing.JLabel();
        txtAgeField = new javax.swing.JTextField();
        lblAddress = new javax.swing.JLabel();
        txtAddressField = new javax.swing.JTextField();
        lblZipCode = new javax.swing.JLabel();
        txtZipCodeField = new javax.swing.JTextField();
        lblGender = new javax.swing.JLabel();
        txtGenderComboBox = new javax.swing.JComboBox<>();
        lblPhone = new javax.swing.JLabel();
        txtPhoneField = new javax.swing.JTextField();
        btnSave = new javax.swing.JButton();
        btnClear = new javax.swing.JButton();
        btnBack = new javax.swing.JButton();

        setBackground(new java.awt.Color(251, 251, 251));

        Heading.setFont(new java.awt.Font("Century Gothic", 1, 24)); // NOI18N
        Heading.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        Heading.setText("Create New Patient");

        lblName.setFont(new java.awt.Font("Century Gothic", 1, 18)); // NOI18N
        lblName.setText("Name");

        lblSSN.setFont(new java.awt.Font("Century Gothic", 1, 18)); // NOI18N
        lblSSN.setText("SSN");

        txtNameField.setFont(new java.awt.Font("Century Gothic", 1, 18)); // NOI18N

        txtSSNField.setFont(new java.awt.Font("Century Gothic", 1, 18)); // NOI18N
        txtSSNField.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                txtSSNFieldActionPerformed(evt);
            }
        });

        lblAge.setFont(new java.awt.Font("Century Gothic", 1, 18)); // NOI18N
        lblAge.setText("Age");

        txtAgeField.setFont(new java.awt.Font("Century Gothic", 1, 18)); // NOI18N

        lblAddress.setFont(new java.awt.Font("Century Gothic", 1, 18)); // NOI18N
        lblAddress.setText("Address");

        txtAddressField.setFont(new java.awt.Font("Century Gothic", 1, 18)); // NOI18N
        txtAddressField.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                txtAddressFieldActionPerformed(evt);
            }
        });

        lblZipCode.setFont(new java.awt.Font("Century Gothic", 1, 18)); // NOI18N
        lblZipCode.setText("ZipCode");

        txtZipCodeField.setFont(new java.awt.Font("Century Gothic", 1, 18)); // NOI18N

        lblGender.setFont(new java.awt.Font("Century Gothic", 1, 18)); // NOI18N
        lblGender.setText("Gender");

        txtGenderComboBox.setFont(new java.awt.Font("Century Gothic", 1, 18)); // NOI18N
        txtGenderComboBox.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "Male", "Female" }));

        lblPhone.setFont(new java.awt.Font("Century Gothic", 1, 18)); // NOI18N
        lblPhone.setText("Phone Number");

        txtPhoneField.setFont(new java.awt.Font("Century Gothic", 1, 18)); // NOI18N
        txtPhoneField.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                txtPhoneFieldActionPerformed(evt);
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

        btnClear.setBackground(new java.awt.Color(251, 251, 251));
        btnClear.setFont(new java.awt.Font("Century Gothic", 1, 18)); // NOI18N
        btnClear.setText("Clear");
        btnClear.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnClearActionPerformed(evt);
            }
        });

        btnBack.setBackground(new java.awt.Color(251, 251, 251));
        btnBack.setFont(new java.awt.Font("Century Gothic", 1, 18)); // NOI18N
        btnBack.setIcon(new javax.swing.ImageIcon(getClass().getResource("/userinterface/Images/arrow-back.png"))); // NOI18N
        btnBack.setText("Back");
        btnBack.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnBackActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(this);
        this.setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGap(25, 25, 25)
                .addComponent(btnBack)
                .addContainerGap(642, Short.MAX_VALUE))
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                .addGap(0, 0, Short.MAX_VALUE)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addGroup(layout.createSequentialGroup()
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                            .addComponent(lblGender, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                            .addComponent(lblZipCode, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                            .addComponent(lblAge, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                            .addComponent(lblAddress, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                            .addComponent(lblSSN, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                            .addComponent(lblName, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                            .addComponent(lblPhone, javax.swing.GroupLayout.Alignment.TRAILING))
                        .addGap(73, 73, 73)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                            .addComponent(txtZipCodeField)
                            .addComponent(txtAddressField)
                            .addComponent(txtAgeField)
                            .addComponent(txtNameField)
                            .addComponent(txtSSNField)
                            .addComponent(txtGenderComboBox, 0, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                            .addComponent(txtPhoneField, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.PREFERRED_SIZE, 247, javax.swing.GroupLayout.PREFERRED_SIZE)))
                    .addComponent(Heading, javax.swing.GroupLayout.PREFERRED_SIZE, 452, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(btnSave, javax.swing.GroupLayout.PREFERRED_SIZE, 120, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(132, 132, 132)
                .addComponent(btnClear, javax.swing.GroupLayout.PREFERRED_SIZE, 111, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(btnBack, javax.swing.GroupLayout.PREFERRED_SIZE, 41, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(4, 4, 4)
                .addComponent(Heading)
                .addGap(48, 48, 48)
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
                .addGap(51, 51, 51)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(btnSave, javax.swing.GroupLayout.PREFERRED_SIZE, 53, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(btnClear, javax.swing.GroupLayout.PREFERRED_SIZE, 53, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );
    }// </editor-fold>//GEN-END:initComponents

    private void txtSSNFieldActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_txtSSNFieldActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_txtSSNFieldActionPerformed

    private void txtAddressFieldActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_txtAddressFieldActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_txtAddressFieldActionPerformed

    private void txtPhoneFieldActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_txtPhoneFieldActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_txtPhoneFieldActionPerformed

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
            boolean flag = true;

            for (Patient patient : welfareOrganization.getPatientDirectory().getPatientList()) {
                if (patient.getSSN().equals(SSN)) {
                    flag = false;
                    JOptionPane.showMessageDialog(null, "SSN: " + SSN + " already exists in the system");
                }
            }

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
            } else if(flag){
                Patient patient = welfareOrganization.getPatientDirectory().createPatient(patientName, SSN, age, zipcode, gender, phone, "Pending");
                logs.generateLogs(CreatePatientProfileJPanel.class.getName(), patient.getPatientName()+" Successful created by " + account.getUsername());
                String initialStatus = "Pending";
                PatientApprovalWorkRequest request = new PatientApprovalWorkRequest();

                int patientId = welfareOrganization.getPatientDirectory().getPatientList().size() + 1;

                request.setPatientID(patientId);
                request.setPatientName(patientName);
                request.setSSN(SSN);
                request.setAge(age);
                request.setZipcode(zipcode);
                request.setGender(gender);
                request.setAddress(address);
                request.setPhone(phone);
                request.setStatus(initialStatus);
                request.setSender(account);
                request.setAssignedPhysician("Yet to Assign");

                Organization org = null;
                Organization welOrg = null;
                for (Organization organization : enterprise.getOrganizationDirectory().getOrganizationList()) {
                    if (organization instanceof DHSSOrganization) {
                        org = organization;
                        break;
                    }
                }
                for (Organization organization : enterprise.getOrganizationDirectory().getOrganizationList()) {
                    if (organization instanceof WelfareOrganization) {
                        welOrg = organization;
                        break;
                    }
                }
                if (org != null && welOrg != null) {
                    org.getWorkQueue().getWorkRequestList().add(request);
                    logs.generateLogs(CreatePatientProfileJPanel.class.getName(), "New patient approval request added to " + org.getName()+" work queue. "+ " Request Status: "+ request.getStatus());
                    account.getWorkQueue().getWorkRequestList().add(request);
                    welOrg.getWorkQueue().getWorkRequestList().add(request);
                }

                JOptionPane.showMessageDialog(null, "Patient: " + patientName + " sent to DHSS for approval");
            }
        } catch (NumberFormatException e) {
            JOptionPane.showMessageDialog(null, "Please enter number for Age, ZipCode and PhoneNumber fields", "Empty Field Error", JOptionPane.WARNING_MESSAGE);
        } catch (IOException ex) {
            Logger.getLogger(CreatePatientProfileJPanel.class.getName()).log(Level.SEVERE, null, ex);
        }
    }//GEN-LAST:event_btnSaveActionPerformed

    private void btnClearActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnClearActionPerformed
        // TODO add your handling code here:
        txtNameField.setText("");
        txtSSNField.setText("");
        txtAgeField.setText("");
        txtAddressField.setText("");
        txtZipCodeField.setText("");
        txtPhoneField.setText("");
        txtAddressField.setText("");
        txtGenderComboBox.setSelectedIndex(1);
    }//GEN-LAST:event_btnClearActionPerformed

    private void btnBackActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnBackActionPerformed
        // TODO add your handling code here:
        userProcessContainer.remove(this);
        CardLayout layout = (CardLayout) userProcessContainer.getLayout();
        layout.previous(userProcessContainer);
    }//GEN-LAST:event_btnBackActionPerformed


    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JLabel Heading;
    private javax.swing.JButton btnBack;
    private javax.swing.JButton btnClear;
    private javax.swing.JButton btnSave;
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
