public class Basic {
    public static char percentToGrade(int i) {
        if (i >= 90) {
            return 'A';
        } else if (i >= 80) {
            return 'B';
        } else if (i >= 70) {
            return 'C';
        } else if (i >= 60) {
            return 'D';
        } else {
            return 'F';
        }
    }
}
