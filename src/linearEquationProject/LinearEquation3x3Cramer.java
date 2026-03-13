package linearEquationProject;

public class LinearEquation3x3Cramer {
	private static final double EPSILON = 1e-10;
    private double a, b, c, jj;
    private double d, e, f, k;
    private double g, h, ii, l;

    public LinearEquation3x3Cramer(double a, double b, double c, double jj,
                              double d, double e, double f, double k,
                              double g, double h, double ii, double l) {
        this.a = a; this.b = b; this.c = c; this.jj = jj;
        this.d = d; this.e = e; this.f = f; this.k = k;
        this.g = g; this.h = h; this.ii = ii; this.l = l;
    }

    private double determinant(double a, double b, double c,
                               double d, double e, double f,
                               double g, double h, double ii) {
        return a*(e*ii - f*h) - b*(d*ii - f*g) + c*(d*h - e*g);
    }

    public boolean isSolvable() {
    	return Math.abs(determinant(a, b, c, d, e, f, g, h, ii)) > EPSILON;
    }

    public double[] solve() {

        double D  = determinant(a, b, c, d, e, f, g, h, ii);
        double Dx = determinant(jj, b, c, k, e, f, l, h, ii);
        double Dy = determinant(a, jj, c, d, k, f, g, l, ii);
        double Dz = determinant(a, b, jj, d, e, k, g, h, l);

        double x = Dx / D;
        double y = Dy / D;
        double z = Dz / D;

        return new double[]{x, y, z};
    }
}
