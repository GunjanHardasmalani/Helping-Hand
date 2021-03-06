/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Business.Role;

import Business.EcoSystem;
import Business.Enterprise.Enterprise;
import Business.GenerateLogs;
import Business.Organization.LabOrganization;
import Business.Organization.Organization;
import Business.UserAccount.UserAccount;
import javax.swing.JPanel;
import userinterface.PathologistRole.PathologistWorkAreaJPanel;

/**
 *
 * @author gulat
 */
public class PathologistRole extends Role {

    @Override
    public JPanel createWorkArea(JPanel userProcessContainer, UserAccount account, Organization organization, Enterprise enterprise, EcoSystem business,GenerateLogs logs) {
        return new PathologistWorkAreaJPanel(userProcessContainer, account, (LabOrganization)organization, enterprise, business);
    }
    
    
}
