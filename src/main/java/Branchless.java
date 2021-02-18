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

    public static int max(int a, int b) {
        int aIsGreater = greaterThan(a, b);

        return (aIsGreater & a) | (~aIsGreater & b);
    }

    public static int min(int a, int b) {
        int aIsGreater = greaterThan(a, b);

        return (aIsGreater & b) | (~aIsGreater & a);
    }
}
