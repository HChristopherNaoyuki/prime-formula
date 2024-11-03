package Solutions;

public class FormulaCalculator
{

    /**
     * Calculate the value of p_n as per the given formula.
     * @param n the input parameter for the formula.
     * @return the calculated value of p_n.
     */
    public static double calculatePn(int n)
    {
        double pn = 0.0;
        
        // Outer sum over k1 from 1 to 1 + n^2
        for (int k1 = 1; k1 <= 1 + n * n; k1++)
        {
            double innerSumK2 = 0.0;

            // Sum over k2 from 2 to k1 - 1
            for (int k2 = 2; k2 < k1; k2++)
            {
                double innerSumK3 = 0.0;

                // Sum over k3 from 1 to k2 - 1
                for (int k3 = 1; k3 < k2; k3++)
                {
                    // Calculate cos^2(π * k2 / k3)
                    double cosValue = Math.cos(Math.PI * k2 / k3);
                    innerSumK3 += cosValue * cosValue;  // Square of cos
                }
                
                innerSumK2 += innerSumK3;  // Add k3 summation result to k2 summation
            }
            
            // Calculate the cotangent inverse component
            double argument = 1 - n + innerSumK2;
            double cotInverse = Math.atan(1.0 / argument);  // cot^(-1)(x) = atan(1/x)
            
            // Complete the k1 term with absolute value
            double termK1 = (2 / Math.PI) * cotInverse;
            pn += Math.abs(termK1);  // Add to total sum for pn
        }
        
        return pn;
    }

    public static void main(String[] args)
    {
        int n = 12; // Example value for n
        double result = calculatePn(n);
        System.out.println("The value of p_" + n + " is: " + result);
    }
}
