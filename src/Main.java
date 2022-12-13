import java.lang.reflect.Field;

public class Main {
    public static void main(String[] args) {
        Employee steve = new Employee("Steve Smith", 140000);

        System.out.println("Employee name: " + steve.getName());
        System.out.println("Current salary: " + steve.getAnnualSalaryUSD());

        System.out.println("Will " + steve.getName() + " be approved for a raise?");
        System.out.println(steve.requestNewSalary(160000));

        System.out.println("HR says no, " + steve.getName() + " is sad :(");
        System.out.println("Fortunately, he knows scopes in Java don't actually pose a significant challenge.");

        try {
            Field annualSalaryUSDField = Employee.class.getDeclaredField("annualSalaryUSD");
            annualSalaryUSDField.setAccessible(true);
            annualSalaryUSDField.setInt(steve, 160000);
        } catch (NoSuchFieldException | IllegalAccessException e) {
            throw new RuntimeException(e);
        }

        System.out.println("With a bit of Java reflection, " + steve.getName() + " got himself the raise he deserved!");
        System.out.println("Current salary: " + steve.getAnnualSalaryUSD());
    }
}