
import java.util.*;

public class LambdaSort {
    public static void main(String[] args) {
        List<String> words = Arrays.asList("Banana", "Apple", "Cherry", "Date");
        Collections.sort(words, (a, b) -> a.compareToIgnoreCase(b));
        System.out.println("Sorted List: " + words);
    }
}
