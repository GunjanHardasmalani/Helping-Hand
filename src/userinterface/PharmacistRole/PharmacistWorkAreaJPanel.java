/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package userinterface.PharmacistRole;

import Business.EcoSystem;
import Business.Enterprise.Enterprise;
import Business.Organization.OrganizationDirectory;
import Business.Organization.PharmacyOrganization;
import Business.UserAccount.UserAccount;
import Business.Validate.Validator;
import Business.WorkQueue.PatientPrescriptionWorkRequest;
import Business.WorkQueue.WorkRequest;
import java.awt.CardLayout;
import java.awt.Component;
import java.awt.Font;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.table.DefaultTableModel;

/**
 *
 * @author Rohit
 */
public class PharmacistWorkAreaJPanel extends javax.swing.JPanel {

    /**
     * Creates new form PharmacistWorkAreaJPanel
     */
    private JPanel userProcessContainer;
    private UserAccount account;
    private OrganizationDirectory organizationDirectory;
    private PharmacyOrganization pharmacyOrganization;
    private Enterprise enterprise;
    private EcoSystem system;
    private Validator validate;
    private PatientPrescriptionWorkRequest patientPrescriptionWorkRequest;

    public PharmacistWorkAreaJPanel(JPanel userProcessContainer, UserAccount account, PharmacyOrganization pharmacyOrganization, Enterprise enterprise, EcoSystem business) {
        initComponents();
        this.userProcessContainer = userProcessContainer;
        this.account = account;
        this.organizationDirectory = organizationDirectory;
        this.pharmacyOrganization = pharmacyOrganization;
        this.enterprise = enterprise;
        this.system = system;
        this.validate = new Validator();
        this.patientPrescriptionWorkRequest = new PatientPrescriptionWorkRequest();
        lblPharmacistName.setText(account.getEmployee().getName());
        populateTable();
    }
    
    public void populateTable(){
        DefaultTableModel dtm = (DefaultTableModel) tblPatientRecord.getModel();
        dtm.setRowCount(0);
        for (WorkRequest request : pharmacyOrganization.getWorkQueue().getWorkRequestList()) {
            if (request instanceof PatientPrescriptionWorkRequest) {
                PatientPrescriptionWorkRequest patientPrescriptionWorkRequest = (PatientPrescriptionWorkRequest) request;

                    Object[] row = new Object[5];
                    row[0] = patientPrescriptionWorkRequest;
                    row[1] = patientPrescriptionWorkRequest.getAge();
                    row[2] = patientPrescriptionWorkRequest.getDatePrescribed();
                    row[3] = patientPrescriptionWorkRequest.getStatus();
                    row[4] = patientPrescriptionWorkRequest.getOrganization();
                    dtm.addRow(row);  
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

        jScrollPane1 = new javax.swing.JScrollPane();
        tblPatientRecord = new javax.swing.JTable();
        heading = new javax.swing.JLabel();
        jLabel2 = new javax.swing.JLabel();
        lblPharmacistName = new javax.swing.JLabel();
        btnViewPrescription = new javax.swing.JButton();

        setBackground(new java.awt.Color(251, 251, 251));
        setFont(new java.awt.Font("Century Gothic", 0, 16)); // NOI18N

        tblPatientRecord.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {

            },
            new String [] {
                "Patient Name", "Age", "Date Prescribed", "Status", "Organization"
            }
        ) {
            boolean[] canEdit = new boolean [] {
                false, false, false, false, false
            };

            public boolean isCellEditable(int rowIndex, int columnIndex) {
                return canEdit [columnIndex];
            }
        });
        tblPatientRecord.getTableHeader().setReorderingAllowed(false);
        jScrollPane1.setViewportView(tblPatientRecord);
        if (tblPatientRecord.getColumnModel().getColumnCount() > 0) {
            tblPatientRecord.getColumnModel().getColumn(0).setResizable(false);
            tblPatientRecord.getColumnModel().getColumn(1).setResizable(false);
            tblPatientRecord.getColumnModel().getColumn(2).setResizable(false);
            tblPatientRecord.getColumnModel().getColumn(3).setResizable(false);
            tblPatientRecord.getColumnModel().getColumn(4).setResizable(false);
        }

        heading.setFont(new java.awt.Font("Century Gothic", 1, 36)); // NOI18N
        heading.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        heading.setText("Pharmacy");

        jLabel2.setBackground(new java.awt.Color(251, 251, 251));
        jLabel2.setFont(new java.awt.Font("Century Gothic", 1, 18)); // NOI18N
        jLabel2.setForeground(new java.awt.Color(51, 51, 51));
        jLabel2.setText("Welcome");
        jLabel2.setEnabled(false);

        lblPharmacistName.setBackground(new java.awt.Color(251, 251, 251));
        lblPharmacistName.setFont(new java.awt.Font("Century Gothic", 1, 18)); // NOI18N
        lblPharmacistName.setForeground(new java.awt.Color(51, 51, 51));
        lblPharmacistName.setText("<pharmacistName>");
        lblPharmacistName.setEnabled(false);

        btnViewPrescription.setBackground(new java.awt.Color(251, 251, 251));
        btnViewPrescription.setFont(new java.awt.Font("Century Gothic", 1, 18)); // NOI18N
        btnViewPrescription.setText("View Prescription");
        btnViewPrescription.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnViewPrescriptionActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(this);
        this.setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap(174, Short.MAX_VALUE)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addGroup(layout.createSequentialGroup()
                        .addGap(84, 84, 84)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                            .addGroup(layout.createSequentialGroup()
                                .addComponent(jLabel2)
                                .addGap(18, 18, 18)
                                .addComponent(lblPharmacistName))
                            .addComponent(heading, javax.swing.GroupLayout.PREFERRED_SIZE, 268, javax.swing.GroupLayout.PREFERRED_SIZE)))
                    .addGroup(layout.createSequentialGroup()
                        .addGap(131, 131, 131)
                        .addComponent(btnViewPrescription)))
                .addContainerGap(174, Short.MAX_VALUE))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(heading)
                .addGap(49, 49, 49)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel2)
                    .addComponent(lblPharmacistName))
                .addGap(80, 80, 80)
                .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 159, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(37, 37, 37)
                .addComponent(btnViewPrescription, javax.swing.GroupLayout.PREFERRED_SIZE, 57, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(134, Short.MAX_VALUE))
        );
    }// </editor-fold>//GEN-END:initComponents

    private void btnViewPrescriptionActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnViewPrescriptionActionPerformed
        // TODO add your handling code here:

        int selectedRow = tblPatientRecord.getSelectedRow();
        if (selectedRow >= 0) {
            for (WorkRequest request : pharmacyOrganization.getWorkQueue().getWorkRequestList()) {
                if (request instanceof PatientPrescriptionWorkRequest) {
                    PatientPrescriptionWorkRequest patientPrescriptionWorkRequest = (PatientPrescriptionWorkRequest) request;
                    PatientPrescriptionWorkRequest patient = (PatientPrescriptionWorkRequest) tblPatientRecord.getValueAt(selectedRow, 0);
                    if(patient.getPatientId() == patientPrescriptionWorkRequest.getPatientId()){
                        ViewPrescriptionJPanel viewPrescriptionJPanel = new ViewPrescriptionJPanel(userProcessContainer, account, enterprise.getOrganizationDirectory(), pharmacyOrganization, enterprise, system, patient);
                        userProcessContainer.add("viewPrescriptionJPanel", viewPrescriptionJPanel);
                        CardLayout layout = (CardLayout) userProcessContainer.getLayout();
                        layout.next(userProcessContainer);
                    }
                }
            }
        } else {
            JOptionPane.showMessageDialog(null, "Please select a row from table first", "Warning", JOptionPane.WARNING_MESSAGE);
        }
    }//GEN-LAST:event_btnViewPrescriptionActionPerformed


    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton btnViewPrescription;
    private javax.swing.JLabel heading;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JLabel lblPharmacistName;
    private javax.swing.JTable tblPatientRecord;
    // End of variables declaration//GEN-END:variables
}