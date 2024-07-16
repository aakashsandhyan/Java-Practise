package solid.open_close.main.java.hr.taxes;

import solid.open_close.main.java.hr.personnel.Employee;

public class FullTimeEmployeeTaxCalculator implements TaxCalculator {
    @Override
    public double calculate(Employee employee) {
        return 100d + (0.16 + 0.10) * employee.getMonthlyIncome();
    }
}
