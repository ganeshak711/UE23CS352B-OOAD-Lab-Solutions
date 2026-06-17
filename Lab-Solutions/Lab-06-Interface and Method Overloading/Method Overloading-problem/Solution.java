import java.util.Scanner;

class Employee {

    // 1. Bonus based only on salary
    double calculateBonus(double salary) {
        return 0.10 * salary;
    }

    // 2. Bonus based on salary and performance rating
    double calculateBonus(double salary, double performanceRating) {
        return salary * (0.05 + performanceRating * 0.02);
    }

    // 3. Bonus based on salary and years of experience
    double calculateBonus(double salary, int yearsOfService) {
        return salary * (0.08 + yearsOfService * 0.01);
    }
}

public class Solution {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        double salary = sc.nextDouble();
        int choice = sc.nextInt();
        // 1 -> only salary
        // 2 -> salary + performance rating
        // 3 -> salary + years of service

        Employee emp = new Employee();
        double bonus = 0;

        switch (choice) {
            case 1:
                bonus = emp.calculateBonus(salary);
                break;
            case 2:
                double rating = sc.nextDouble();
                bonus = emp.calculateBonus(salary, rating);
                break;
            case 3:
                int years = sc.nextInt();
                bonus = emp.calculateBonus(salary, years);
                break;
            default:
                System.out.println("Invalid Choice");
                return;
        }

        System.out.printf("%.2f", bonus);
        sc.close();
    }
}
