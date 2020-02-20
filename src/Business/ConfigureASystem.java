package Business;

import Business.Employee.Employee;
import Business.Enterprise.Enterprise;
import Business.Network.Network;
import Business.Organization.Organization;
import Business.Patient.Patient;
import Business.Role.AdminRole;
import Business.Role.DHSSAdminRole;
import Business.Role.PathologistRole;
import Business.Role.PharmacistRole;
import Business.Role.PhysicianRole;
import Business.Role.SpecialistDoctorRole;
import Business.Role.SystemAdminRole;
import Business.Role.VolunteerRole;
import Business.UserAccount.UserAccount;

/**
 *
 * @author mayur
 */
public class ConfigureASystem {

    public static EcoSystem configure() {

        EcoSystem system = EcoSystem.getInstance();

        //Create System Admin
        Employee employee = system.getEmployeeDirectory().createEmployee("System Admin");
        UserAccount ua = system.getUserAccountDirectory().createUserAccount("admin@hh.com", "hhadmin", employee, new SystemAdminRole());

        //Create network
        Network n1 = system.createAndAddNetwork();
        n1.setName("Massachusetts");

        //Create enterprise(NGO) of network(Massachusetts)
        //Create Enterprise Admin of BNID NGO
        Enterprise e1 = n1.getEnterpriseDirectory().createAndAddEnterprise("Boston network for international development(BNID)", Enterprise.EnterpriseType.NGO);
        Employee employee1 = e1.getEmployeeDirectory().createEmployee("BNID ADMIN");
        UserAccount ua1 = e1.getUserAccountDirectory().createUserAccount("bnidadmin@hh.com", "bnidadmin", employee1, new AdminRole());

        //set welfare organization of enterprise(NGO) and volunteer, physician employee and role
        Organization welOrg = e1.getOrganizationDirectory().createOrganization(Organization.Type.Welfare);
        welOrg.setName("Welfare Organization");
        Employee welOrgEmployee1 = welOrg.getEmployeeDirectory().createEmployee("Volunteer");
        UserAccount welUserAccount1 = welOrg.getUserAccountDirectory().createUserAccount("vol@hhadmin.com", "vol", welOrgEmployee1, new VolunteerRole());

        Employee welOrgEmployee2 = welOrg.getEmployeeDirectory().createEmployee("Physician");
        UserAccount welUserAccount2 = welOrg.getUserAccountDirectory().createUserAccount("phy@hhadmin.com", "phy", welOrgEmployee2, new PhysicianRole());

        //set DHSS organization of enterprise(NGO) and dhssadmin employee and role
        Organization dhssOrg = e1.getOrganizationDirectory().createOrganization(Organization.Type.DHSS);
        dhssOrg.setName("DHSS Organization");
        Employee dhssOrgEmployee1 = dhssOrg.getEmployeeDirectory().createEmployee("DHSS Admin");
        UserAccount dhssOrgUserAccount1 = dhssOrg.getUserAccountDirectory().createUserAccount("dhss@hhadmin.com", "dhss", dhssOrgEmployee1, new DHSSAdminRole());

        //Create enterprise(Hospital) of network(Massachusetts)
        //Create Enterprise Admin of BGH NGO
        Enterprise e2 = n1.getEnterpriseDirectory().createAndAddEnterprise("Boston General Hospital(BGH)", Enterprise.EnterpriseType.Hospital);
        Employee employee2 = e2.getEmployeeDirectory().createEmployee("BGH ADMIN");
        UserAccount ua2 = e2.getUserAccountDirectory().createUserAccount("bghadmin@hh.com", "bghadmin", employee2, new AdminRole());

        
        //set Lab organization of enterprise(Hospital) and employee and role
        Organization labOrg = e2.getOrganizationDirectory().createOrganization(Organization.Type.Lab);
        labOrg.setName("Lab Organization");
        Employee labOrgEmployee1 = labOrg.getEmployeeDirectory().createEmployee("Pathologist");
        UserAccount labOrgUserAccount1 = labOrg.getUserAccountDirectory().createUserAccount("path@hhadmin.com", "path", labOrgEmployee1, new PathologistRole());
        
        
        //set Doctor organization of enterprise(Hospital) and employee and role
        Organization docOrg = e2.getOrganizationDirectory().createOrganization(Organization.Type.Doctor);
        docOrg.setName("Doctor Organization");
        Employee docOrgEmployee1 = docOrg.getEmployeeDirectory().createEmployee("Specialist Doctor");
        UserAccount docOrgUserAccount1 = docOrg.getUserAccountDirectory().createUserAccount("doc@hhadmin.com", "doc", docOrgEmployee1, new SpecialistDoctorRole());
        
        //set Pharmacy organization of enterprise(Hospital) and employee and role
        Organization pharmaOrg = e2.getOrganizationDirectory().createOrganization(Organization.Type.Pharmacy);
        pharmaOrg.setName("Pharmacy Organization");
        Employee pharmaOrgEmployee1 = pharmaOrg.getEmployeeDirectory().createEmployee("Pharmacist");
        UserAccount pharmaOrgUserAccount1 = pharmaOrg.getUserAccountDirectory().createUserAccount("pharma@hhadmin.com", "pharma", pharmaOrgEmployee1, new PharmacistRole());
        
        return system;
    }

}
