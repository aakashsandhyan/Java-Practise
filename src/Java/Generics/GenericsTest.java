package Java.Generics;

import org.junit.jupiter.api.Test;

import java.util.Arrays;
import java.util.Comparator;
import java.util.Optional;
import java.util.stream.Collectors;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertTrue;

public class GenericsTest {

    @Test
    void integerBoxTest(){
        Box<Integer> intBox = new Box<>();
        intBox.set(10);
        assertTrue(intBox.get() instanceof Integer);
        assertTrue(Util.genericMethod(10) instanceof Integer);
        assertTrue(Util.genericMethod(10.0) instanceof Double);

        int[] arr = {12, 35, 1, 10, 34, 1};
        Optional<Integer> ans = Arrays.stream(arr).boxed().sorted(Comparator.reverseOrder()).limit(2).skip(1).findFirst();
        assertEquals(34, ans.get());

        int[] arr2 = {10, 15, 8, 49,25, 98, 98, 32, 15};
                Arrays.stream(arr2)
                        .boxed()
                        .collect(Collectors.groupingBy(element -> element, Collectors.counting()))
                        .entrySet().stream()
                        .filter(entry -> entry.getValue() > 1)
                        .forEach(System.out::println);
    }
}
