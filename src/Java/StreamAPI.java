package Java;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Locale;
import java.util.Map;
import java.util.stream.Collectors;
import java.util.stream.Stream;


/*
*** Java 8 streams can’t be reused.
***
 */
public class StreamAPI {

    public Stream<Integer> emptyStream(){
        return Stream.empty();
    }

    public Stream<Integer> streamOfInteger(){
        return Stream.of(1, 2);
    }

    public List<List<String>> getAnagrams(){
        List<String> stringList = Arrays.asList( "eat","tea","tan","ate","nat","bat");
        Map<String, List<String>> groupedAnagrams = stringList.stream()
                .collect(Collectors.groupingBy(element ->
                        element.toLowerCase(Locale.ROOT)
                                .chars()
                                .sorted()
                                .collect(   StringBuilder::new,
                                            StringBuilder::appendCodePoint,
                                            StringBuilder::append).toString()));

        System.out.println(groupedAnagrams.keySet());
        return new ArrayList<>(groupedAnagrams.values());
    }

    public void test(){
        List<String> stringList = Arrays.asList( "eat","tea","tan","ate","nat","bat");
        stringList.stream().map(x -> x.toLowerCase()).collect(Collectors.toList());
    }



}
