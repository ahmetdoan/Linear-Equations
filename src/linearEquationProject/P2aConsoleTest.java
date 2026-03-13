package linearEquationProject;
import java.util.Scanner;
public class P2aConsoleTest {
	public static void main(String[] args) {
        Scanner input = new Scanner(System.in);
        double[][] m = new double[2][3];

        System.out.println("Katsayıları girin:");
        System.out.println("[0][0]x + [0][1]y = [0][2]");
        System.out.println("[1][0]x + [1][1]y = [1][2]\n");

        for (int i = 0; i < 2; i++)
            for (int j = 0; j < 3; j++) {
                System.out.printf("[%d][%d]: ", i, j);
                m[i][j] = input.nextDouble();
            }

        LinearEquation eq = new LinearEquation(
            m[0][0], m[0][1], m[1][0], m[1][1], m[0][2], m[1][2]);

        if (eq.isSolvable()) {
        	System.out.println("solution for this system is:");
            System.out.println("x = " + eq.getX());
            System.out.println("y = " + eq.getY());
        } else {
            System.out.println("The equation has no solution.");
        }
    }
}
