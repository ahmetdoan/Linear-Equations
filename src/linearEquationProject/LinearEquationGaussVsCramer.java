package linearEquationProject;

import java.util.Scanner;

public class LinearEquationGaussVsCramer {
    public static void main(String[] args) {
        Scanner input = new Scanner(System.in);
 
        double[][] m = new double[3][4];

        System.out.println("Enter 3x3 system coefficients:");
        System.out.println("[0][0]x + [0][1]y + [0][2]z = [0][3]");
        System.out.println("[1][0]x + [1][1]y + [1][2]z = [1][3]");
        System.out.println("[2][0]x + [2][1]y + [2][2]z = [2][3]\n");

        for (int i = 0; i < 3; i++)
            for (int j = 0; j < 4; j++) {
                System.out.printf("[%d][%d]: ", i, j);
                m[i][j] = input.nextDouble();
            }

        LinearEquation3x3Cramer cramer = new LinearEquation3x3Cramer(
            m[0][0], m[0][1], m[0][2], m[0][3],
            m[1][0], m[1][1], m[1][2], m[1][3],
            m[2][0], m[2][1], m[2][2], m[2][3]);

        LinearEquation3x3Gauss gauss = new LinearEquation3x3Gauss(
            m[0][0], m[0][1], m[0][2], m[0][3],
            m[1][0], m[1][1], m[1][2], m[1][3],
            m[2][0], m[2][1], m[2][2], m[2][3]);

        if(cramer.isSolvable()) {
        	long start1 = System.nanoTime();
            double[] resCramer = cramer.solve();
            long end1 = System.nanoTime();
            System.out.printf("Cramer solution took %.6f seconds%n", (end1 - start1) / 1e9);
            System.out.printf("Cramer: x=%.6f y=%.6f z=%.6f%n", resCramer[0], resCramer[1], resCramer[2]);
            
        } else {
            System.out.println("Cramer: No solution.");
        }

        if(gauss.isSolvable()) {
        	long start2 = System.nanoTime();
            double[] resGauss = gauss.solve();long end2 = System.nanoTime();
            System.out.printf("Gauss solution took %.6f seconds%n", (end2 - start2) / 1e9);
            System.out.printf("Gauss: x=%.6f y=%.6f z=%.6f%n", resGauss[0], resGauss[1], resGauss[2]);
        } else {
            System.out.println("Gauss: No solution.");
        }
        
        
    }}
