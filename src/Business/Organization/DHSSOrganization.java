/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Business.Organization;

import Business.Role.DHSSAdminRole;
import Business.Role.Role;
import com.sun.org.apache.xpath.internal.operations.Or;
import java.util.ArrayList;

/**
 *
 * @author Gunjan
 */
public class DHSSOrganization extends Organization {

    public DHSSOrganization(){
        super(Organization.Type.DHSS.getValue());
    }
    @Override
    public ArrayList<Role> getSupportedRole() {
        ArrayList<Role> roles = new ArrayList();
        roles.add(new DHSSAdminRole());
        return roles;
    }
    
}
