package linearEquationProject;

public class LinearEquation3x3Gauss {
	private static final double EPSILON = 1e-10;
    private double[][] mat = new double[3][4]; 

    public LinearEquation3x3Gauss(double a, double b, double c, double jj,
                                  double d, double e, double f, double k,
                                  double g, double h, double ii, double l) 
    {
        mat[0][0] = a; mat[0][1] = b; mat[0][2] = c; mat[0][3] = jj;
        mat[1][0] = d; mat[1][1] = e; mat[1][2] = f; mat[1][3] = k;
        mat[2][0] = g; mat[2][1] = h; mat[2][2] = ii; mat[2][3] = l;
    }

    public boolean isSolvable() {
        double det = mat[0][0]*(mat[1][1]*mat[2][2]-mat[1][2]*mat[2][1])
                   - mat[0][1]*(mat[1][0]*mat[2][2]-mat[1][2]*mat[2][0])
                   + mat[0][2]*(mat[1][0]*mat[2][1]-mat[1][1]*mat[2][0]);
        return Math.abs(det) > EPSILON;
    }

    public double[] solve() {
       

        double[][] m = new double[3][4];
        for(int i=0;i<3;i++)
            System.arraycopy(mat[i], 0, m[i], 0, 4);

       
        for(int i=0;i<3;i++) {
          
            int max = i;
            for(int k=i+1;k<3;k++)
                if(Math.abs(m[k][i]) > Math.abs(m[max][i]))
                    max = k;
            double[] temp = m[i]; m[i] = m[max]; m[max] = temp;

          
            for(int k=i+1;k<3;k++) {
                double factor = m[k][i] / m[i][i];
                for(int j=i;j<4;j++)
                    m[k][j] -= factor * m[i][j];
            }
        }

        
        double[] x = new double[3];
        for(int i=2;i>=0;i--) {
            x[i] = m[i][3];
            for(int j=i+1;j<3;j++)
                x[i] -= m[i][j]*x[j];
            x[i] /= m[i][i];
        }

        return x;
    }
}
