import org.junit.Assert;

import java.time.YearMonth;

public class Test {
    @org.junit.Test
    public void mathOperators() {
        int[] arr1 = {Integer.MIN_VALUE, -9823, -100, -1, 0, 1, 100, 89238, Integer.MAX_VALUE};

        for (int element1 : arr1) {
            for (int element2 : arr1) {
                // Comparison operators
                Assert.assertEquals(Branchless.greaterThan(element1, element2) == -1, element1 > element2);
                Assert.assertEquals(Branchless.greaterThanOrEqualTo(element1, element2) == -1, element1 >= element2);
                Assert.assertEquals(Branchless.lessThan(element1, element2) == -1, element1 < element2);
                Assert.assertEquals(Branchless.lessThanOrEqualTo(element1, element2) == -1, element1 <= element2);
                Assert.assertEquals(Branchless.equals(element1, element2) == -1, element1 == element2);

                // Other math functions
                Assert.assertEquals(Branchless.min(element1, element2), Math.min(element1, element2));
                Assert.assertEquals(Branchless.max(element1, element2), Math.max(element1, element2));
            }

            Assert.assertEquals(Branchless.sign(element1), Integer.compare(element1, 0));
            Assert.assertEquals(Branchless.abs(element1), Math.abs(element1));
        }
    }

    @org.junit.Test
    public void daysInMonth() {
        for (int year = 0; year < 2000; year++) {
            for (int month = 1; month <= 12; month++) {
                YearMonth yearMonthObject = YearMonth.of(year, month);
                int daysInMonth = yearMonthObject.lengthOfMonth();
                int branchlessDaysInMonth = Branchless.daysInMonth(month, year);
                Assert.assertEquals(branchlessDaysInMonth, daysInMonth);
            }
        }
    }

    @org.junit.Test
    public void grade() {
        for (int i = 0; i < 101; i++) {
            Assert.assertEquals(Branchless.percentToGrade(i), Basic.percentToGrade(i));
        }

    }

}
