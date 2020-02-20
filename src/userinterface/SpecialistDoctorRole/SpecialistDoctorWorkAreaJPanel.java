/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package userinterface.SpecialistDoctorRole;

import Business.EcoSystem;
import Business.Enterprise.Enterprise;
import Business.Organization.DoctorOrganization;
import Business.Organization.OrganizationDirectory;
import Business.UserAccount.UserAccount;
import Business.WorkQueue.SendLabResultWorkRequest;
import Business.WorkQueue.WorkRequest;
import java.awt.CardLayout;
import java.awt.Desktop;
import java.io.File;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.table.DefaultTableModel;
import userinterface.PhysicianRole.CreateViewPrescription;

/**
 *
 * @author Rohit
 */
public class SpecialistDoctorWorkAreaJPanel extends javax.swing.JPanel {

    /**
     * Creates new form SpecialistDoctorWorkAreaJPanel
     */
    private JPanel userProcessContainer;
    private UserAccount account;
    private OrganizationDirectory organizationDirectory;
    private DoctorOrganization doctorOrganization;
    private Enterprise enterprise;
    private EcoSystem system;
    private SendLabResultWorkRequest sendLabResultWorkRequest;
    private String imageDir;

    public SpecialistDoctorWorkAreaJPanel(JPanel userProcessContainer, UserAccount account, DoctorOrganization doctorOrganization, Enterprise enterprise) {
        initComponents();
        this.userProcessContainer = userProcessContainer;
        this.account = account;
        this.organizationDirectory = organizationDirectory;
        this.doctorOrganization = doctorOrganization;
        this.enterprise = enterprise;
        this.system = system;
        lblDoctorName.setText(account.getEmployee().getName());
        populateTable();
    }

    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        btnViewReport = new javax.swing.JButton();
        heading = new javax.swing.JLabel();
        jScrollPane1 = new javax.swing.JScrollPane();
        tblPatientRecords = new javax.swing.JTable();
        jLabel2 = new javax.swing.JLabel();
        lblDoctorName = new javax.swing.JLabel();
        btnPrescription = new javax.swing.JButton();

        setBackground(new java.awt.Color(251, 251, 251));

        btnViewReport.setBackground(new java.awt.Color(251, 251, 251));
        btnViewReport.setFont(new java.awt.Font("Century Gothic", 1, 18)); // NOI18N
        btnViewReport.setText("View Report");
        btnViewReport.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnViewReportActionPerformed(evt);
            }
        });

        heading.setFont(new java.awt.Font("Century Gothic", 1, 36)); // NOI18N
        heading.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        heading.setText("Patient Records");

        tblPatientRecords.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {

            },
            new String [] {
                "Patient Name", "Sender", "Status", "Date"
            }
        ) {
            boolean[] canEdit = new boolean [] {
                false, false, false, false
            };

            public boolean isCellEditable(int rowIndex, int columnIndex) {
                return canEdit [columnIndex];
            }
        });
        tblPatientRecords.getTableHeader().setReorderingAllowed(false);
        jScrollPane1.setViewportView(tblPatientRecords);
        if (tblPatientRecords.getColumnModel().getColumnCount() > 0) {
            tblPatientRecords.getColumnModel().getColumn(0).setResizable(false);
            tblPatientRecords.getColumnModel().getColumn(1).setResizable(false);
            tblPatientRecords.getColumnModel().getColumn(2).setResizable(false);
            tblPatientRecords.getColumnModel().getColumn(3).setResizable(false);
        }

        jLabel2.setBackground(new java.awt.Color(251, 251, 251));
        jLabel2.setFont(new java.awt.Font("Century Gothic", 1, 18)); // NOI18N
        jLabel2.setForeground(new java.awt.Color(51, 51, 51));
        jLabel2.setText("Welcome");
        jLabel2.setEnabled(false);

        lblDoctorName.setBackground(new java.awt.Color(251, 251, 251));
        lblDoctorName.setFont(new java.awt.Font("Century Gothic", 1, 18)); // NOI18N
        lblDoctorName.setForeground(new java.awt.Color(51, 51, 51));
        lblDoctorName.setText("<doctorName>");
        lblDoctorName.setEnabled(false);

        btnPrescription.setBackground(new java.awt.Color(251, 251, 251));
        btnPrescription.setFont(new java.awt.Font("Century Gothic", 1, 18)); // NOI18N
        btnPrescription.setText("Make/View Prescription");
        btnPrescription.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnPrescriptionActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(this);
        this.setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap(143, Short.MAX_VALUE)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(heading, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.PREFERRED_SIZE, 544, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING, false)
                        .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 504, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGroup(layout.createSequentialGroup()
                            .addComponent(btnViewReport, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                            .addGap(47, 47, 47)
                            .addComponent(btnPrescription, javax.swing.GroupLayout.PREFERRED_SIZE, 263, javax.swing.GroupLayout.PREFERRED_SIZE))))
                .addContainerGap(148, Short.MAX_VALUE))
            .addGroup(layout.createSequentialGroup()
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(jLabel2)
                .addGap(39, 39, 39)
                .addComponent(lblDoctorName)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                .addGap(62, 62, 62)
                .addComponent(heading, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addGap(48, 48, 48)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(lblDoctorName)
                    .addComponent(jLabel2))
                .addGap(18, 18, 18)
                .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 198, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(44, 44, 44)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(btnPrescription, javax.swing.GroupLayout.PREFERRED_SIZE, 60, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(btnViewReport, javax.swing.GroupLayout.PREFERRED_SIZE, 60, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(201, 201, 201))
        );
    }// </editor-fold>//GEN-END:initComponents
    public void populateTable() {
        DefaultTableModel dtm = (DefaultTableModel) tblPatientRecords.getModel();
        dtm.setRowCount(0);
        for (WorkRequest request : doctorOrganization.getWorkQueue().getWorkRequestList()) {
            if (request instanceof SendLabResultWorkRequest) {
                SendLabResultWorkRequest sendLabResultWorkRequest = (SendLabResultWorkRequest) request;

                Object[] row = new Object[4];
                row[0] = sendLabResultWorkRequest;
                row[1] = sendLabResultWorkRequest.getSender();
                row[2] = sendLabResultWorkRequest.getStatus();
                row[3] = sendLabResultWorkRequest.getRequestDate();
                dtm.addRow(row);
            }
        }

    }


    private void btnViewReportActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnViewReportActionPerformed
        // TODO add your handling code here:
        int selectedRow = tblPatientRecords.getSelectedRow();
        if (selectedRow >= 0) {
            for (WorkRequest request : doctorOrganization.getWorkQueue().getWorkRequestList()) {
                if (request instanceof SendLabResultWorkRequest){
                SendLabResultWorkRequest sendLabResultWorkRequest = (SendLabResultWorkRequest) request;
                imageDir = sendLabResultWorkRequest.getFilePath();
                }
            }
            try {

                File pdfFile = new File(imageDir);
                if (pdfFile.exists()) {

                    if (Desktop.isDesktopSupported()) {
                        Desktop.getDesktop().open(pdfFile);
                    } else {
                        System.out.println("Awt Desktop is not supported!");
                    }

                } else {
                    System.out.println("File is not exists!");
                }

                System.out.println("Done");

            } catch (Exception ex) {
                ex.printStackTrace();
            }
        }
        else{
            JOptionPane.showMessageDialog(null, "Please select a row from the table to view Lab Report", "Warning", JOptionPane.WARNING_MESSAGE);
        }

    }//GEN-LAST:event_btnViewReportActionPerformed

    private void btnPrescriptionActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnPrescriptionActionPerformed
        // TODO add your handling code here:
        int selectedRow = tblPatientRecords.getSelectedRow();
        if (selectedRow >= 0) {
            for (WorkRequest request : doctorOrganization.getWorkQueue().getWorkRequestList()) {
                if (request instanceof SendLabResultWorkRequest) {
                    SendLabResultWorkRequest sendLabResultWorkRequest = (SendLabResultWorkRequest) request;
                    SendLabResultWorkRequest patient = (SendLabResultWorkRequest) tblPatientRecords.getValueAt(selectedRow, 0);
                    if(patient.getPatientId() == sendLabResultWorkRequest.getPatientId()){
                    CreateViewPatientPrescriptionJPanel createViewPatientPrescriptionJPanel = new CreateViewPatientPrescriptionJPanel(userProcessContainer, account, enterprise.getOrganizationDirectory(), doctorOrganization, enterprise, system, patient);
                    userProcessContainer.add("createViewPatientPrescriptionJPanel", createViewPatientPrescriptionJPanel);
                    CardLayout layout = (CardLayout) userProcessContainer.getLayout();
                    layout.next(userProcessContainer);
                    }
                }
            }
        } else {
            JOptionPane.showMessageDialog(null, "Please select a row from table first", "Warning", JOptionPane.WARNING_MESSAGE);
        }
    }//GEN-LAST:event_btnPrescriptionActionPerformed


    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton btnPrescription;
    private javax.swing.JButton btnViewReport;
    private javax.swing.JLabel heading;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JLabel lblDoctorName;
    private javax.swing.JTable tblPatientRecords;
    // End of variables declaration//GEN-END:variables
}