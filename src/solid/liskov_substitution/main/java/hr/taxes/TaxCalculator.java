package solid.liskov_substitution.main.java.hr.taxes;


import solid.liskov_substitution.main.java.hr.personnel.Employee;

public interface TaxCalculator {
    double calculate(Employee employee);
}
