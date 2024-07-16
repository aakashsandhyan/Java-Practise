package solid.liskov_substitution.main.java.hr.main;

import solid.liskov_substitution.main.java.hr.logging.ConsoleLogger;
import solid.liskov_substitution.main.java.hr.persistence.EmployeeFileSerializer;
import solid.liskov_substitution.main.java.hr.persistence.EmployeeRepository;
import solid.liskov_substitution.main.java.hr.personnel.Employee;

import java.io.IOException;
import java.util.List;

public class SaveEmployeesMain {
    public static void main(String[] args) {
        // Grab employees
        EmployeeFileSerializer employeeFileSerializer = new EmployeeFileSerializer();
        ConsoleLogger consoleLogger = new ConsoleLogger();

        EmployeeRepository repository = new EmployeeRepository(employeeFileSerializer);
        List<Employee> employees = repository.findAll();

        // Save all
        for (Employee e : employees){
            try {
                repository.save(e);
                consoleLogger.writeInfo("Saved employee " + e.toString());
            } catch (IOException exception) {
                consoleLogger.writeError("Error saving employee", exception);
            }
        }
    }
}
