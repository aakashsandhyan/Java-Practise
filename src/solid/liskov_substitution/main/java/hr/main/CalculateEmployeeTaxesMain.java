package solid.liskov_substitution.main.java.hr.main;

import solid.liskov_substitution.main.java.hr.logging.ConsoleLogger;
import solid.liskov_substitution.main.java.hr.persistence.EmployeeFileSerializer;
import solid.liskov_substitution.main.java.hr.persistence.EmployeeRepository;
import solid.liskov_substitution.main.java.hr.personnel.Employee;
import solid.liskov_substitution.main.java.hr.taxes.TaxCalculator;
import solid.liskov_substitution.main.java.hr.taxes.TaxCalculatorFactory;

import java.text.NumberFormat;
import java.util.List;
import java.util.Locale;

public class CalculateEmployeeTaxesMain {
    public static void main(String[] args) {
        // Create dependencies
        ConsoleLogger consoleLogger = new ConsoleLogger();
        EmployeeFileSerializer employeeFileSerializer = new EmployeeFileSerializer();
        EmployeeRepository repository = new EmployeeRepository(employeeFileSerializer);

        // Grab employees
        List<Employee> employees = repository.findAll();

        // Calculate taxes
        Locale locale = new Locale("en", "US");
        NumberFormat currencyFormatter = NumberFormat.getCurrencyInstance(locale);

        double totalTaxes = 0;
        for (Employee employee: employees){
            TaxCalculator taxCalculator = TaxCalculatorFactory.create(employee);

            // compute individual tax
            double tax = taxCalculator.calculate(employee);
            String formattedTax = currencyFormatter.format(tax);
            consoleLogger.writeInfo(employee.getFullName() + " taxes: " + formattedTax);

            // add to company total taxes
            totalTaxes += taxCalculator.calculate(employee);
        }
        consoleLogger.writeInfo("Total taxes = " + currencyFormatter.format(totalTaxes));
    }
}
