package org.rishudesign.com.javastreams;
import java.util.*;
import java.util.Arrays;
import java.util.stream.Collectors;

public class Practice {
    public static void main(String args[]){

        // capital letter names
       List<String> name = Arrays.asList("rishu","rana");
       List<String>capitalname = name
               .stream()
               .map((String names) -> names.toUpperCase())
               .collect(Collectors.toList());
       for(String names : capitalname){
           System.out.println(names);
       }

       // even numbers
        List<Integer> list = Arrays.asList(1,2,3,4,5,8,9,0);
        List<Integer> evenlist = list.stream().filter((Integer num) ->(num%2==0)).collect(Collectors.toList());
        for(Integer num : evenlist){
            System.out.println(num);
        }

        // find first element in with letter A as starting letter
        List<String> ele = Arrays.asList("Anmol","rishu","Abhishek");
        Optional<String> firstele = ele.stream().filter((String names) -> names.charAt(0)=='A').findFirst();
        System.out.println(firstele.get());

        // remove duplicates from list
        List<Integer> numbers = Arrays.asList(1, 2, 2, 3, 4, 3, 5);

        List<Integer> uniqueNumbers = numbers.stream()
                .distinct() // removes duplicates
                .collect(Collectors.toList());

        System.out.println(uniqueNumbers);

        //Convert a list of string numbers to a list of integers.
        List<String> li = Arrays.asList("1","2","3","4");
        List<Integer> converted = li.stream().map((String num) -> Integer.parseInt(num)).collect(Collectors.toList());
        for(Integer ans: converted){
            System.out.println("string to int: " + ans);
        }


    }
}
