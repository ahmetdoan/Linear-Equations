package linearEquationProject;

public class SolverTester {

    static void runTest(String testName, String equation,
                        double a, double  b, double c, double j,
                        double d, double e,double f, double k,
                        double g, double h,double ii, double l ,
                        String expected ) 
    {

        System.out.println("************************************************************");
        System.out.println("TEST: " + testName);
        System.out.println("  Equation: \n" + equation);
        System.out.println("  Expected  : " + expected);
        System.out.println("------------------------------------------------------------");

        LinearEquation3x3Cramer cramer = new LinearEquation3x3Cramer(a, b, c, j, d, e, f, k, g, h, ii, l);
        System.out.print("  Cramer    : ");
        if (cramer.isSolvable( )) {
            double[] r =cramer.solve();
            System.out.printf("x = %.4f,  y = %.4f,  z = %.4f%n", r[0], r[1], r[2]);
        } else {
            System.out.println(" No unique solution (singular matrix).");
        }

        LinearEquation3x3Gauss gauss= new LinearEquation3x3Gauss(a, b, c, j, d, e, f, k, g, h, ii, l);
        System.out.print("  Gauss     : ");
        if (gauss.isSolvable()) {
            double[] r = gauss.solve();
            System.out.printf("x =%.4f,  y = %.4f,  z = %.4f%n", r[0], r[1], r[2]);
        } else {
            System.out.println("No unique solution (singular matrix).");
        }

         System.out.println();
    }

    public static void main(String[] args) {

        System.out.println("==========================================================");
        System.out.println ("       		   3x3 LINEAR EQUATION SOLVER — TEST          ");
        System.out.println("==========================================================");
        System.out.println();
        
        runTest(
            "Test 1 — İnteger solution",
            "2x + y - z = 8  \n-3x - y + 2z = -11  \n-2x + y + 2z = -3",
             2,  1, -1,   8,
            -3, -1,  2, -11,
            -2,  1,  2,  -3,
            "x = 2,  y = 3,  z = -1"
        );

        runTest(
            "Test 2 — Float solution",
            "x + y + z = 6  \nx - y + z = 3  \nx + 2y - z = 3",  
            1,  1,  1,  6,
             1, -1,  1,  3,  
             1,  2, -1,  3,
            "x = 2,25,  y = 1,5,  z = 2,25"
        );

        runTest(
            "Test 3 — No solution",
            "x + y + z = 62  \nx + 2y + 2z = 123  \nx + 3y + 3z = 18",
             1, 1, 1,  62,
             1, 2, 2, 123,
             1, 3, 3,  18,
            "No unique solution"
        );

        // (floating point test)
        runTest(
            "Test 4 —Epsilon test",
            "0.0001x + y + z = 2  \nx + y + z = 3  \nx + y + 2z = 4",
            0.0001, 1, 1, 2,
            1,      1, 1, 3,
            1,      1, 2, 4,
            "x ≈ 1,  y ≈ 1,  z ≈ 1"
        );

        System.out.println("============================================================");
        System.out.println("                     TEST COMPLETE                        ");
        System.out.println("============================================================");
    }}