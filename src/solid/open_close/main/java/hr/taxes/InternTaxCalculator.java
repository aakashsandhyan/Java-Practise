package solid.open_close.main.java.hr.taxes;

import solid.open_close.main.java.hr.personnel.Employee;

public class InternTaxCalculator implements TaxCalculator {
    @Override
    public double calculate(Employee employee) {
        if(employee.getMonthlyIncome() < 350){
            return 0;
        }
        return 0.16 * employee.getMonthlyIncome();
    }
}
