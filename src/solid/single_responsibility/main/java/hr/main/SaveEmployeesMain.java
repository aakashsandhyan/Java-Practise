package solid.single_responsibility.main.java.hr.main;

import solid.single_responsibility.main.java.hr.serializer.EmployeeFileSerializer;
import solid.single_responsibility.main.java.hr.logging.ConsoleLogger;
import solid.single_responsibility.main.java.hr.persistence.EmployeeRepository;
import solid.single_responsibility.main.java.hr.personnel.Employee;

import java.io.IOException;
import java.nio.file.Paths;
import java.util.List;

public class SaveEmployeesMain {
    public static void main(String[] args) {
        // Grab employees
        String basePath = Paths.get("").toAbsolutePath() + "/solid_principles_repo";
        EmployeeRepository repository = new EmployeeRepository(new EmployeeFileSerializer(), basePath);
        ConsoleLogger consoleLogger = new ConsoleLogger();
        List<Employee> employees = repository.findAll();

        // Save all
        for (Employee employee : employees){
            try {
                repository.save(employee);
                consoleLogger.logInfo("Saved employee successfully: " + employee);
            } catch (IOException ex) {
                consoleLogger.logError("Error occured while saving employee: " + ex);
            }
        }
    }
}
