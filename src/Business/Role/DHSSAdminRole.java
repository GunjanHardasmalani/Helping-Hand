/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Business.Role;

import Business.EcoSystem;
import Business.Enterprise.Enterprise;
import Business.GenerateLogs;
import Business.Organization.DHSSOrganization;
import Business.Organization.Organization;
import Business.UserAccount.UserAccount;
import javax.swing.JPanel;
import userinterface.DHSSRole.DHSSAdminWorkAreaJPanel;

/**
 *
 * @author Gunjan
 */
public class DHSSAdminRole extends Role {

    @Override
    public JPanel createWorkArea(JPanel userProcessContainer, UserAccount account, Organization organization, Enterprise enterprise, EcoSystem business,GenerateLogs logs) {
       return new DHSSAdminWorkAreaJPanel(userProcessContainer, account, (DHSSOrganization)organization, enterprise, business, logs);
    }
    
}
