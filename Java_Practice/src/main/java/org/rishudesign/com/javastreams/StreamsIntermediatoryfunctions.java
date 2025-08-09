package org.rishudesign.com.javastreams;
import java.util.*;
import java.util.stream.Collectors;
import java.util.stream.IntStream;
import java.util.stream.Stream;

public class StreamsIntermediatoryfunctions {

    public static void main(String args[]) {


        Stream<String> nameStream = Stream.of("Hi", "My", "Name", "is", "Rishu", "Rana");

        // filter function
        Stream<String> filteredStream = nameStream.filter((String name) -> name.length() >= 4);

        List<String> filteredNameList = filteredStream.collect(Collectors.toList());

        for(String name : filteredNameList){
            System.out.println(name);
        }

        // map function
        Stream<String> CapitalStream = Stream.of("MY","NAME","IS","RISHU");

        List<String> smallercaseletternames = CapitalStream
                                             .map((String name) -> name.toLowerCase())
                                             .collect(Collectors.toList());

        for(String name: smallercaseletternames){
            System.out.println(name);
        }

        // flatmap
        List<List<String>> sentenceList = Arrays.asList(
                Arrays.asList("I","LOVE","CODING"),
                Arrays.asList("I","LOVE","JAVA"),
                Arrays.asList("THIS","IS","GREAT")
        );

        List<String> flatlist = sentenceList
                .stream()
                .flatMap((List<String>sentence) ->sentence.stream())
                .collect(Collectors.toList());

        for(String list: flatlist){
            System.out.println(list);
        }

        // distinct
        Integer[] arr = {1,5,3,3,2,4,2};
        Stream<Integer> arrStream = Arrays
                .stream(arr)
                .distinct();

        for(Integer ele: arr){
            System.out.println(ele);
        }

        //sorted
        Integer[] arr2 = {1,4,10,3,9,8,6};
        Stream<Integer> integerStream = Arrays.stream(arr2).sorted();

        for(Integer ele: arr2){
            System.out.println(ele);
        }

        // sorting with comparator
        Integer[] arr3 = {1,2,4,5,6,7,8,9};
        Stream<Integer> desstream = Arrays.stream(arr3).sorted((Integer val1,Integer val2) -> val2-val1);  // this will generate a stream which will sort them in descending order

        //mapToInt
        List<String> numbers = Arrays.asList("1","2","3","4");
        IntStream streams = numbers.stream().mapToInt((String val) -> Integer.parseInt(val));
        int [] nums = streams.toArray();
        // here we cannnot do List<int> because always work in Integer wrapper classes


        // for each terminal function
        List<Integer> num = Arrays.asList(1,3,6,3,7,2,4);
                    num.stream()
                    .filter((Integer n) -> n>3)
                .distinct()
                .forEach((Integer val) -> System.out.println(val));



    }
}
