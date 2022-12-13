public class Employee {
    private int annualSalaryUSD;
    private String name;

    Employee(String name, int annualSalaryUSD) {
        this.name = name;
        this.annualSalaryUSD = annualSalaryUSD;
    }

    public String getName() {
        return name;
    }

    public int getAnnualSalaryUSD() {
        return annualSalaryUSD;
    }

    public boolean requestNewSalary(int newAnnualSalaryUSD) {
        if (requestHRApproval(annualSalaryUSD, newAnnualSalaryUSD)) {
            annualSalaryUSD = newAnnualSalaryUSD;
            return true;
        } else {
            return false;
        }
    }

    private static boolean requestHRApproval(int oldSalary, int newSalary) {
        if (newSalary <= oldSalary) {
            return true;
        } else {
            return false;
        }
    }
}
