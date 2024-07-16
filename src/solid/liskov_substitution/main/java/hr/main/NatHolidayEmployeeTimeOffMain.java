package solid.liskov_substitution.main.java.hr.main;

import solid.liskov_substitution.main.java.hr.logging.ConsoleLogger;
import solid.liskov_substitution.main.java.hr.persistence.EmployeeFileSerializer;
import solid.liskov_substitution.main.java.hr.persistence.EmployeeRepository;
import solid.liskov_substitution.main.java.hr.personnel.Employee;
import solid.liskov_substitution.main.java.hr.personnel.FullTimeEmployee;

import java.util.List;

public class NatHolidayEmployeeTimeOffMain {
    public static void main(String[] args) {
        // Create dependencies
        ConsoleLogger consoleLogger = new ConsoleLogger();
        EmployeeFileSerializer employeeFileSerializer = new EmployeeFileSerializer();
        EmployeeRepository repository = new EmployeeRepository(employeeFileSerializer);

        // Grab employees
        List<Employee> employees = repository.findAll();
        Employee manager = new FullTimeEmployee("Steve Jackson", 5000);

        // Request time off for each employee on
        // national holiday
        for (Employee employee : employees){
            employee.requestTimeOff(1, manager);
        }
    }
}
