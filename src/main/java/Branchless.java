// Java class of standard functions without branching
public class Branchless {
    public static int greaterThan(int a, int b) {
        int differentSign = (a ^ b) >> 31;
        int bSign = b >> 31;

        int aIsGreater = (b - a) >> 31;

        return (~differentSign & aIsGreater) |
               (differentSign & bSign);
    }

    public static int greaterThanOrEqualTo(int a, int b) {
        return ~greaterThan(b, a);
    }

    public static int lessThan(int a, int b) {
        return greaterThan(b, a);
    }

    public static int lessThanOrEqualTo(int a, int b) {
        return ~greaterThan(a, b);
    }

    public static int equals(int a, int b) {
        return ~greaterThan(a, b) & ~greaterThan(b, a);
    }

    public static int conditionalPut(int condition, int passValue, int defaultValue) {
        return (condition & passValue) | (~condition & defaultValue);
    }

    public static int max(int a, int b) {
        return conditionalPut(greaterThan(a, b), a, b);
    }

    public static int min(int a, int b) {
        return conditionalPut(greaterThan(b, a), a, b);
    }

    public static int abs(int a) {
        int isNegative = a >> 31;
        return conditionalPut(isNegative, -a, a);
    }

    public static int sign(int a) {
        int positive = greaterThan(a, 0);
        int sign = a >> 31;

        return (positive & 1) | (sign);
    }

    private static int[] dayDifference = new int[12];
    public static int daysInMonth(int month, int year) {
        int div25 = year % 25;
        int divisor2 = (((div25^-div25) >> 31) & -12) + 16;
        int div = year % divisor2;
        dayDifference[1] = ((div^-div) >> 31) -1;
        int monthOffset = (7 - month) >> 31;
        return 30 + ((month + monthOffset) & 1) + dayDifference[month - 1];
    }
}
