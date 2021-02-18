import java.util.List;
import java.util.Random;
import java.util.stream.Collectors;
import java.util.stream.IntStream;

public class Test {
    private final static int NUM_ELEMENTS = 1000;
    private final static int MAX_VALUE = Integer.MAX_VALUE;

    public static void main(String[] args) {
        Random random = new Random();

        List<Integer> list = IntStream.range(0, NUM_ELEMENTS)
                .map(i -> random.nextInt(MAX_VALUE))
                .boxed()
                .collect(Collectors.toList());

        for (int element : list) {
            for (int element2 : list) {
                boolean max1 = Branchless.equals(element, element2) == -1;
                boolean max2 = element == element2;
                if (max1 != max2) {
                    System.out.println("Error");
                    System.exit(1);
                }
            }
        }

        System.out.println("Completed sucessfully");
    }
}
