package solid.liskov_substitution.main.java.hr.taxes;

import solid.liskov_substitution.main.java.hr.personnel.Employee;
import solid.liskov_substitution.main.java.hr.personnel.FullTimeEmployee;
import solid.liskov_substitution.main.java.hr.personnel.Intern;
import solid.liskov_substitution.main.java.hr.personnel.PartTimeEmployee;

public class TaxCalculatorFactory {
    public static TaxCalculator create(Employee employee) {
        if (employee instanceof FullTimeEmployee) {
            return new FullTimeTaxCalculator();
        }

        if (employee instanceof PartTimeEmployee) {
            return new PartTimeTaxCalculator();
        }

        if (employee instanceof Intern) {
            return new InternTaxCalculator();
        }

        throw new RuntimeException("Invalid employee type");
    }
}
