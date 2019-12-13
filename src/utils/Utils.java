package utils;

public class Utils {

    public static double getInterestOnBalance(Double startBalance){
        if(startBalance < 50000){
            return 5.0;
        }else if (startBalance >= 50000 && startBalance <= 100000){
                return 5.5;
        }
        return 6.0;
    }
}
