import java.text.DecimalFormat;
import java.util.Scanner;

public class GPACalculator {

    public static void main(String[] args) {
        // Total points / total credits
        // points for a class = grade value * credits
        // A = 4, B = 3....

        Scanner scanner = new Scanner(System.in);

        Integer totalPoints = 0;
        Integer totalCredits = 0;

        boolean moreClasses = false;

        do {

            Integer credits = 0;
            boolean validCredits = true;
            do {
                validCredits = true;

                System.out.println("Enter number of credits:");
                String creditsString = scanner.nextLine();

                try {
                    credits = Integer.parseInt(creditsString);
                } catch (NumberFormatException nfe) {
                    System.out.println("Please enter a valid integer");
                    validCredits = false;
                }
            } while (!validCredits);

            boolean validGrade = true;

            Integer gradeVal = 0;
            String grade = "";
            do {
                validGrade = true;

                System.out.println("Enter grade:");
                grade = scanner.nextLine();

                if (grade.equalsIgnoreCase("A+")) {
                    gradeVal = 10;
                } else if (grade.equalsIgnoreCase("A")) {
                    gradeVal = 9;
                } else if (grade.equalsIgnoreCase("A-")) {
                    gradeVal = 8;
                } else if (grade.equalsIgnoreCase("B+")) {
                    gradeVal = 7;
                } else if (grade.equalsIgnoreCase("B")) {
                    gradeVal = 6;
                } else if (grade.equalsIgnoreCase("C+")) {
                    gradeVal = 5;
                } else if (grade.equalsIgnoreCase("C")) {
                    gradeVal = 4;
                } else if (grade.equalsIgnoreCase("D+")) {
                    gradeVal = 3;
                } else if (grade.equalsIgnoreCase("D")) {
                    gradeVal = 2;
                } else if (grade.equalsIgnoreCase("E")) {
                    gradeVal = 1;
                } else if (grade.equalsIgnoreCase("F")) {
                    gradeVal = 0;
                } else {
                    System.out.println("invlaid ");
                    validGrade = false;
                }
            } while (!validGrade);

            Integer points = gradeVal * credits;

            totalPoints += points;
            totalCredits += credits;

            System.out.println("Would you like to enter another class? (Y/N)");
            String moreClassesString = scanner.nextLine();

            moreClasses = moreClassesString.equalsIgnoreCase("Y");

        } while (moreClasses);

        DecimalFormat df = new DecimalFormat("0.00");

        Double gpa = Double.valueOf(totalPoints) / Double.valueOf(totalCredits);

        System.out.println("Credits: " + totalCredits);
        System.out.println("Points: " + totalPoints);
        System.out.println("GPA: " + df.format(gpa));

        scanner.close();
    }
}
