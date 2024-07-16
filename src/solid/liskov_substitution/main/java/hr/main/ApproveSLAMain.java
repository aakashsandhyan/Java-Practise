package solid.liskov_substitution.main.java.hr.main;

import solid.liskov_substitution.main.java.hr.logging.ConsoleLogger;
import solid.liskov_substitution.main.java.hr.persistence.SubcontractorsRepository;
import solid.liskov_substitution.main.java.hr.personnel.ServiceLicenseAgreement;
import solid.liskov_substitution.main.java.hr.personnel.Subcontractor;

import java.util.List;

public class ApproveSLAMain {
    public static void main(String[] args) {
        // Create dependencies
        ConsoleLogger consoleLogger = new ConsoleLogger();
        SubcontractorsRepository repository = new SubcontractorsRepository();

        // Define SLA
        int minTimeOffPercent = 98;
        int maxResolutionDays = 2;
        ServiceLicenseAgreement companySla = new ServiceLicenseAgreement(
                minTimeOffPercent,
                maxResolutionDays);

        // Grab subcontractors
        List<Subcontractor> subcontractors = repository.findAll();

        for (Subcontractor subcontractor : subcontractors){
                subcontractor.approveSLA(companySla);
        }
    }
}
