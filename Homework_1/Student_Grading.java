import java.util.Scanner;

public class Student_Grading {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);

		// 1 Input point
		System.out.print("Enter your Mathematics point: ");
		double mathematics = sc.nextDouble();
		System.out.print("Enter your English point: ");
		double english = sc.nextDouble();
		System.out.print("Enter your Literature point: ");
		double literature = sc.nextDouble();

		// 2 Count Average Point & Find minPoint
		double average = (mathematics + english + literature) / 3.0;
		double minPoint = Math.min(mathematics, Math.min(english, literature));
		char finalGrade;

		// 3 Logic
		if (minPoint < 5) {
			finalGrade = 'F';
		}

		else {
			char averageGrade = getGrade(average);
			char minSubjectGrade = getGrade(minPoint);

			int averageLevel = getToLevel(averageGrade);
			int minLevel = getToLevel(minSubjectGrade);

			if (averageLevel > minLevel + 1) {
				finalGrade = levelToGrade(minLevel + 1);
			} else {
				finalGrade = averageGrade;
			}
		}

		// 4 Out put
		System.out.println("\n--- Your Results ---");
		System.out.printf("Mathematics: %.2f (%c)\n", mathematics, getGrade(mathematics));
		System.out.printf("English: %.2f (%c) \n", english, getGrade(english));
		System.out.printf("Literature: %.2f (%c)\n", literature, getGrade(literature));
		System.out.printf("Final Average: %.2f \n", average);
		System.out.println("Final Grade: " + finalGrade);

		printMessage(finalGrade);

		sc.close();
	}

	// 5 Support Methods

	public static char getGrade(double point) {
		if (point >= 9)
			return 'S';
		if (point >= 8)
			return 'A';
		if (point >= 7)
			return 'B';
		if (point >= 6)
			return 'C';
		if (point >= 5)
			return 'D';
		return 'F';
	}

	public static int getToLevel(char grade) {
		return switch (grade) {
			case 'S' -> 5;
			case 'A' -> 4;
			case 'B' -> 3;
			case 'C' -> 2;
			case 'D' -> 1;
			default -> 0;
		};
	}

	public static char levelToGrade(int level) {
		return switch (level) {
			case 5 -> 'S';
			case 4 -> 'A';
			case 3 -> 'B';
			case 2 -> 'C';
			case 1 -> 'D';
			default -> 'F';
		};
	}

	public static void printMessage(char grade) {
		switch (grade) {
			case 'S' -> System.out.println("Excellent Student");
			case 'A' -> System.out.println("Good Student");
			case 'B' -> System.out.println("Normal Student");
			case 'C' -> System.out.println("Average Student");
			case 'D' -> System.out.println("Not bad Student");
			default -> System.out.println("Fail Student");
		}
	}
}