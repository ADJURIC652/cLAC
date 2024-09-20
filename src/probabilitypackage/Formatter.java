package probabilitypackage;

import java.text.DecimalFormat;

public class Formatter {
    public static String formatPercentage(double value){
        DecimalFormat df = new DecimalFormat("#0.##%");
        return df.format(value);
    }
}
