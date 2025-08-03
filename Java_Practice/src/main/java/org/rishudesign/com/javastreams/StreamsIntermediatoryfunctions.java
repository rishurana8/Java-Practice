package org.rishudesign.com.javastreams;
import java.util.*;
import java.util.stream.Collectors;
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

    }
}
