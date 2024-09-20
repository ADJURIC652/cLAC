package probabilitypackage;

import java.math.BigDecimal;

public class Calculator {
    public static int calculateSpins(double p) {
        BigDecimal cumulativeProb = BigDecimal.ZERO;
        int k = 1;

        while (cumulativeProb.compareTo(BigDecimal.valueOf(0.5)) < 0) {
            BigDecimal term = BigDecimal.valueOf(1 - p).pow(k - 1).multiply(BigDecimal.valueOf(p));
            cumulativeProb = cumulativeProb.add(term);
            k++;
        }

        return k;
    }

    public static double calculateNoSuccessProbability(int spinsMade, double probability){
        return Math.pow(1 - probability, spinsMade);
    }
}

