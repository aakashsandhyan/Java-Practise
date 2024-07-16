package Java;

public class Main {

    public static void main(String args[]){
        StreamAPI streamAPI = new StreamAPI();
//        Stream<Integer> stream = streamAPI.emptyStream();
//        if(stream.collect(Collectors.toList()).isEmpty()){
//            System.out.println("Stream is empty!!");
//        }
//
//        System.out.println("stream of integers: " + streamAPI.streamOfInteger().collect(Collectors.toList()));
//
//        String[] arr = new String[]{"a", "b", "c"};
//        Stream<String> streamOfArrayFull = Arrays.stream(arr);
//        Stream<String> streamOfArrayPart = Arrays.stream(arr, 1, 3);
//
//        System.out.println("Full stream of chars: " + streamOfArrayFull.collect(Collectors.toList()));
//        System.out.println("Full stream of chars: " + streamOfArrayPart.collect(Collectors.toList()));
//
//        Stream<String> generatedStream = Stream.generate(() -> "element").limit(5);
//        System.out.println("generated stream" + generatedStream.collect(Collectors.toList()));
//
//        Stream<Integer> generatedStreamInteger = Stream.iterate(40, n -> n + 8).limit(5);
//        System.out.println("generated stream integer" + generatedStreamInteger.collect(Collectors.toList()));
//
//        IntStream.range(0,5).forEach(i -> System.out.print(i + "\t"));
//        System.out.println();
//
//        IntStream charsStream = "Aakash".toLowerCase(Locale.ROOT).chars().sorted();
//        charsStream.forEach(c -> System.out.print(c + "\t"));
//        System.out.println();
//
//        Stream<String> streamX =
//                Stream.of("a", "b", "c").filter(element -> element.contains("b"));
//        Optional<String> anyElement = streamX.findAny();
//        System.out.println(anyElement.orElse("empty"));
//
//        //not allowed using the same stream again
////        Optional<String> firstElement = streamX.findFirst();
//
//        System.out.println(streamAPI.getAnagrams());

    }
}
