package solid.open_close.main.java.hr.taxes;

import solid.open_close.main.java.hr.personnel.Employee;
import solid.open_close.main.java.hr.personnel.FullTimeEmployee;
import solid.open_close.main.java.hr.personnel.PartTimeEmployee;

public class TaxCalculatorFactory {

    public static TaxCalculator taxCalculator(Employee employee){
        if (employee instanceof FullTimeEmployee){
            return new FullTimeEmployeeTaxCalculator();
        }
        else if (employee instanceof PartTimeEmployee){
            return new FullTimeEmployeeTaxCalculator();
        }
        else {
            return new InternTaxCalculator();
        }
    }
}
