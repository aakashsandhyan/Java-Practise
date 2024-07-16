package solid.open_close.main.java.hr.main;

import solid.open_close.main.java.hr.logging.ConsoleLogger;
import solid.open_close.main.java.hr.persistence.EmployeeFileSerializer;
import solid.open_close.main.java.hr.persistence.EmployeeRepository;
import solid.open_close.main.java.hr.personnel.Employee;
import solid.open_close.main.java.hr.taxes.TaxCalculator;
import solid.open_close.main.java.hr.taxes.TaxCalculatorFactory;

import java.text.NumberFormat;
import java.util.List;
import java.util.Locale;

public class CalculateTaxesMain {
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

            TaxCalculator taxCalculator = TaxCalculatorFactory.taxCalculator(employee);
            // compute individual tax
            double tax = taxCalculator.calculate(employee);
            String formattedTax = currencyFormatter.format(tax);
            consoleLogger.writeInfo(employee.getFullName() + " taxes: " + formattedTax);

            // add to company total taxes
            totalTaxes += tax;
        }
        consoleLogger.writeInfo("Total taxes = " + currencyFormatter.format(totalTaxes));
    }
}
