package solid.liskov_substitution.main.java.hr.personnel;

public class Subcontractor {

    private String firstName;
    private String lastName;
    private int monthlyIncome;
    private int nbHoursPerWeek;

    public Subcontractor(String fullName, int monthlyIncome) {
        setMonthlyIncome(monthlyIncome);

        String[] names = fullName.split(" ");
        this.firstName = names[0];
        this.lastName = names[1];
    }

    public void setMonthlyIncome(int monthlyIncome) {
        if (monthlyIncome < 0) {
            throw new IllegalArgumentException("Income must be positive");
        }

        this.monthlyIncome = monthlyIncome;
    }

    public boolean approveSLA(ServiceLicenseAgreement sla) {
        /*
        Business logic for approving a
        service license agreement for a
        for a subcontractor
         */
        boolean result = false;
        if (sla.getMinUptimePercent() >= 98
                && sla.getProblemResolutionTimeDays() <= 2) {
            result=  true;
        }

        System.out.println("SLA approval for " + this.getFullName() + ": " + result);
        return result;
    }

    public String getFullName() {
        return this.firstName + " " + this.lastName;
    }
}
