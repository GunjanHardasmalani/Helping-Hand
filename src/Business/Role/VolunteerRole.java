/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Business.Role;

import Business.EcoSystem;
import Business.Enterprise.Enterprise;
import Business.GenerateLogs;
import Business.Organization.Organization;
import Business.Organization.WelfareOrganization;
import Business.UserAccount.UserAccount;
import javax.swing.JPanel;
import userinterface.VolunteerRole.VolunteerWorkAreaJPanel;

/**
 *
 * @author Gunjan
 */
public class VolunteerRole extends Role{

    @Override
    public JPanel createWorkArea(JPanel userProcessContainer, UserAccount account, Organization organization, Enterprise enterprise, EcoSystem system,GenerateLogs logs) {
        return new VolunteerWorkAreaJPanel(userProcessContainer, account, (WelfareOrganization)organization, enterprise, system, logs);
    }
    
}
