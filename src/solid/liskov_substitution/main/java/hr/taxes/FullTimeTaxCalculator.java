package solid.liskov_substitution.main.java.hr.taxes;

import solid.liskov_substitution.main.java.hr.personnel.Employee;

public class FullTimeTaxCalculator implements TaxCalculator {
    private final int RETIREMENT_TAX_PERCENTAGE = 10;
    private final int INCOME_TAX_PERCENTAGE = 16;
    private final int BASE_HEALTH_INSURANCE = 100;


    public double calculate(Employee employee) {
        return BASE_HEALTH_INSURANCE +
                (employee.getMonthlyIncome() * RETIREMENT_TAX_PERCENTAGE) / 100 +
                (employee.getMonthlyIncome() * INCOME_TAX_PERCENTAGE) / 100;

    }
}
