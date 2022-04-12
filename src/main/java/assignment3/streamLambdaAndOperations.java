package assignment3;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Optional;
import java.util.Random;
import java.util.stream.Collectors;
import java.util.stream.IntStream;
import java.util.stream.Stream;

public class streamLambdaAndOperations {


  public static void main(String[] args) {



    // Stream Examples

    Stream<Integer> stream = Stream.of(1, 2, 3, 4, 5, 6, 7, 8, 9, 0);

    stream.forEach(p -> System.out.println(p));


    stream = Stream.of(new Integer[] {1, 2, 3, 4, 5, 6, 7, 8, 9, 0});
    stream.forEach(p -> System.out.println(p));


    List<Integer> list = new ArrayList<Integer>();
    for (int i = 1; i < 10; i++) {
      list.add(i);
    }

    stream = list.parallelStream();
    stream.forEach(p -> System.out.println(p));

    Stream<Integer> randomNumbers = Stream.generate(() -> (new Random()).nextInt(100));
    randomNumbers.limit(20).forEach(System.out::println);


    IntStream streamI = "12345_abcdefg".chars();
    streamI.forEach(p -> System.out.println(p));

    Stream<String> streamS = Stream.of("A$B$C".split("\\$"));
    streamS.forEach(p -> System.out.println(p));



    // Stream Collecting
    list = new ArrayList<Integer>();

    for (int i = 1; i < 10; i++) {
      list.add(i);
    }

    stream = list.stream();
    List<Integer> evenNumberList = stream.filter(i -> i % 2 == 0).collect(Collectors.toList());
    System.out.println(evenNumberList);

    list = new ArrayList<Integer>();

    for (int i = 1; i < 10; i++) {
      list.add(i);
    }

    stream = list.stream();
    Integer[] evenNumberArr = stream.filter(i -> i % 2 == 0).toArray(Integer[]::new);
    System.out.println(Arrays.toString(evenNumberArr));


    // Stream operations set up
    List<String> memberNames = new ArrayList<>();
    memberNames.add("Amitabh");
    memberNames.add("Shekhar");
    memberNames.add("Aman");
    memberNames.add("Rahul");
    memberNames.add("Shahrukh");
    memberNames.add("Salman");
    memberNames.add("Yana");
    memberNames.add("Lokesh");


    // Stream Operations from the list memberNames outputs only those that start with A
    memberNames.stream().filter((s) -> s.startsWith("S")).forEach(System.out::println);

    // Stream Operations map
    memberNames.stream().filter((s) -> s.startsWith("S")).map(String::toUpperCase)
        .forEach(System.out::println);

    // Stream Operations Sorting
    memberNames.stream().sorted().map(String::toUpperCase).forEach(System.out::println);

    // Stream Operations match
    boolean matchedResult = memberNames.stream().anyMatch((s) -> s.startsWith("S"));
    System.out.println(matchedResult);

    matchedResult = memberNames.stream().allMatch((s) -> s.startsWith("S"));
    System.out.println(matchedResult);

    matchedResult = memberNames.stream().noneMatch((s) -> s.startsWith("S"));
    System.out.println(matchedResult);


    // Stream Operations count
    long totalMatched = memberNames.stream().filter((s) -> s.startsWith("S")).count();
    System.out.println(totalMatched);

    // Stream Operations reduce
    Optional<String> reduced = memberNames.stream().reduce((s1, s2) -> s1 + "#" + s2);
    reduced.ifPresent(System.out::println);


  }


}
